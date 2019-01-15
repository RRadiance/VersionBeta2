package DatabaseInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.patriques.output.timeseries.data.StockData;

/**
 * Contains functions to add data into a database.
 * 
 * Note: It is important to enclose any code with Connection, ResultSet, or Statement
 * (and its subclass PreparedStatement) with a try-catch block. This is because these
 * classes implement AutoCloseable, meaning that the resources close once they leave
 * a try statement.
 * 
 * @author matthewhuynh
 *
 */
public class OpenManager extends SQLiteConnector{
	
//	public static void main (String[]args) {
//		createTable("data.db", "AAPL");
//	}
	
	/**
     * Connect to the test.db database
     * @return the Connection object
     * 
     * Do we need to close a connection when we are done with it?
     */
    private static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:databases/data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Successful connection");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
	
	/**
	 * Create a table with a specified stock name.
	 * In our program, we store each stock in an individual table.
	 * 
	 * @param fileName
	 * @param stockName
	 */
	public static void createTable(String fileName, String stockName) {
		// SQLite connection string
		String url = "jdbc:sqlite:databases/" + fileName;
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + stockName + " (\n"
                + "	id INTEGER PRIMARY KEY,\n"
                + "	date TEXT NOT NULL,\n"
                + "	open_price INTEGER,\n"
                + " close_price INTEGER,\n"
                + " adjusted_close INTEGER,\n"
                + " low_price INTEGER,\n"
                + " high_price INTEGER,\n"
                + " volume INTEGER,\n"
                //+ " dividend_amount INTEGER,\n"
                //+ " split_coefficient INTEGER,\n"
                + " macd INTEGER,\n"
                + " macd_signal INTEGER,\n"
                + " macd_histogram INTEGER,\n"
                + " minus_di INTEGER,\n"
                + " plus_di INTEGER,\n"
                + " atr INTEGER,\n"
                + " ema INTEGER,\n"
                + " sma INTEGER\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}

	/**
	 * 
	 * @param fileName
	 * @param stockName
	 * @param stockData
	 */
	public static void addTimeSeriesData(String fileName, String stockName, List<StockData> stockData) {
		// SQLite connection string
		String url = "jdbc:sqlite:databases/" + fileName;
		
		// Create a new table if the stock table does not yet exist
		if (!checkTableExists(stockName)) {
			createTable("data.db", stockName);
			System.out.println("Adding table for " + stockName + " ..");
		}
		System.out.println("The table should exist for " + stockName);
		
		/*Calculate how many days it has been since the last entry in the database
		 * We get the size of the StockData list. Using indices, we add the elements starting
		 * at the last index first (we reverse the order of the data, since it originally gives
		 * us the most recent data first). We use a for loop to do this. We only add up to the number 
		 * of days it has been since the last entry. This should ensure that we do not end up
		 * accessing and overwriting more data than we need to.
		 * 
		 * In our for loop, we continue to build a SQL statement transaction.
		 * At the end of the for loop, we execute our SQL transaction.
		 * 
		 */
		Connection connection = null;
		try {
			connection = connect();
			connection.setAutoCommit(false); // so we can use SQL Transaction feature
			
			int daysToFill = stockData.size() - 0; // stores the difference in days of data
			// should subtract by the number of days already stored in the database
			for(int i = daysToFill; i > 0; i--) {
				// SQL statement for creating a new table
				String sql = "INSERT INTO " + stockName + " ("
						+ "date, open_price, close_price, adjusted_close, low_price, high_price, "
						+ "volume) VALUES ("
						+ "?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				StockData stock = stockData.get(i - 1); // accesses the "indices" of the list
				pstmt.setString(1,  stock.getDateTime().toString());
				// careful, is there a way to make this integer, so no precision can possibly be lost?
				pstmt.setDouble(2,  stock.getOpen());
				pstmt.setDouble(3, stock.getClose());
				pstmt.setDouble(4,  stock.getAdjustedClose());
				pstmt.setDouble(5,  stock.getLow());
				pstmt.setDouble(6,  stock.getHigh());
				pstmt.setDouble(7,  stock.getHigh());
				
				pstmt.executeUpdate();
			}
			System.out.println("About to commit ...");
			connection.commit(); // commits the transaction
			System.out.println("Successful commit");
		} catch (SQLException e1) {
			try {
				// rollback the transaction if it fails (reverts any changes)
				if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(e1.getMessage());
		} finally {
            try {
            	// Closes the connection in case it wasn't autoclosed
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e3) {
                System.out.println(e3.getMessage());
            }
        }
		
	
		
//		try (Connection conn = this.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, stockData.getDateTime());
//            pstmt.setDouble(2, capacity);
//            pstmt.setInt(parameterIndex, x);
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//		
		
		/* String sql = "INSERT INTO " + stockName +  " (date) VALUES (?)";
		
		try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "TESTING");
            pstmt.executeUpdate();
            System.out.println("Successfully inserted data");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        */ 

	}
	
	/**
	 * Given a List<StockData> list, we iterate through the list
	 * and generate 
	 * 
	 * 
	 */

    
    /**
     * Check if a stock exists as a table in the database.
     * Return true if it does, else false.
     * 
     * @return boolean
     */
    private static Boolean checkTableExists(String tableName) {
        String sql = "SELECT count(*) FROM sqlite_master WHERE type='table' and "
        		+ "name='" + tableName + "';";
        
        try (Connection conn = connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){;
            
             // If the table does not exist, the Select statement should return 0
             while(rs.next()) {
            	 if(rs.getInt("count") == 0) {
            		 System.out.println("No table exists for stock " + tableName);
            	 }
            	 return rs.getInt("count") == 1;
             };
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
    }
    
    /**
     * Used to close a ResultSet, Statement, or Connection.
     * All three classes above implement Wrapper and Autocloseable. 
     * We use this function if the above classes aren't surrounded
     * in a try-catch statement, as we need to close the resources manually.
     * 
     */
    private static void closeResource() {
    	//https://stackoverflow.com/questions/2225221/closing-database-connections-in-java
    	
    }

}

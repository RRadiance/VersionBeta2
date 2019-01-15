package DatabaseInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Contains functions to add data into a database
 * 
 * @author matthewhuynh
 *
 */
public class OpenManager extends SQLiteConnector{
	
	public static void main (String[]args) {
		createTable("data.db", "AAPL");
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
                + " low_price INTEGER,\n"
                + " high_price INTEGER,\n"
                + " volume INTEGER,\n"
                + " adjusted_close INTEGER,\n"
                + " dividend_amount INTEGER,\n"
                + " split_coefficient INTEGER,\n"
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

	public static void addTimeSeriesData(String fileName, String stockName) {
		// SQLite connection string
		String url = "jdbc:sqlite:databases/" + fileName;

		// SQL statement for creating a new table
		String sql = "INSERST INTO " + stockName + " ("
				+ "date, open_price, close_price, low_price, high_price, volume,"
				+ "adjusted_close, dividend_amount, split_coefficient) VALUES ("
				+ "%s, %d, %d, %d, %d, %d, %d, %d, %d, %d);";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}

package DatabaseInterface;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connects to the specified SQLite database. If the database does not exist,
 * create the database.
 * 
 * This class uses the JDBC driver to interact with SQL.
 * 
 * @author matthewhuynh
 *
 */
public class SQLiteConnector {
	
	/**
     * Connect to the specified database. If the database does not exist,
     * creates the database. Returns true if the database already existed,
     * else false.
     * 
     * @param fileName the database file name
     * @return a boolean if the 
     */
    public static Boolean createNewDatabase(String fileName) {
 
    	// We use a relative file path
        String url = "jdbc:sqlite:databases/" + fileName;
 
        try (Connection conn = DriverManager.getConnection(url)) {
        	// If the database does not exist
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                return false;
            }
            return true;
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
 
    /**
     * Used to test this class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("data.db");
    }
}

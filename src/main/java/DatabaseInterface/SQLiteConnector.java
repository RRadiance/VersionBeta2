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
     * creates the database. 
     * 
     * @param fileName the database file name
     * 
     */
    public static void connect(String fileName) {
        Connection conn = null;
        try {
        	// We use a relative file path
            String url = "jdbc:sqlite:databases/" + fileName;
            
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    
//	/**
//     * Create a database with the specified name as fileName.
//     * Return true if the creation is successful, else false.
//     * 
//     * @param fileName the database file name
//     * @return boolean
//     */
//    public static Boolean createNewDatabase(String fileName) {
// 
//    	// We use a relative file path
//        String url = "jdbc:sqlite:databases/" + fileName;
// 
//        try (Connection conn = DriverManager.getConnection(url)) {
//            if (conn != null) {
//                DatabaseMetaData meta = conn.getMetaData();
//                System.out.println("The driver name is " + meta.getDriverName());
//                System.out.println("A new database has been created.");
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//    }
 
    /**
     * Used to test this class
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // createNewDatabase("data.db");c
    	connect("data.db");
    }
}


package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/studentdb";  // Replace with your DB details
    private static final String USER = "root";  // Your MySQL username
    private static final String PASSWORD = "root";  // Your MySQL password

    public static Connection getCon() throws SQLException {
        Connection con = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
        }
        return con;
    }
}

package connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/premdb";  
    private static final String USER = "root";  
    private static final String PASSWORD = "root";  

    public static Connection getCon() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
        }
        return con;
    }
}
package Entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    
    public static void main(String[] args) {
        // Database connection details
        
        String url = "jdbc:mysql://localhost:3306/acmeplexdb";
        String user = "root";  
        String password = "Jeromebarcelona01!";  // Replace with your MySQL password

        // Establish the connection
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // If connection is successful, print this message
            if (conn != null) {
                System.out.println("Connected to the database successfully!");
            }
        } catch (SQLException e) {
            // If there's an error, print the exception message
            e.printStackTrace();
        }
    }
}

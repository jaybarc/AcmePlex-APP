package com.example.AcmePlex.backend.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/acmeplexdb";
    private static final String USER = "root"; 
    private static final String PASSWORD = "Goldexperience123!"; 

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
            throw e;
        }
    }
}

package com.example.AcmePlex.backend.Database;


import java.sql.*;
import java.time.LocalDate;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new user in the database
    public void createUser(String username, String password, String firstName, String lastName, String email, LocalDate date,  double bankBalance) throws SQLException {
        String query = "INSERT INTO Users (userEmail, username, password, firstName, lastName, registrationDate, bankBalance) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, username);
            stmt.setString(3, password);
            stmt.setString(4, firstName);
            stmt.setString(5, lastName);
            stmt.setDate(6, Date.valueOf(date));
            stmt.setDouble(7, bankBalance);
            stmt.executeUpdate();
        }
    }
    
    public LocalDate getregisrationDate(String username) throws SQLException {
        String query = "SELECT registrationDate FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDate("registrationDate").toLocalDate();
                }
            }
        }
        return null;
    }
    
    public void setregisrationDate(String username, LocalDate date) throws SQLException {
        String query = "UPDATE Users SET registrationDate = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDate(1, Date.valueOf(date));
            stmt.setString(2, username);
            stmt.executeUpdate();
        }
    }
    
    public void setBankBalance(String username, double bankBalance) throws SQLException {
        String query = "UPDATE Users SET bankBalance = ? WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, bankBalance);
            stmt.setString(2, username);
            stmt.executeUpdate();
        }
    }
    
    public double getBankBalance(String username) throws SQLException {
        String query = "SELECT bankBalance FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("bankBalance");
                }
            }
        }
        return 0.0;
    }
    
    // Get email from username
    public String getEmail(String username) throws SQLException {
        String query = "SELECT userEmail FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("userEmail");
                }
            }
        }
        return null;
    }

   

    // Update a user's email
    public void updateUserEmail(int userId, String newEmail) throws SQLException {
        String query = "UPDATE Users SET userEmail = ? WHERE UserID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, userId);
            stmt.executeUpdate();
        }
    }

    // Delete a user by ID
    public void deleteUser(int userId) throws SQLException {
        String query = "DELETE FROM Users WHERE UserID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }
    public boolean authenticate(String username, String password) throws SQLException {
        String query = "SELECT password FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("password").equals(password);
                }
            }
        }
        return false;
    }
}
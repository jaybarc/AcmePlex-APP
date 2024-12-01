package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.RegisteredUser;
import com.example.AcmePlex.backend.Entity.User;
import com.example.AcmePlex.backend.Entity.Payment;
import com.example.AcmePlex.backend.Entity.UserBankingInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new user in the database
    public void addUser(RegisteredUser user) throws SQLException {
        String query = "INSERT INTO Users (UserID, userEmail, username, password, " +
                "firstName, lastName, address, bankID, cardNumber, dateToPayFee) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, user.getUserEmail());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getFirstName());
            stmt.setString(6, user.getLastName());
            stmt.setString(7, null);
            stmt.setString(8, null);
            stmt.setString(9, null);
            stmt.setDate(10, null);
            stmt.executeUpdate();
        }
    }

    // Retrieve all users from the database
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT UserID, userEmail, username, password, firstName, lastName, address, " +
                "bankID, dateToPayFee FROM Users";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                RegisteredUser user = new RegisteredUser(
                        rs.getInt("UserID"),
                        true,
                        rs.getString("userEmail"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("address"),
                        new UserBankingInfo(rs.getString("address"),rs.getString("firstName"), rs.getString("bankID"), rs.getString("cardNumber")),
                        rs.getDate("dateToPayFee")
                );
                users.add(user);
            }
        }
        return users;
    }

    // Retrieve a single user by ID
    public User getUserById(int userId) throws SQLException {
        String query = "SELECT UserID, userEmail, username, password, firstName, lastName, address, \" +\n" +
                "                \"bankID, dateToPayFee FROM Users WHERE UserID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new RegisteredUser(
                            rs.getInt("UserID"),
                            true,
                            rs.getString("userEmail"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("address"),
                            new UserBankingInfo(rs.getString("address"),rs.getString("firstName"), rs.getString("bankID"), rs.getString("cardNumber")),
                            rs.getDate("dateToPayFee")
                    );
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
}
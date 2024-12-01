package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.Payment;
import com.example.AcmePlex.backend.Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new payment in the database
    public void addPayment(Payment payment, int userID) throws SQLException {
        String paymentQuery = "INSERT INTO Payments (paymentID, userID, amount, paymentDate, address, customerName, bankID, cardNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String userUpdateQuery = "UPDATE Users SET address = ?, customerName = ?, bankID = ?, cardNumber = ? WHERE UserID = ?";

        try (PreparedStatement paymentStmt = connection.prepareStatement(paymentQuery);
             PreparedStatement userUpdateStmt = connection.prepareStatement(userUpdateQuery)) {

            // Insert payment
            paymentStmt.setInt(1, payment.getPaymentID());
            paymentStmt.setInt(2, userID);
            paymentStmt.setDouble(3, payment.getAmount());
            paymentStmt.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            paymentStmt.setString(5, payment.getPaymentInfo().getCustomerName());
            paymentStmt.setString(6, payment.getPaymentInfo().getBankID());
            paymentStmt.setString(7, payment.getPaymentInfo().getCardNumber());
            paymentStmt.executeUpdate();

            // Update user info
            userUpdateStmt.setString(7, payment.getPaymentInfo().getAddress());
            userUpdateStmt.setString(8, payment.getPaymentInfo().getBankID());
            userUpdateStmt.setString(9, payment.getPaymentInfo().getCardNumber());
            userUpdateStmt.executeUpdate();
        }
    }
    // Retrieve all payments from the database
    public List<Payment> getAllPaymentsInfo(int userID) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT paymentID, amount, paymentDate, customerName, bankID, cardNumber FROM Payments WHERE userID = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Payment payment = new Payment(
                            rs.getInt("paymentID"),
                            rs.getDouble("amount"),
                            rs.getDate("paymentDate"),
                            rs.getString("address"),
                            rs.getString("customerName"),
                            rs.getString("bankID"),
                            rs.getString("cardNumber")
                    );
                    payments.add(payment);
                }
            }
        }
        return payments;
    }

    // Retrieve a single payment by ID
    public Payment getPaymentById(int paymentID, int userID) throws SQLException {
        String query = "SELECT paymentID, amount, paymentDate, customerName, bankID, cardNumber FROM Payments WHERE paymentID = ? AND userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, paymentID);
            stmt.setInt(2, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Payment(
                            rs.getInt("paymentID"),
                            rs.getDouble("amount"),
                            rs.getDate("paymentDate"),
                            rs.getString("address"),
                            rs.getString("customerName"),
                            rs.getString("bankID"),
                            rs.getString("cardNumber")
                    );
                }
            }
        }
        return null;
    }

    // Delete a payment by ID
    public void deletePayment(int paymentID, int userID) throws SQLException {
        String query = "DELETE FROM Payments WHERE paymentID = ? AND userID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, paymentID);
            stmt.setInt(2, userID);
            stmt.executeUpdate();
        }
    }
}
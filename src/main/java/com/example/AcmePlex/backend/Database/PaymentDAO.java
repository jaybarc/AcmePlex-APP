package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.Payment;

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
        String query = "INSERT INTO Payments (paymentID, userID, amount, paymentDate, customerName, bankID, cardNumber) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, payment.getPaymentID());
            stmt.setInt(2, userID);
            stmt.setDouble(3, payment.getAmount());
            stmt.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            stmt.setString(5, payment.getPaymentInfo().getCustomerName());
            stmt.setString(6, payment.getPaymentInfo().getBankID());
            stmt.setString(7, payment.getPaymentInfo().getCardNumber());
            stmt.executeUpdate();
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
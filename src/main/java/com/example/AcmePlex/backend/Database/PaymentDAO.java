package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.Payment;
import com.example.AcmePlex.backend.Entity.UserBankingInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new payment in the database
    public void addPayment(Payment payment) throws SQLException {
        String query = "INSERT INTO Payments (paymentID, amount, paymentDate, customerName, bankID, cardNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, payment.getPaymentID());
            stmt.setDouble(2, payment.getAmount());
            stmt.setDate(3, new java.sql.Date(payment.getPaymentDate().getTime()));
            stmt.setString(4, payment.getPaymentInfo().getCustomerName());
            stmt.setString(5, payment.getPaymentInfo().getBankID());
            stmt.setString(6, payment.getPaymentInfo().getCardNumber());
            stmt.executeUpdate();
        }
    }

    // Retrieve all payments from the database
    public List<Payment> getAllPaymentsInfo() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT paymentID, amount, paymentDate, customerName, bankID, cardNumber FROM Payments";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
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
        return payments;
    }

    // Retrieve a single payment by ID
    public Payment getPaymentById(String paymentId) throws SQLException {
        String query = "SELECT paymentID, amount, paymentDate, customerName, bankID, cardNumber FROM Payments WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paymentId);
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
    public void deletePayment(String paymentId) throws SQLException {
        String query = "DELETE FROM Payments WHERE paymentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, paymentId);
            stmt.executeUpdate();
        }
    }
}
package com.example.AcmePlex.backend.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.AcmePlex.backend.Entity.Seat;

public class SeatService {

    private static final String URL = "jdbc:mysql://localhost:3306/acmeplexdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Jeromebarcelona01!";

    // Get all available seats
    public List<Seat> getAvailableSeats() {
        List<Seat> availableSeats = new ArrayList<>();
        String query = "SELECT * FROM Seats WHERE status = 'available'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int rowNum = rs.getInt("row_num");
                int seatNumber = rs.getInt("seat_number");
                String status = rs.getString("status");
                //availableSeats.add(new Seat(rowNum, seatNumber, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return availableSeats;
    }

    // Book a seat (update status to booked)
    public boolean bookSeat(int rowNum, int seatNumber) {
        String query = "UPDATE Seats SET status = 'booked' WHERE row_num = ? AND seat_number = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, rowNum);
            stmt.setInt(2, seatNumber);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

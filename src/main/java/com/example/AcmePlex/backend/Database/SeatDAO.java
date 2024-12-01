package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeatDAO {
    private Connection connection;

    public SeatDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Seat> getSeatsByMovieId(int movieId) throws SQLException {
        List<Seat> seats = new ArrayList<>();
        String query = "SELECT * FROM Seats WHERE movie_id = ? ORDER BY row_num, seat_number";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, movieId);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Seat seat = new Seat();
                seat.setSeatId(resultSet.getInt("seat_id"));
                seat.setRowNum(resultSet.getInt("row_num"));
                seat.setSeatNumber(resultSet.getInt("seat_number"));
                seat.setStatus(resultSet.getString("status"));
                seat.setBookingId(resultSet.getInt("booking_id"));
                seat.setMovieId(resultSet.getInt("movie_id"));
                seats.add(seat);
            }
        }
        
        return seats;
    }

    public void updateSeatStatus(int seatId, String status) throws SQLException {
        String query = "UPDATE Seats SET status = ? WHERE seat_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, status);
            preparedStatement.setInt(2, seatId);
            preparedStatement.executeUpdate();
        }
    }
}

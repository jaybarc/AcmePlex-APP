package com.example.AcmePlex.backend.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    private Connection connection;

    public ShowtimeDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new showtime
    public void addShowtime(int movieId, String showtime) throws SQLException {
        String query = "INSERT INTO Showtimes (movieId, showtime) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            stmt.setString(2, showtime);
            stmt.executeUpdate();
        }
    }

    // Retrieve all showtimes
    public List<String> getAllShowtimes() throws SQLException {
        List<String> showtimes = new ArrayList<>();
        String query = "SELECT * FROM Showtimes";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                showtimes.add(rs.getString("showtime"));
            }
        }
        return showtimes;
    }
    
    // Retrieve all showtimes by movie ID
    public List<String> getShowtimesByMovieId(int movieId) throws SQLException {
        List<String> showtimes = new ArrayList<>();
        String query = "SELECT showtime FROM Showtimes WHERE movieId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, movieId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    showtimes.add(rs.getString("showtime"));
                }
            }
        }
        return showtimes;
    }

    // Update a showtime by ID
    public void updateShowtime(int showtimeId, String newShowtime) throws SQLException {
        String query = "UPDATE Showtimes SET showtime = ? WHERE showtimeId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newShowtime);
            stmt.setInt(2, showtimeId);
            stmt.executeUpdate();
        }
    }

    // Delete a showtime by ID
    public void deleteShowtime(int showtimeId) throws SQLException {
        String query = "DELETE FROM Showtimes WHERE showtimeId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, showtimeId);
            stmt.executeUpdate();
        }
    }
}

package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    private Connection connection;
    private SeatDAO seatDAO;
    
    private MovieDAO movieDAO;
    private ShowtimeDAO showtimeDAO;

    ArrayList<Seat> seats = new ArrayList<>();

    public TicketDAO(Connection connection) {
        this.connection = connection;
    }
    
    

    // Add a new ticket
    public void addTicket(int seatId, String ticketID, int movieId, int showtimeId, int receiptId, int roomId) throws SQLException {
        String query = "INSERT INTO Tickets (seatId, ticketID, movieId, showtimeId, receiptId, roomId) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, seatId);
            stmt.setString(2, ticketID);
            stmt.setInt(3, movieId);
            stmt.setInt(4, showtimeId);
            stmt.setInt(5, receiptId);
            stmt.setInt(6, roomId);
            stmt.executeUpdate();
        }
    }

    public Ticket getTicketById(int ticketId) throws SQLException {
        String query = "SELECT * FROM Tickets WHERE ticketId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ticket(
                            (Seat) seatDAO.getSeatsByMovieId(rs.getInt("movieId")),
                            rs.getString("ticketID"),
                            movieDAO.getMovieById(rs.getInt("movieId")),
                            (Showtime) showtimeDAO.getShowtimesByMovieId(rs.getInt("movieId")),
                            new ScreeningRoom(new Theater(), rs.getString("roomId"),seats,5)
                    );
                }
            }
        }
        return null; // Return null if ticket not found
    }
    

    // Cancel a ticket by ID
    public void cancelTicket(int ticketId) throws SQLException {
        String query = "DELETE FROM Tickets WHERE ticketId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            stmt.executeUpdate();
        }
    }
}
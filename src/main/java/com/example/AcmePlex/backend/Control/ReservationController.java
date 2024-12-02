package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.MovieDAO;
import com.example.AcmePlex.backend.Database.SeatDAO;
import com.example.AcmePlex.backend.Database.TicketDAO;
import com.example.AcmePlex.backend.Entity.Movie;
import com.example.AcmePlex.backend.Entity.Seat;
import com.example.AcmePlex.backend.Entity.Payment;

import com.example.AcmePlex.backend.Entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.sql.Connection;
import java.sql.SQLException;


/*JeromeImplementation */

@Controller
public class ReservationController {
    @Autowired
    private GmailSender gmailSender;

    private MovieDAO movieDAO;
    private SeatDAO seatDAO;
    private TicketDAO ticketDAO;
    
    private int movieid;

    public ReservationController() {
        try {
            // Set up the connection and DAO
            Connection connection = DatabaseConnection.getConnection();
            movieDAO = new MovieDAO(connection);
            seatDAO = new SeatDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomTicketCode() {
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder ticketCode = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            ticketCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        return ticketCode.toString();
    }

    @GetMapping("/book-seats")
    public String getMovies(Model model) {
        try {
            List<Movie> movies = movieDAO.getAllMovies(); 
            model.addAttribute("movies", movies); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "book-seats"; 
    }

    @GetMapping("/book-seats/{movieId}")
    public String getSeats(@PathVariable("movieId") int movieId, Model model) {
        try {
            List<Movie> movies = movieDAO.getAllMovies();
            List<Seat> seats = seatDAO.getSeatsByMovieId(movieId);
            this.movieid = movieId;

            // Find the selected movie name
            String selectedMovieName = "Unknown Movie";
            try {
                selectedMovieName = movieDAO.getMovieById(movieId).getTitle(); // Fetch title using DAO method
                if (selectedMovieName == null) {
                    selectedMovieName = "Unknown Movie"; // Handle case where movie is not found
                }
            } catch (SQLException e) {
                e.printStackTrace();
                selectedMovieName = "Error fetching movie title"; // Fallback for database errors
            }

            model.addAttribute("movies", movies);
            model.addAttribute("seats", seats);
            model.addAttribute("selectedMovieName", selectedMovieName); // Pass movie name
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "book-seats";
    }

    @GetMapping("/book-seats/payment")
    public String Payment(){
        return "payment";
    }

    
    @PostMapping("/process-payment")
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Payment paymentData) throws SQLException {
        // Log payment details (you can replace this with saving to a database)
        System.out.println("Processing payment for: " + paymentData.getFullName());
        System.out.println("Payment Amount: $" + paymentData.getAmount());
        System.out.println("Payment Date: " + new Date());

        // Generate receipt email body
        String receiptBody = "Dear " + paymentData.getFullName() + ",\n\n"
            + "Thank you for your payment!\n\n"
            + "Payment Details:\n"
            + "Amount Paid: $" + paymentData.getAmount() + "\n"
            + "Date: " + new Date() + "\n\n"
            + "Billing Address:\n"
            + paymentData.getAddress() + ", " + paymentData.getCity() + ", " 
            + paymentData.getProvince() + " " + paymentData.getZipCode() + "\n\n"
            + "Thank you for choosing AcmePlex.";

        String ticketBody = "Here is your ticket code, please show it to the conductor:\n"+
        "Ticket Code: " + generateRandomTicketCode() + "\n";
                

        // Send receipt email
        try {
            gmailSender.sendSimpleEmail(paymentData.getEmail(), receiptBody);
            System.out.println("Receipt email sent to " + paymentData.getEmail());
            gmailSender.sendSimpleEmail(paymentData.getEmail(), ticketBody);
            System.out.println("Ticket email sent to " + paymentData.getEmail());
        } catch (Exception e) {
            System.err.println("Failed to send email: " + e.getMessage());
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Failed to send receipt email.");
            return ResponseEntity.status(500).body(errorResponse);
        }

        // Return success response
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Payment processed successfully.");
        return ResponseEntity.ok(response);
    }

    

}



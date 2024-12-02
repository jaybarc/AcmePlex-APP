package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.MovieDAO;
import com.example.AcmePlex.backend.Database.SeatDAO;
import com.example.AcmePlex.backend.Entity.Movie;
import com.example.AcmePlex.backend.Entity.Seat;
import com.example.AcmePlex.backend.Entity.Payment;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private MovieDAO movieDAO;
    private SeatDAO seatDAO;

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
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Payment paymentData) {
        // Process the payment (e.g., save to DB, send email, etc.)
        boolean success = true;

        Map<String, Object> response = new HashMap<>();
        response.put("success", success);

        return ResponseEntity.ok(response);
    }

    

}



package com.example.AcmePlex.backend.Control;


import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.MovieDAO;
import com.example.AcmePlex.backend.Entity.Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.sql.Connection;
import java.sql.SQLException;

/*JeromeImplementation */

@Controller
public class ReservationController {
    private MovieDAO movieDAO;

    public ReservationController() {
        try {
            // Set up the connection and DAO
            Connection connection = DatabaseConnection.getConnection();
            movieDAO = new MovieDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/book-seats")
    public String getMovies(Model model) {
        try {
            List<Movie> movies = movieDAO.getAllMovies(); // Get all movies
            model.addAttribute("movies", movies); // Add movies to the model
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "book-seats"; // Return the HTML view name
    }
}



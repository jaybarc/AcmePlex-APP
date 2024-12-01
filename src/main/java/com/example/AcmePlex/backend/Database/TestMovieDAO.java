package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Control.ReservationController;
import com.example.AcmePlex.backend.Entity.Movie;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;


public class TestMovieDAO {
    private static Connection connection;
    private static MovieDAO movieDAO;
    private static ReservationController reservationController;

    public static void main(String[] args) {
        try {
            // Establish connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/acmeplexdb", "root", "Jeromebarcelona01!");
            movieDAO = new MovieDAO(connection);
            reservationController = new ReservationController();

            // Run manual tests
            testGetAllMoviesManually();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Test for retrieving all movies manually
    public static void testGetAllMoviesManually() {
        try {
            List<Movie> movies = movieDAO.getAllMovies();  // Retrieve all movies
            System.out.println("\nAll Movies:");
            for (Movie movie : movies) {
                System.out.println(movie.toString() + "\n\n"); // Print each movie
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Test for searching a movie manually -NOT YET
   

}

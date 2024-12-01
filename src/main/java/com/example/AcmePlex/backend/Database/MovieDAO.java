package com.example.AcmePlex.backend.Database;

import com.example.AcmePlex.backend.Entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private Connection connection;

    public MovieDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new movie in the database
    public void addMovie(Movie movie) throws SQLException {
        String query = "INSERT INTO Movies (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.executeUpdate();
        }
    }

    // Retrieve all movies from the database (with all attributes)
public List<Movie> getAllMovies() throws SQLException {
    List<Movie> movies = new ArrayList<>();
    String query = "SELECT id, name, genre, duration, synopsis FROM Movies"; // Selecting all relevant columns

    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            // Create a new Movie object for each row and add it to the list
            Movie movie = new Movie(
                rs.getString("id"),
                rs.getString("name"),
                rs.getString("genre"),
                rs.getInt("duration"),
                rs.getString("synopsis")
            );
            movies.add(movie);
        }
    }
    return movies;
}


    // Retrieve a single movie title by ID
    public String getMovieTitleById(String movieId) throws SQLException {
        String query = "SELECT name FROM Movies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movieId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name"); // Return movie title
                }
            }
        }
        return null; // Return null if movie not found
    }

    // Update a movie title
    public void updateMovieTitle(String movieId, String newTitle) throws SQLException {
        String query = "UPDATE Movies SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setString(2, movieId);
            stmt.executeUpdate();
        }
    }

    // Delete a movie by ID
    public void deleteMovie(String movieId) throws SQLException {
        String query = "DELETE FROM Movies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movieId);
            stmt.executeUpdate();
        }
    }
}

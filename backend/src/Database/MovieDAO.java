package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entity.Movie;

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

    // Retrieve all movies from the database
    public List<Movie> getAllMovies() throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM Movies";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                movies.add(new Movie(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("genre"), 
                    rs.getInt("duration"),         
                    rs.getString("synopsis") 
                ));
            }
        }
        return movies;
    }

    // Retrieve a single movie by ID
    public Movie getMovieById(String movieId) throws SQLException {
        String query = "SELECT * FROM Movies WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movieId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Movie(
                        rs.getString("id"),
                        rs.getString("name"),
                        "Unknown", // Placeholder for genre
                        0,         // Placeholder for duration
                        "Unknown"  // Placeholder for synopsis
                    );
                }
            }
        }
        return null; // Return null if movie not found
    }

    // Update a movie
    public void updateMovie(Movie movie) throws SQLException {
        String query = "UPDATE Movies SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getMovieID());
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

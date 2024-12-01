import com.google.gson.Gson;
import java.io.*;
import java.net.*;
import java.util.*;
import Database.MovieDAO;
import Database.Movie;
import java.sql.Connection;

public class SimpleHttpServer {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            if (line != null && line.startsWith("GET /movies")) {
                sendMovieData(clientSocket);
            } else {
                sendResponse(clientSocket, 404, "Not Found", "Page not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendMovieData(Socket clientSocket) throws IOException {
        // Get the movie data from your database
        List<Movie> movies = getMoviesFromDatabase();
        
        // Convert the list of movies to JSON
        Gson gson = new Gson();
        String json = gson.toJson(movies);
        
        // Send the JSON response to the client
        sendResponse(clientSocket, 200, "OK", json);
    }

    private static List<Movie> getMoviesFromDatabase() {
        List<Movie> movies = new ArrayList<>();
        try {
            // Replace this with actual database fetching code
            Connection connection = DatabaseConnection.getConnection();
            MovieDAO movieDAO = new MovieDAO(connection);
            movies = movieDAO.getAllMovies(); // Retrieve all movies from the DB
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    private static void sendResponse(Socket clientSocket, int statusCode, String statusMessage, String responseBody) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream, true);

        writer.println("HTTP/1.1 " + statusCode + " " + statusMessage);
        writer.println("Content-Type: application/json");
        writer.println("Content-Length: " + responseBody.length());
        writer.println();
        writer.println(responseBody);
        writer.flush();

        clientSocket.close();
    }
}

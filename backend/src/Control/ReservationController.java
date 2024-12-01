package Control;
import Entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationController {
    // Sample storage for demo purposes (in reality, you would use a database or another persistence mechanism)
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Showtime> showtimes = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private ArrayList<Seat> seats = new ArrayList<>();
    
    LocalDateTime dateTime = LocalDateTime.now();
    

    public ReservationController() {
        // Initialize sample data for demonstration (optional)
        initializeSampleData();
    }

    // Search for movies based on location, title, and date
    public ArrayList<Movie> searchMovies(String movieID) {
        ArrayList<Movie> results = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getMovieID().equals(movieID)) {
                results.add(movie);
            }
        }
        return results;
    }

    // Select a specific showtime, it has to be before selecting seat
    public Showtime selectShowtime(String showtimeId) {
        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeId().equals(showtimeId)) {
                return showtime;
            }
        }
        throw new IllegalArgumentException("Showtime not found");
    }

    // Select a specific seat, has to be after selecting showtime
    public Seat selectSeat(String seatId) {
        for (Seat seat : seats) {
            if (seat.getSeatID().equals(seatId)) {
                if (seat.isReserved()) {
                    System.out.println("Seat is already reserved.");
                    return null; // Or handle this scenario differently based on your requirements
                } else {
                    return seat;
                }
            }
        }
        throw new IllegalArgumentException("Seat not found");
    }

    // Make a reservation
    public Ticket makeReservation(String userId, String showtimeId, String seatId) {
        Showtime showtime = selectShowtime(showtimeId);
        Seat seat = selectSeat(seatId);
        Movie movie = searchMovies(showtime.getMovieId()).get(0); // Assuming only one movie per showtime

        if (seat.isReserved()) {
            throw new IllegalStateException("Seat is already reserved");
        }

        seat.setReserved(true); // Mark the seat as reserved

        // Create a new ticket
        Ticket ticket = new Ticket(seat, userId, movie, showtime, null, null);
        tickets.add(ticket);

        return ticket;
    }

    // Cancel a reservation
    public double cancelReservation(String ticketId) {
        Ticket ticket = null;
        for (Ticket t : tickets) {
            if (t.getTicketID().equals(ticketId)) {
                ticket = t;
                break;
            }
        }

        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }

        // Mark the seat as available
        ticket.getChosenSeat().setReserved(false);

        // Calculate refund amount (if applicable)
        double refundAmount = 0.0;
        //TODO: Add functionality to check if the thing is expired or not
        if (ticket.getReceipt() != null) {
            refundAmount = ticket.getChosenSeat().getPrice();
        }

        // Remove the ticket
        tickets.remove(ticket);

        return refundAmount;
    }

    // Initialize sample data (optional)
    private void initializeSampleData() {
        // Add movies
        movies.add(new Movie("M001", "Inception", "Sci-Fi", 148, "A stupid ass movie"));

        // Add showtimes
        showtimes.add(new Showtime("S001", "M001", "SC001", dateTime));
    }
}

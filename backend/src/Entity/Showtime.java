package Entity;

import java.util.Date;

public class Showtime {
    private String showtimeId;
    private String movieId;
    private Date dateTime;
    private int availableSeats;
    private int totalSeats;

    public Showtime(String showtimeId, String movieId, Date dateTime, int totalSeats) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.dateTime = dateTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean isAvailable() {
        return availableSeats > 0;
    }

    public void reserveSeat() {
        if (isAvailable()) {
            availableSeats--;
        } else {
            throw new IllegalStateException("No seats available.");
        }
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    // Getters and Setters
    public String getShowtimeId() {
        return showtimeId;
    }
    public void setShowtimeId(String showtimeId) {
        this.showtimeId = showtimeId;
    }
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    
}

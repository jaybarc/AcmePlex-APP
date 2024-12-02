package com.example.AcmePlex.backend.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Showtime {
    private int showtimeId;
    private String movieId;
    private String screenID;
    private LocalDateTime dateTime;
    
    public Showtime(int showtimeId, String movieId, String screenID, LocalDateTime dateTime) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.screenID = screenID;
        this.dateTime = dateTime;
    }
    
    // Getters and Setters
    public int getShowtimeId() {
        return showtimeId;
    }
    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }
    public String getMovieId() {
        return movieId;
    }
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Functions
    public String getFormattedScreeningTime(String pattern, Integer runtimeMinutes) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        String startTimeFormatted = dateTime.format(formatter); 
        String endTimeFormatted = dateTime.plusMinutes(runtimeMinutes).format(formatter);
        return startTimeFormatted + " to " + endTimeFormatted;
    }
 
    
}

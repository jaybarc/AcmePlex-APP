package Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Showtime {
    private String showtimeId;
    private String movieId;
    private String screenID;
    private LocalDateTime dateTime;
    
    public Showtime(String showtimeId, String movieId, String screenID, LocalDateTime dateTime) {
        this.showtimeId = showtimeId;
        this.movieId = movieId;
        this.screenID = screenID;
        this.dateTime = dateTime;
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

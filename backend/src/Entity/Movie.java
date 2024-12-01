package Entity;

import Control.ReservationController;

import java.util.ArrayList;

public class Movie {
    private String movieID;
    private String title;
    private String genre;
    private int duration; // Should be in minutes
    private String synopsis;
    
    private ReservationController reservationController;
    
    public Movie(String movieID, String title, String genre, int duration, String synopsis) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.synopsis = synopsis;
    }
    public String toString() {
        return "Movie ID: " + movieID + "\nTitle: " + title + "\nGenre: " + genre + "\nDuration: " + duration + " minutes\nSynopsis: " + synopsis;
    }

    /* 
    public ArrayList<Movie> searchMovies(String movieID){
        return reservationController.searchMovies(movieID);
    }
    */
    
    public String getMovieID() {
        return movieID;
    }
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    
    
}

package com.example.AcmePlex.backend.Entity;

import java.util.Random;

public class Ticket {
    private Seat chosenSeat;
    private String ticketID;
    private Movie movie;
    private Showtime showtime;

    private ScreeningRoom room;
    
    public Ticket(Seat chosenSeat, String ticketID, Movie movie, Showtime showtime, ScreeningRoom room) {
        this.chosenSeat = chosenSeat;
        this.ticketID = ticketID;
        this.movie = movie;
        this.showtime = showtime;
        this.room = room;
    }
    
    public Seat getChosenSeat() {
        return chosenSeat;
    }
    public void setChosenSeat(Seat chosenSeat) {
        this.chosenSeat = chosenSeat;
    }
    public String getTicketID() {
        return ticketID;
    }
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }
    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public Showtime getShowtime() {
        return showtime;
    }
    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }
    public ScreeningRoom getRoom() {
        return room;
    }
    public void setRoom(ScreeningRoom room) {
        this.room = room;
    }
    
}

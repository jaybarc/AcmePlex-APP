package com.example.AcmePlex.backend.Entity;

import java.util.ArrayList;

public class ScreeningRoom {
    private Theater theater;
    private int roomID;
    private ArrayList<Seat> available_seat;
    private int number_of_seats;
    
    public ScreeningRoom(Theater theater, int roomID, ArrayList<Seat> available_seat, int number_of_seats) {
        this.theater = theater;
        this.roomID = roomID;
        this.available_seat = available_seat;
        this.number_of_seats = number_of_seats;
    }
    
    // Getters and Setters
    public Theater getTheater() {
        return theater;
    }
    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    public int getRoomID() {
        return roomID;
    }
}

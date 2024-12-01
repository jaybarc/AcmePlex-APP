package com.example.AcmePlex.backend.Entity;

import com.example.AcmePlex.backend.Control.ReservationController;

import java.util.ArrayList;

public class User {
    private int userID;
    private boolean userType;
    private String userEmail;
    
    private ReservationController reservationController;
    
    public User(int userID, boolean userType, String userEmail) {
        this.userID = userID;
        this.userType = userType;
        this.userEmail = userEmail;
    }
    //Functions
    public Ticket makeReservation(String showtimeId, String seatId) {
        return null;
    }
    public double cancelReservation(String ticketId) {
        return 0;
    }
    //Getters and Setters
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public boolean isUserType() {
        return userType;
    }
    public void setUserType(boolean userType) {
        this.userType = userType;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
}

package com.example.AcmePlex.backend.Entity;

public class User {
    private int userId; // Matches `UserID` column

    public User() {
    }

    public User(int userId) {
        this.userId = userId;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}

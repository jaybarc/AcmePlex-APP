package com.example.AcmePlex.backend.Entity;

public class Seat {
    private int seatId;
    private int rowNum;
    private int seatNumber;
    private String status;
    private Integer bookingId;
    private int movieId;
    
    public Seat(){}
    
    public Seat(int seatId, int rowNum, int seatNumber, String status, Integer bookingId, int movieId) {
        this.seatId = seatId;
        this.rowNum = rowNum;
        this.seatNumber = seatNumber;
        this.status = status;
        this.bookingId = bookingId;
        this.movieId = movieId;
    }

    // Getters and setters
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}

package com.example.AcmePlex.backend.Entity;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RegisteredUser extends User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Date dateToPayFee;
    private List<Announcement> receivedAnnouncements;

    public RegisteredUser(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void receiveAnnouncement(Announcement announcement) {
        if (announcement == null) {
            throw new IllegalArgumentException("Announcement cannot be null.");
        }
        receivedAnnouncements.add(announcement);
        System.out.println("Announcement received");
    }

    public void payAnnualFee() {
        // Simulate payment process
        System.out.println("Processing annual fee payment for user: " + username);

        // Update the dateToPayFee to the next year
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateToPayFee);
        calendar.add(Calendar.YEAR, 1);
        dateToPayFee = calendar.getTime();

        System.out.println("Annual fee paid. Next payment due date: " + dateToPayFee);
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public Date getDateToPayFee() {
        return dateToPayFee;
    }

    public void setDateToPayFee(Date dateToPayFee) {
        this.dateToPayFee = dateToPayFee;
    }
}
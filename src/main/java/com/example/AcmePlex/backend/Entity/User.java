package com.example.AcmePlex.backend.Entity;

public class User {
    private int userId; // Matches `UserID` column
    private String userEmail; // Matches `userEmail` column
    private String username; // Matches `username` column
    private String password; // Matches `password` column
    private String firstName; // Matches `firstName` column
    private String lastName; // Matches `lastName` column
    private String address; // Matches `address` column (optional)
    private String customerName; // Matches `customerName` column (optional)
    private String bankID; // Matches `bankID` column (optional)

    // Constructor
    public User() {}

    public User(String userEmail, String username, String password, String firstName, String lastName, String address, String customerName, String bankID) {
        this.userEmail = userEmail;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.customerName = customerName;
        this.bankID = bankID;
    }

    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBankID() {
        return bankID;
    }

    public void setBankID(String bankID) {
        this.bankID = bankID;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", customerName='" + customerName + '\'' +
                ", bankID='" + bankID + '\'' +
                '}';
    }
}

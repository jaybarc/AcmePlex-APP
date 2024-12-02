package com.example.AcmePlex.backend.Entity;

import java.util.Date;
import java.util.List;

public class Payment {
    private int paymentID;
    
    private Ticket ticket;
    private Double amount;
    private Date paymentDate;
    private String fullName;
    private String email;
    private String address;
    private String city;
    private String province;
    private String zipCode;
    private String cardName;
    private String cardNumber;
    private String cardCvv;
    private String expMonth;
    private String expYear;
    private List<Integer> seatIds;

    // Constructor to initialize Payment object from form data
    public Payment(int paymentID, Double amount, Date paymentDate, String fullName, String email, String address, 
                   String city, String province, String zipCode, String cardName, String cardNumber, 
                   String cardCvv, String expMonth, String expYear, List<Integer> seatIds) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardCvv = cardCvv;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.seatIds = seatIds;
    }

    // Getters and Setters
    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Integer> seatIds) {
        this.seatIds = seatIds;
    }
    
    public Ticket getTicket() {
        return ticket;
    }
}

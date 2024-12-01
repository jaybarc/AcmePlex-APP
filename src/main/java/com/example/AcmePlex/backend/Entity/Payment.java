package com.example.AcmePlex.backend.Entity;

import java.util.Date;

public class Payment {
    private int paymentID;
    private Double amount;
    private Date paymentDate;
    private UserBankingInfo paymentInfo;
    
    public Payment(int paymentID, Double amount, Date paymentDate, String customerName, String bankID, String cardNumber) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentInfo = new UserBankingInfo(customerName, bankID, cardNumber);
    }
    
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
    public UserBankingInfo getPaymentInfo() {
        return paymentInfo;
    }
    public void setPaymentInfo(UserBankingInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    
}

package com.example.AcmePlex.backend.Entity;

import java.util.Date;

public class Payment {
    private String paymentID;
    private Double amount;
    private Date paymentDate;
    private UserBankingInfo paymentInfo;
    
    public Payment(String paymentID, Double amount, Date paymentDate, UserBankingInfo paymentInfo) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentInfo = paymentInfo;
    }
    
    public String getPaymentID() {
        return paymentID;
    }
    public void setPaymentID(String paymentID) {
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

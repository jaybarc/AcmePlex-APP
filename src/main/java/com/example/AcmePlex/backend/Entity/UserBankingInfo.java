package com.example.AcmePlex.backend.Entity;

public class UserBankingInfo {
    private String customerName;
    private String bankID;
    private String cardNumber;
    
    private String address;
    public UserBankingInfo(String address, String customerName, String bankID, String cardNumber) {
        this.customerName = customerName;
        this.address = address;
        this.bankID = bankID;
        this.cardNumber = cardNumber;
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
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

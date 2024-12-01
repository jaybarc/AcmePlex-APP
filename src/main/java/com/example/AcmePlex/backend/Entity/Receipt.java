package com.example.AcmePlex.backend.Entity;

import com.sun.nio.sctp.SendFailedNotification;

import java.util.ArrayList;
import java.util.Date;

public class Receipt {
    private String receiptID;
    private int num_of_receipt;
    private Payment payment;
    private Date date;
    private ArrayList<Ticket> tickets;
    
    public Receipt(String receiptID, int num_of_receipt, Payment payment, Date date, ArrayList<Ticket> tickets) {
        this.receiptID = receiptID;
        this.num_of_receipt = num_of_receipt;
        this.payment = payment;
        this.date = date;
        this.tickets = tickets;
    }
    
    public void sendReceipt(){
        //TODO: Implement to send receipt to user
        
    }
}

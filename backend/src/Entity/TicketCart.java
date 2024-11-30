package Entity;

import java.util.ArrayList;

public class TicketCart {
    private Payment payment;
    private double totalCost;
    private ArrayList<Ticket> tickets;
    
    public TicketCart(Payment payment, double totalCost, ArrayList<Ticket> tickets) {
        this.payment = payment;
        this.totalCost = totalCost;
        this.tickets = tickets;
    }
    public void addtoCart(Ticket ticket){
        tickets.add(ticket);
    }
    public void removeFromCart(Ticket ticket){
        tickets.remove(ticket);
    }
}

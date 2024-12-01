package Entity;

public class Seat {
    private String seatID;
    private char row;
    private int columns;
    private boolean isReserved;
    private double price;

    // Constructor
    public Seat(String seatID, char row, int columns, boolean isReserved, double price) {
        this.seatID = seatID;
        this.row = row;
        this.columns = columns;
        this.isReserved = isReserved;
        this.price = price;
    }
    // Getters and Setters
    public String getSeatID() {
        return seatID;
    }
    public void setSeatID(String seatID) {
        this.seatID = seatID;
    }
    public char getRow() {
        return row;
    }
    public void setRow(char row) {
        this.row = row;
    }
    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }
    public boolean isReserved() {
        return isReserved;
    }
    public void setReserved(boolean isReserved) {
        this.isReserved = isReserved;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}

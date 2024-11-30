package Entity;

public class Seat {
    private int rowNum;
    private int seatNumber;
    private String status;

    // Constructor
    public Seat(int rowNum, int seatNumber, String status) {
        this.rowNum = rowNum;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    // Getters and Setters
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
}

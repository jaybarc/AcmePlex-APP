package Entity;

public class User {
    private String userID;
    private boolean userType;
    private TicketCart cart;
    private String userEmail;
    
    public User(String userID, boolean userType, TicketCart cart, String userEmail) {
        this.userID = userID;
        this.userType = userType;
        this.cart = cart;
        this.userEmail = userEmail;
    }
    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public boolean isUserType() {
        return userType;
    }
    public void setUserType(boolean userType) {
        this.userType = userType;
    }
    public TicketCart getCart() {
        return cart;
    }
    public void setCart(TicketCart cart) {
        this.cart = cart;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    
}

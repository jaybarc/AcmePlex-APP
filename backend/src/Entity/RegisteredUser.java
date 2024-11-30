package Entity;

import java.util.Date;

public class RegisteredUser extends User{
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private UserBankingInfo paymentInfo;
    private Date dateToPayFee;
    
    public RegisteredUser(String userID, boolean userType, TicketCart cart, String userEmail, String username, 
                          String password, String firstName, String lastName, String address, UserBankingInfo paymentInfo
            , Date dateToPayFee) {
        super(userID, userType, cart, userEmail);
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.paymentInfo = paymentInfo;
        this.dateToPayFee = dateToPayFee;
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
    public UserBankingInfo getPaymentInfo() {
        return paymentInfo;
    }
    public void setPaymentInfo(UserBankingInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    public Date getDateToPayFee() {
        return dateToPayFee;
    }
    public void setDateToPayFee(Date dateToPayFee) {
        this.dateToPayFee = dateToPayFee;
    }
    
}

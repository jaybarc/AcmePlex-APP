package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private GmailSender gmailSender;
    private UserDAO userDAO;
    public LoginController() {
        try {
            // Set up the connection and DAO
            Connection connection = DatabaseConnection.getConnection();
            userDAO = new UserDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            if (userDAO.authenticate(username, password)) {
                LocalDate registrationDate = userDAO.getregisrationDate(username);
                LocalDate oneYearAfterRegistration = registrationDate.plusYears(1);
                LocalDate todayDate = LocalDate.now();

                if (oneYearAfterRegistration.isBefore(todayDate)) {
                    // Decrease bank balance by 20
                    System.out.println("Your account is expired. Renewing your account.");
                    double bankBalance = userDAO.getBankBalance(username);
                    userDAO.setBankBalance(username, bankBalance - 20);
                    userDAO.setregisrationDate(username, todayDate);
                    String ticketBody = "Your account is expired, $20 has been taken off your balance.";
                    gmailSender.sendSimpleEmail(userDAO.getEmail(username), ticketBody);
                    System.out.println("Ticket email sent to " + userDAO.getEmail(username));
                    model.addAttribute("accountExpired", true);
                    return "index";
                } else {
                    model.addAttribute("accountExpired", false);
                    return "index";
                }
            } else {
                model.addAttribute("error", "Invalid username or password.");
                return "login";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred. Please try again.");
            return "login";
        }
    }
}

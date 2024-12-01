package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class LoginController {
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
                model.addAttribute("message", "You have successfully logged in.");
                model.addAttribute("username", username); // Add username to the model
                return "index"; // Redirect to a welcome page or dashboard
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

package com.example.AcmePlex.backend.Control;

import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
public class RegisterController {
    private UserDAO userDAO;
    
    private LocalDate currentDate = LocalDate.now();

    public RegisterController() {
        try {
            // Set up the connection and DAO
            Connection connection = DatabaseConnection.getConnection();
            userDAO = new UserDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public LocalDate getCurrentDate(){
        return currentDate;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, @RequestParam String firstName, 
                           @RequestParam String lastName, @RequestParam String email, Model model) {
        try {
            
            userDAO.createUser(username, password, firstName, lastName, email, currentDate, 0.0);
            model.addAttribute("message", "Registration successful. Please log in.");
            return "login";
        } catch (SQLException e) {
            e.printStackTrace();
            model.addAttribute("error", "An error occurred. Please try again.");
            return "register";
        }
    }
}
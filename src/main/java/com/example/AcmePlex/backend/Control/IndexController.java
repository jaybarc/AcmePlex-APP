package com.example.AcmePlex.backend.Control;


import com.example.AcmePlex.backend.Database.DatabaseConnection;
import com.example.AcmePlex.backend.Database.MovieDAO;
import com.example.AcmePlex.backend.Entity.Movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import java.sql.Connection;
import java.sql.SQLException;

@Controller
public class IndexController {

    @GetMapping("/")
    public String Index(){
        return "index";

    }

    @GetMapping("/book-seats/payment") //Will need to pass model or take model idk //move to payment controller when u can
    public String Payment(){
        return "payment";

    }
    
    
}

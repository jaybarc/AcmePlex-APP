package com.example.AcmePlex.backend.Control;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ActionController {

    @PostMapping("/execute")
    public String executeAction() {
        // Your Java code to be executed
        return "Action executed successfully!";
    }
}
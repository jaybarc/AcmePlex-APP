package com.example.AcmePlex.backend.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class GmailSender {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String toEmail, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("acmeplex0@gmail.com"); // Replace with your Gmail address
        message.setTo(toEmail);
        message.setSubject("AcmePlex Receipt");
        message.setText(body);

        mailSender.send(message);
    }
}

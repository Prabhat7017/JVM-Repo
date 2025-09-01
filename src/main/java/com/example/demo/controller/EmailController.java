package com.example.demo.controller;

import com.example.demo.services.EmailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private EmailHandler emailHandler;


    public EmailController(EmailHandler emailHandler) {
        this.emailHandler = emailHandler;
    }

    @GetMapping("/send")
    public String sendEmail() {
        emailHandler.sendEmail("example@gmail.com", "Test Subject ", "This is a test email body.");
        System.out.println("Email request received, processing in background...");
        return "Email is being sent!";
    }
}

package com.example.demo.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailHandler {

    @Async
    public void sendEmail(String to, String subject, String body) {
        // Simulate sending an email
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);

        try {
            Thread.sleep(5000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Email sent to: " + to);
    }
}

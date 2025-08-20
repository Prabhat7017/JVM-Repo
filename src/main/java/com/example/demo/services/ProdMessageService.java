package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class ProdMessageService implements MessageService{
    @Value("${app.message}")
    private String message;
    @Override
    public String getMessage() {
        return "Prod Message: " + message;
    }
}

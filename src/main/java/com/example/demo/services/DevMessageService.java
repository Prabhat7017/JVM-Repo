package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevMessageService implements MessageService{

    @Value("${app.message}")
    private String message;

    @Value("${app.password}")
    private String pass;
    @Override
    public String getMessage() {
        return "Dev Message: " + message + "Pass: " + pass;
    }
}

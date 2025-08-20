package com.example.demo.models;

import org.springframework.stereotype.Service;

@Service
public class MySingletoneBean {
    private String message;

    public MySingletoneBean() {
        this.message = "Hello from MySingletoneBean!";
    }

    public String getMessage() {
        return message + "I am a Singletone bean - " + this.hashCode();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

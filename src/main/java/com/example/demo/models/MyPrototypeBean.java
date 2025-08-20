package com.example.demo.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class MyPrototypeBean {
    private String message;

    public MyPrototypeBean() {
        this.message = "Hello from MyPrototypeBean!";
    }

    public String getMessage() {
        return message + "I am a prototype bean - " + this.hashCode();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

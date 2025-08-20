package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    public final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }
    public String drive() {
        return  engine.start() +" Car is driving.";
    }
}

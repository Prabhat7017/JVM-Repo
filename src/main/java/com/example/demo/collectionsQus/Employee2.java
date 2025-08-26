package com.example.demo.collectionsQus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee2 {
    private String name;
    private int age;
    private String designation;


    public Employee2(String name, int age, String designation) {
        this.name = name;
        this.age = age;
        this.designation = designation;
    }

}

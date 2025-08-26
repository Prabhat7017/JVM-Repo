package com.example.demo.threadingQus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
sealed public class College permits Student, Teacher {

    private final String name;
    private final String address;

    public College(String name, String address) {
        this.name = name;
        this.address = address;
    }

}

package com.example.demo.collectionsQus;

import lombok.Getter;

@Getter
public class Employee implements Comparable<Employee>{
    double age;
    double salary;
    String firstName;
    String lastName;

    public Employee (double age, double salary, String firstName, String lastName) {
        this.age = age;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int compareTo(Employee other) {
        return this.firstName.compareTo(other.firstName) != 0 ?
            this.firstName.compareTo(other.firstName) :
            this.lastName.compareTo(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", Age: " + age + ", Salary: " + salary + "\n";
    }
}

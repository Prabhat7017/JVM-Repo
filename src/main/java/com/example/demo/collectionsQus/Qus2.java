package com.example.demo.collectionsQus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Qus2 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(22, 50000, "John", "Doe"));
        employees.add(new Employee(25, 60000, "Jane", "Smith"));
        employees.add(new Employee(30, 70000, "Alice", "Johnson"));
        employees.add(new Employee(28, 55000, "Bob", "Brown"));
        employees.add(new Employee(35, 80000, "Charlie", "Davis"));

        System.out.println(employees);

        Collections.sort(employees);
        System.out.println("Default sorting: " + employees);

        Collections.sort(employees, (e1, e2)-> (int) (e2.getSalary() - e1.getSalary()));
        System.out.println("Sorting by salary in descending order: " + employees);
    }
}

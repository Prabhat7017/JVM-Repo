package com.example.demo.collectionsQus;

import java.util.HashMap;
import java.util.Map;

public class Qus4 {
    public static void main(String[] args) {
        Employee2 employee = new Employee2("John", 30, "Software Engineer");
        Employee2 employee2 = new Employee2("Jane", 25, "Data Scientist");
        Employee2 employee3 = new Employee2("Alice", 28, "Product Manager");
        Employee2 employee4 = new Employee2("Bob", 35, "DevOps Engineer");
        Employee2 employee5 = new Employee2("Charlie", 32, "UX Designer");

        Map<Employee2, Integer> employeeMap = new HashMap<>();
        employeeMap.put(employee, 60000);
        employeeMap.put(employee2, 70000);
        employeeMap.put(employee3, 80000);
        employeeMap.put(employee4, 90000);
        employeeMap.put(employee5, 100000);
        System.out.println("Employee Map:");
        for (Map.Entry<Employee2, Integer> entry : employeeMap.entrySet()) {
            Employee2 emp = entry.getKey();
            Integer salary = entry.getValue();
            System.out.println("Name: " + emp.getName() + ", Age: " + emp.getAge() + ", Designation: " + emp.getDesignation() + ", Salary: "
                    + salary);
        }
    }
}

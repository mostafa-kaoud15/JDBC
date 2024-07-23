package com.example;

import com.example.employees.enitity.Employee;
import com.example.employees.services.EmployeeService;

public class Main {
    public  static void main(String[] args) throws InterruptedException {
        EmployeeService empService = new EmployeeService();
        empService.insert(new Employee(82, "mostafa kaoud", 15000));
    }
}
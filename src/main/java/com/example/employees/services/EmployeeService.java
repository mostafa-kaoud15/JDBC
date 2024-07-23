package com.example.employees.services;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.employees.enitity.Employee;
import com.example.employees.repo.EmployeeImplRepo;

public class EmployeeService {
    private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());
    private final EmployeeImplRepo empRepo = new EmployeeImplRepo();

    static {
        try {
            // Set up a file handler with an absolute path
            FileHandler fileHandler = new FileHandler("src/main/resources/logs/employee_service.log", true);
            fileHandler.setFormatter(new java.util.logging.SimpleFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL); // Ensure all levels are logged
        } catch (IOException e) {
            System.err.println("Failed to set up file handler for BookService logger: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void insert(Employee employee) {
        if (employee == null || employee.getName() == null || employee.getId() <= 0) {
            logger.warning("invalid employee data provid");
            return;
        } else if (empRepo.getById(employee.getId()).isPresent()) {
            logger.warning("Employee with ID " + employee.getId() + " already exists.");
            return;
        }
        empRepo.insert(employee);
    }

    public Optional<Employee> getById(int id) {
        if (id <= 0) {
            logger.warning("invalid id " + id + " provided");
            return Optional.empty();
        }
        Optional<Employee> result = empRepo.getById(id);
        if (result.isPresent()) {
            logger.info("the employee with id: " + id + " is existed");
        } else {
            logger.info("the employee with id : " + id + " is not existed");
        }
        return result;
    }

}

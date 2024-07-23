package com.example.employees.repo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.database.Database;
import com.example.employees.enitity.Employee;

public class EmployeeImplRepo implements EmployeeRepo {
    private static final Logger logger = Logger.getLogger(EmployeeImplRepo.class.getName());
    private static final String INSERT_EMP = "insert into employee(id, name) values (?, ?)";
    private static final String GET_BY_ID = "select * from employee where id = ?";
   
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


    @Override
    public void insert(Employee employee) {
        try (Connection connection = Database.getConnection();
                PreparedStatement insertQuery = connection.prepareStatement(INSERT_EMP)) {
            insertQuery.setInt(1, employee.getId());
            insertQuery.setString(2, employee.getName());
            insertQuery.executeUpdate();
            logger.log(Level.SEVERE, "employee hase added with id : " + employee.getId());

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error while inserting emp", e);
        }
    }

    @Override
    public Optional<Employee> getById(int id) {
        try (Connection connection = Database.getConnection();
                PreparedStatement findQuery = connection.prepareStatement(GET_BY_ID)) {
            findQuery.setInt(1, id);
            ResultSet rs = findQuery.executeQuery();
            if (rs.next()) {
                return Optional.of(new Employee(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error while retrieving Employee with Id", e);
        }
        return Optional.empty();
    }

}
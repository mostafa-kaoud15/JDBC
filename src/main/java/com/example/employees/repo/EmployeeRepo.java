package com.example.employees.repo;

import java.util.Optional;

import com.example.employees.enitity.Employee;

public interface EmployeeRepo {

    public void insert(Employee item);
    public Optional<?> getById(int id);
    

}

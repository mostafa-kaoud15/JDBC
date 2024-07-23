package com.example.employees.enitity;

public class Employee {
    private int id;
    private String name;
    private float salary;

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public float getSalary() {
        return this.salary;
    }
    
}

package com.alex.employeesearch.core;

import java.math.BigDecimal;

public class Employee {

    private int id;
    private String lastName;
    private String firstName;
    private String email;
    private BigDecimal salary;
    private String department;
    private String position;

    public Employee(String lastName, String firstName, String email,
                    BigDecimal salary, String department, String position) {

        this(0, lastName, firstName, email, salary, department, position);
    }

    public Employee(int id, String lastName, String firstName, String email,
                    BigDecimal salary, String department, String position) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.salary = salary;
        this.department = department;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getDepartment() { return department;}

    public void setDepartment(String department) { this.department = department;}

    public String getPosition() { return position;}

    public void setPosition(String position) { this.position = position;}

    @Override
    public String toString() {
        return String
                .format("Employee [id=%s, lastName=%s, firstName=%s, email=%s, salary=%s, department=%s position=%s]",
                        id, lastName, firstName, email, salary,department,position);
    }


}

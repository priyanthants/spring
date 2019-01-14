package com.example.exception;

public class EmployeeNotFound extends RuntimeException {

    public EmployeeNotFound() {
        super("Employee Not Found");
    }
}
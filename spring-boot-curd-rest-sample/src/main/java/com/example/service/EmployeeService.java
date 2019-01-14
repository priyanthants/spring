package com.example.service;

import com.example.exception.EmployeeNotFound;
import com.example.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();

    public EmployeeService() {
        this.employeeList.add(new Employee(1L, "John", "Wick"));
        this.employeeList.add(new Employee(2L, "John", "Smith"));
    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
    }

    public Employee createEmployee(Employee employee) {
        employee.setEmployeeId(Long.valueOf(employeeList.size() + 1));
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee existingEmployee = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        return existingEmployee;
    }

    public Boolean deleteEmployee(Long employeeId) {
        Employee existingEmployee = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
        return employeeList.remove(existingEmployee);
    }
}

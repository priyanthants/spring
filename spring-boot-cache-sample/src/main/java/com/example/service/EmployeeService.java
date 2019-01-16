package com.example.service;

import com.example.exception.EmployeeNotFound;
import com.example.model.Employee;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmployeeService {
    private List<Employee> employeeList = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());


    public EmployeeService() {
        this.employeeList.add(new Employee(1L, "John", "Wick"));
        this.employeeList.add(new Employee(2L, "John", "Smith"));
    }

    @Cacheable(value="employee")
    public List<Employee> getAllEmployee() {
        logger.info(String.format("Service: get all employee details"));
        return employeeList;
    }

    @Cacheable(value="employee", key="#employeeId")
    public Employee getEmployeeById(Long employeeId) {
        logger.info(String.format("Service: get employee details for id %s",employeeId));
        return employeeList.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
    }

    @CachePut(value="employee")
    public Employee createEmployee(Employee employee) {
        logger.info(String.format("Service: create new employee"));
        employee.setEmployeeId(Long.valueOf(employeeList.size() + 1));
        employeeList.add(employee);
        return employee;
    }

    @CachePut(value="employee", key="#employeeId")
    public Employee updateEmployee(Long employeeId, Employee employee) {
        logger.info(String.format("Service: update employee details for id %s",employeeId));
        Employee existingEmployee = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        return existingEmployee;
    }

    @CacheEvict(value="employee", key="#employeeId")
    public Boolean deleteEmployee(Long employeeId) {
        logger.info(String.format("Service: delete employee details for id %s",employeeId));
        Employee existingEmployee = employeeList.stream().filter(emp -> emp.getEmployeeId().equals(employeeId)).findFirst().orElseThrow(() -> new EmployeeNotFound());
        return employeeList.remove(existingEmployee);
    }
}

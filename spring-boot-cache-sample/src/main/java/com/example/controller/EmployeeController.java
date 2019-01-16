package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger logger = Logger.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<Employee> getAllEmployee() {
        logger.info(String.format("Controller: get all employee details"));
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeByID(@PathVariable Long employeeId) {
        logger.info(String.format("Controller: get employee details for id %s",employeeId));
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        logger.info(String.format("Controller: create new employee"));
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        logger.info(String.format("Controller: update employee details for id %s",employeeId));
        return employeeService.updateEmployee(employeeId,employee);
    }

    @DeleteMapping("/{employeeId}")
    public Boolean deleteEmployee(@PathVariable Long employeeId) {
        logger.info(String.format("Controller: delete employee details for id %s",employeeId));
        return employeeService.deleteEmployee(employeeId);
    }
}

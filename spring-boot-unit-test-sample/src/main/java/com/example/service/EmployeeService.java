package com.example.service;

import com.example.exception.EmployeeNotFound;
import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList=new ArrayList<>();
         employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }

    public Employee getEmployeeById(Integer employeeId) {
        return Optional.ofNullable(employeeRepository.findOne(employeeId)).orElseThrow(() -> new EmployeeNotFound());
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Integer employeeId, Employee employee) {
        Employee existingEmployee=getEmployeeById(employeeId);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
       return employeeRepository.save(employee);
    }

    public Boolean deleteEmployee(Integer employeeId) {
       boolean res=Optional.ofNullable(employeeRepository.findOne(employeeId)).isPresent()?true:false;
        employeeRepository.delete(employeeId);
        return res;
    }
}

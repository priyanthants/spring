package com.example.controller;

import com.example.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    protected static final String BASE_URL="http://localhost:8080";
    protected static final String GET_ALL_EMPLOYEE = BASE_URL+"/employee";
    protected static final String CREATE_EMPLOYEE = BASE_URL+"/employee";
    protected static final String GET_ONE_EMPLOYEE = BASE_URL+"/employee/1";
    protected static final String UPDATE_EMPLOYEE = BASE_URL+"/employee/1";
    protected static final String DELETE_EMPLOYEE = BASE_URL+"/employee/1";
    protected List<Employee> employeeList=new ArrayList<>();


    public BaseTest() {
        this.employeeList.add(new Employee(1, "John", "Wick"));
        this.employeeList.add(new Employee(2, "John", "Smith"));
    }

    public Employee getEmployee1WithId(){
        return new Employee(1,"John", "Wick");
    }

    public Employee getEmployee2WithId(){
        return new Employee(2,"John", "Smith");
    }

    public Employee getEmployee1(){
        return new Employee("John", "Wick");
    }

    public Employee getEmployee2(){
        return new Employee("John", "Smith");
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);
    }
}

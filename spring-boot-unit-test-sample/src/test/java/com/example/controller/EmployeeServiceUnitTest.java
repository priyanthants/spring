package com.example.controller;


import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceUnitTest extends BaseTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {
        Employee employee = getEmployee1();
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.createEmployee(employee)).isEqualTo(employee);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = getEmployee1();
        Mockito.when(employeeRepository.findOne(1)).thenReturn(employee);
        assertThat(employeeService.getEmployeeById(1)).isEqualTo(employee);
    }

    @Test
    public void testGetAllEmployee() {

        List<Employee> employeeList = getEmployeeList();
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        assertThat(employeeService.getAllEmployee()).isEqualTo(employeeList);
    }

    @Test
    public void testUpdateEmployee() {

        Employee employee = getEmployee1();
        Mockito.when(employeeRepository.findOne(1)).thenReturn(employee);
        employee.setLastName("updated");
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.updateEmployee(1,employee)).isEqualTo(employee);
    }

}

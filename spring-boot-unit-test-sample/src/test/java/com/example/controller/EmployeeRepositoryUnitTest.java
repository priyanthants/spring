package com.example.controller;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryUnitTest extends BaseTest{

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee(){
        Employee employee= getEmployee1();
        Employee saveInDb=employeeRepository.save(employee);
        Employee getFromDb=employeeRepository.findOne(saveInDb.getEmployeeId());
        assertThat(getFromDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetEmployeeById(){
        Employee employee= getEmployee2();
        Employee saveInDb=employeeRepository.save(employee);
        Employee getFromDb=employeeRepository.findOne(saveInDb.getEmployeeId());
        assertThat(getFromDb).isEqualTo(saveInDb);
    }

    @Test
    public void testGetAllEmployees(){
        entityManager.persist(getEmployee1());
        entityManager.persist(getEmployee2());

        Iterable<Employee> allTicketsFromDb = employeeRepository.findAll();
        List<Employee> ticketList = new ArrayList<>();
        allTicketsFromDb.forEach(ticketList::add);

        assertThat(ticketList.size()).isEqualTo(2);
    }


    @Test
    public void testUpdateEmployee(){
        Employee employee= getEmployee1();
        Employee saveInDb=entityManager.persist(employee);
        Employee getFromDb=employeeRepository.findOne(saveInDb.getEmployeeId());

        assertThat(getFromDb).isEqualTo(saveInDb);
        getFromDb.setFirstName("updated");
        Employee updatedInDb=entityManager.persist(getFromDb);
        Employee getUpdatedFromDb=employeeRepository.findOne(saveInDb.getEmployeeId());


        assertThat(updatedInDb).isEqualTo(getUpdatedFromDb);

    }

    @Test
    public void testDeleteEmployee(){
        Employee persistEmployee=entityManager.persist(getEmployee1());
        entityManager.persist(getEmployee2());

        Iterable<Employee> allTicketsFromDb = employeeRepository.findAll();
        assertThat(((List<Employee>) allTicketsFromDb).size()).isEqualTo(2);


        entityManager.remove(persistEmployee);
        allTicketsFromDb = employeeRepository.findAll();
        assertThat(((List<Employee>) allTicketsFromDb).size()).isEqualTo(1);

    }


}

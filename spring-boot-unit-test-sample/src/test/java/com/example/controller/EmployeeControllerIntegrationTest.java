package com.example.controller;

import com.example.SampleApplication;
import com.example.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest extends BaseTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    private HttpHeaders headers = new HttpHeaders();

    @Test
    public void testSaveEmployee() throws Exception{
        Employee employee = getEmployee1WithId();
        String inputInJson = this.mapToJson(employee);

        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(
                "http://localhost:" + port +"/employee",
                HttpMethod.POST, entity, String.class);

        String responseInJson = response.getBody();
        assertThat(responseInJson).isEqualTo(inputInJson);
    }

    @Test
    public void testGetEmployeeById() throws Exception{
        Employee employee = getEmployee1WithId();
        String inputInJson = this.mapToJson(employee);

        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        testRestTemplate.exchange(
                "http://localhost:" + port +"/employee",
                HttpMethod.POST, entity, String.class);

        String bodyJsonResponse = testRestTemplate.getForObject("http://localhost:" + port +"/employee/1", String.class);
        assertThat(bodyJsonResponse).isEqualTo(inputInJson);
    }
}

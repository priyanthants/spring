package com.example.controller;

import com.example.model.Employee;
import com.example.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class,secure = false)
public class EmployeeControllerJunitTest extends BaseTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    private final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);




    //http://www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/

    @Test
    public void testSaveEmployee() throws Exception{
        Employee employee = getEmployee1WithId();
        Mockito.when(employeeService.createEmployee(employee)).thenReturn(employee);
        String inputInJson = this.mapToJson(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(CREATE_EMPLOYEE)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputInJson).contentType(MediaType.APPLICATION_JSON);;
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outputInJson).isEqualTo(inputInJson);
    }

    @Test
    public void testGetEmployeeById() throws Exception{
        Employee employee = getEmployee1WithId();
        Mockito.when(employeeService.getEmployeeById(1)).thenReturn(employee);
        String expectedJson = mapToJson(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(GET_ONE_EMPLOYEE)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void testGetAllEmployee() throws Exception {
        List<Employee> employeeList=getEmployeeList();
        Mockito.when(employeeService.getAllEmployee()).thenReturn(employeeList);
        String expectedJson = mapToJson(employeeList);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(GET_ALL_EMPLOYEE)
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    public void testUpdateEmployee() throws Exception{

        Employee employee = getEmployee1WithId();
        employee.setLastName("updated");
        Mockito.when(employeeService.updateEmployee(1,employee)).thenReturn(employee);
        String inputInJson = this.mapToJson(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put(UPDATE_EMPLOYEE)
                .accept(MediaType.APPLICATION_JSON)
                .content(inputInJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outputInJson).isEqualTo(inputInJson);
    }

    @Test
    public void testDeleteEmployee()  throws Exception{
        Mockito.when(employeeService.deleteEmployee(1)).thenReturn(true);
        String expectedJson = "true";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete(DELETE_EMPLOYEE);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();

        assertThat(result.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(outputInJson).isEqualTo(expectedJson);

    }
}

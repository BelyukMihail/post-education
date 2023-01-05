package com.qaprosoft.carinademo.api;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EmployeesTest {

    public Properties properties = new Properties();

    {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/api/testdata.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load testdata.properties", e);
        }
    }

    @Test
    public void getAllEmployeesTest() {
        GetAllEmployeesMethod getAllEmployees = new GetAllEmployeesMethod();
        getAllEmployees.callAPIExpectSuccess();
        getAllEmployees.validateResponseAgainstSchema("api/employee/_get/schema.json");
    }

    @Test
    public void getEmployeeTest() {
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod(properties.getProperty("id_get"));
        getEmployeeMethod.callAPI();
        getEmployeeMethod.validateResponse();
    }

    @Test
    public void createEmployeeTest() {
        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context()
                .<Integer>withPredicate("idPredicate", id -> id > 0);
        postEmployeeMethod.callAPI();
        postEmployeeMethod.validateResponse(comparatorContext);
    }

    @Test
    public void updateEmployeeTest() {
        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(properties.getProperty("id_update"));
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }

    @Test
    public void deleteEmployeeTest() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod(properties.getProperty("id_delete"));
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }
}

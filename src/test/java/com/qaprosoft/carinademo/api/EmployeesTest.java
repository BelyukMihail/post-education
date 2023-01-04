package com.qaprosoft.carinademo.api;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Properties;

public class EmployeesTest {

    @Test
    public void getAllEmployeesTest() {
        GetAllEmployeesMethod getAllEmployees = new GetAllEmployeesMethod();
        getAllEmployees.callAPIExpectSuccess();
        getAllEmployees.validateResponseAgainstSchema("api/employee/_get/schema.json");
    }

    @Test
    public void getEmployeeTest() {
        Long id = 1L;
        String stringId = String.valueOf(id);
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod(stringId);
        getEmployeeMethod.callAPI();
        getEmployeeMethod.validateResponse();
    }

    @Test
    public void createEmployeeTest() {
        PostEmployeeMethod postEmployeeMethod = new PostEmployeeMethod();
        JsonComparatorContext comparatorContext = JsonComparatorContext.context().<Integer>withPredicate("idPredicate", id -> id > 0);
        postEmployeeMethod.callAPI();
        postEmployeeMethod.validateResponse(comparatorContext);
    }

    @Test
    public void updateEmployeeTest() {
        Long id = 21L;
        String stringId = String.valueOf(id);
        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(stringId);
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }

    @Test
    public void deleteEmployeeTest() {
        Long id = 1L;
        String stringId = String.valueOf(id);
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod(stringId);
        deleteEmployeeMethod.callAPIExpectSuccess();
    }
}

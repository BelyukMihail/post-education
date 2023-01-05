package com.qaprosoft.carinademo.api;

import com.qaprosoft.apitools.validation.JsonComparatorContext;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

public class EmployeesTest {

    @Test
    public void getAllEmployeesTest() {
        GetAllEmployeesMethod getAllEmployees = new GetAllEmployeesMethod();
        getAllEmployees.callAPIExpectSuccess();
        getAllEmployees.validateResponseAgainstSchema("api/employee/_get/schema.json");
    }

    @Test
    public void getEmployeeTest() {
        GetEmployeeMethod getEmployeeMethod = new GetEmployeeMethod(R.TESTDATA.get("id_get"));
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
        PutEmployeeMethod putEmployeeMethod = new PutEmployeeMethod(R.TESTDATA.get("id_update"));
        putEmployeeMethod.callAPIExpectSuccess();
        putEmployeeMethod.validateResponse();
    }

    @Test
    public void deleteEmployeeTest() {
        DeleteEmployeeMethod deleteEmployeeMethod = new DeleteEmployeeMethod(R.TESTDATA.get("id_delete"));
        deleteEmployeeMethod.callAPIExpectSuccess();
        deleteEmployeeMethod.validateResponse();
    }
}

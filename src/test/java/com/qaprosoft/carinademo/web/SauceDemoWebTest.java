package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.web.util.AddProductsToCartService;
import com.qaprosoft.carinademo.web.util.AuthService;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.annotations.BeforeSuite;

public class SauceDemoWebTest implements IAbstractTest {

    @BeforeSuite
    public void testRailSetup() {
        TestRail.setSuiteId("");
        TestRail.setRunName("First run");
        TestRail.setAssignee("MihBel");
    }

    protected AuthService authService = new AuthService();
    protected AddProductsToCartService addProductsToCartService = new AddProductsToCartService();
}

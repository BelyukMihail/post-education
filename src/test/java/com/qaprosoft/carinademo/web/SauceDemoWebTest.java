package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.web.util.AddProductsToCartService;
import com.qaprosoft.carinademo.web.util.AuthService;
import com.zebrunner.agent.core.registrar.TestRail;
import org.testng.annotations.BeforeSuite;

public class SauceDemoWebTest implements IAbstractTest {

    protected AuthService authService = new AuthService();
    protected AddProductsToCartService addProductsToCartService = new AddProductsToCartService();

    @BeforeSuite
    public void testRailSetup() {
        TestRail.enableRealTimeSync();
        TestRail.setSuiteId("S179");
        TestRail.setRunId("R613");
    }
}

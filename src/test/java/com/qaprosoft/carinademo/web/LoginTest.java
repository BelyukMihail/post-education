package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginTest extends SauceDemoWebTest {

    @Test
    @TestRailCaseId("C3487")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.authenticate(R.TESTDATA.get("user_name_goo"), R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isPageOpened(), "Failed to load page, because page is missing or blocked.");
    }
}

package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends SauceDemoWebTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Failed to load page, because page is missing or blocked.");
    }
}

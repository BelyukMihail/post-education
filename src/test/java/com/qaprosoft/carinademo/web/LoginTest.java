package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends SauceDemoWebTest {

    @Test
    public void loginCheckTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isPageOpened(), "Failed to load page, because page is missing or blocked.");
    }
}

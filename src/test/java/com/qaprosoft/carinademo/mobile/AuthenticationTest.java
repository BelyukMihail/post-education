package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carinademo.mobile.common.HomePageBase;
import com.qaprosoft.carinademo.mobile.common.LoginPageBase;
import com.qaprosoft.carinademo.mobile.ios.LoginPage;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends SauceAppTest {

    @Test
    public void openAppTest() {
        LoginPageBase loginPage = new LoginPage(getDriver());
        HomePageBase homePage = loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isPageOpened(), "Failed to open home page.");
    }
}

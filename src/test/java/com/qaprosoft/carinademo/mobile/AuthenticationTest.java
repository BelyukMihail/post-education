package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.LoginScreenBase;
import com.qaprosoft.carinademo.mobile.ios.LoginScreen;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends SauceAppTest {

    @Test
    public void openAppTest() {
        LoginScreenBase loginPage = new LoginScreen(getDriver());
        HomeScreenBase homePage = loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        Assert.assertTrue(homePage.isOpened(), "Failed to open home page.");
    }
}

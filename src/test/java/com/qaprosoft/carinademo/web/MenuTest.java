package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.SauceLabsHomePage;
import com.qaprosoft.carinademo.web.uiobject.MenuBar;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MenuTest extends SauceDemoWebTest {

    @BeforeSuite
    public void testRailSetup() {
        TestRail.setSuiteId("S179");
        TestRail.enableRealTimeSync();
        TestRail.setRunName("First run");
    }

    @Test
    @TestRailCaseId("C3491")
    public void checkIfAboutLinkWorksTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        homePage.clickMenuBtn();
        MenuBar menuBar = homePage.getMenuBar();
        SauceLabsHomePage sauceLabsHomePage = menuBar.clickAboutLink();
        Assert.assertTrue(sauceLabsHomePage.isPageOpened(), "Failed to reach link page.");
    }
}

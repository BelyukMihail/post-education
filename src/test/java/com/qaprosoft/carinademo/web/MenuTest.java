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
        TestRail.setSuiteId("S180");
        TestRail.setRunName("First run");
        TestRail.setRunId("R608");
        TestRail.enableRealTimeSync();
        TestRail.setAssignee("MihBel");
    }

    @Test
    @TestRailCaseId("C3498")
    public void checkIfAboutLinkWorksTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        homePage.clickMenuBtn();
        MenuBar menuBar = homePage.getMenuBar();
        SauceLabsHomePage sauceLabsHomePage = menuBar.clickAboutLink();
        Assert.assertTrue(sauceLabsHomePage.isPageOpened(), "Failed to reach link page.");
    }
}

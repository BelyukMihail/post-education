package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.report.testrail.TestRailCases;
import com.qaprosoft.carinademo.web.page.*;
import com.qaprosoft.carinademo.web.util.ValueGeneratorService;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTest extends SauceDemoWebTest {

    @BeforeSuite
    public void testRailSetup() {
        TestRail.setSuiteId("S180");
        TestRail.setRunName("First run");
        TestRail.enableRealTimeSync();
        TestRail.setRunId("R608");
        TestRail.setAssignee("MihBel");
    }

    @Test
    @TestRailCaseId("C3497")
    public void checkIfUserCanCheckoutTest() {
        String completeHeaderText = "THANK YOU FOR YOUR ORDER";
        String completeText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        int symbolCount = 5;
        int productCount = 5;
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        addProductsToCartService.addToCart(productCount);
        ShoppingCartPage shoppingCart = homePage.clickShoppingCartBtn();
        Assert.assertTrue(shoppingCart.isPageOpened(), "Failed to open shopping cart page.");
        CheckoutStepOnePage checkoutStepOnePage = shoppingCart.clickCheckoutBtn();
        Assert.assertTrue(checkoutStepOnePage.isPageOpened(), "Failed to open 'Checkout step one page'");

        String firstName = ValueGeneratorService.generateAlphabeticString(symbolCount);
        String lastName = ValueGeneratorService.generateAlphabeticString(symbolCount);
        String postalCode = ValueGeneratorService.generateNumericString(symbolCount);

        checkoutStepOnePage.enterFirstName(firstName);
        checkoutStepOnePage.enterLastName(lastName);
        checkoutStepOnePage.enterPostalCode(postalCode);

        Assert.assertEquals(checkoutStepOnePage.getEnteredFirstName(), firstName, "First name field content doesn't match input.");
        Assert.assertEquals(checkoutStepOnePage.getEnteredLastName(), lastName, "Last name field content doesn't match input.");
        Assert.assertEquals(checkoutStepOnePage.getEnteredPostalCode(), postalCode, "Last name field content doesn't match input.");

        CheckoutStepTwoPage stepTwoPage = checkoutStepOnePage.clickContinueBtn();
        Assert.assertTrue(stepTwoPage.isPageOpened(), "Failed to open 'Checkout step two page' ");
        CheckoutCompletePage completePage = stepTwoPage.clickFinishBtn();
        Assert.assertTrue(completePage.isPageOpened(), "Failed to open 'Checkout complete page'.");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(completePage.getCompleteText(), completeText, "Page text mismatch.");
        softAssert.assertEquals(completePage.getCompleteHeaderText(), completeHeaderText, "Page text mismatch.");
        softAssert.assertAll();
    }
}

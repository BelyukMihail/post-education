package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.*;
import com.qaprosoft.carinademo.web.uiobject.HomePageProductItem;
import com.qaprosoft.carinademo.web.util.AddProductsToCartService;
import com.qaprosoft.carinademo.web.util.ValueGeneratorService;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckoutTest extends SauceDemoWebTest {

    String completeHeaderText = "THANK YOU FOR YOUR ORDER";
    String completeText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
    int symbolCount = 5;

    @Test
    public void checkIfUserCanCheckoutTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageProductItem> homePageProductItems = homePage.getItems();
        AddProductsToCartService.addToCart(homePageProductItems, productCount);
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

        SoftAssert softAssertInput = new SoftAssert();
        softAssertInput.assertEquals(checkoutStepOnePage.getEnteredFirstName(), firstName, "First name field content doesn't match input.");
        softAssertInput.assertEquals(checkoutStepOnePage.getEnteredLastName(), lastName, "Last name field content doesn't match input.");
        softAssertInput.assertEquals(checkoutStepOnePage.getEnteredPostalCode(), postalCode, "Last name field content doesn't match input.");
        softAssertInput.assertAll();

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

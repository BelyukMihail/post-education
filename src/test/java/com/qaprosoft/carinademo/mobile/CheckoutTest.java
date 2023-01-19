package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carinademo.mobile.common.*;
import com.qaprosoft.carinademo.util.ValueGeneratorService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends SauceAppTest {

    @Test
    public void checkIfUserCanCheckoutTest() {
        int symbolCount = 5;
        int maxProductCount = 6;
        HomeScreenBase homeScreen = authService.loginBaseUser();
        homeScreen.addProductsToCart(ValueGeneratorService.generateProductCount(maxProductCount));
        ShoppingCartScreenBase cart = homeScreen.clickShoppingCartBtn();
        CheckoutStepOneScreenBase checkoutStepOne = cart.clickCheckoutBtn();

        String firstName = ValueGeneratorService.generateAlphabeticString(symbolCount);
        String lastName = ValueGeneratorService.generateAlphabeticString(symbolCount);
        String postalCode = ValueGeneratorService.generateNumericString(symbolCount);

        checkoutStepOne.enterFirstName(firstName);
        checkoutStepOne.enterLastName(lastName);
        checkoutStepOne.enterPostalCode(postalCode);

        Assert.assertEquals(firstName, checkoutStepOne.getFirstNameInput(), "Field content doesn't match input data.");
        Assert.assertEquals(lastName, checkoutStepOne.getLastNameInput(), "Field content doesn't match input data.");
        Assert.assertEquals(postalCode, checkoutStepOne.getPostalCodeInput(), "Field content doesn't match input data.");

        CheckoutStepTwoScreenBase checkoutStepTwo = checkoutStepOne.clickContinueBtn();
        CheckoutCompleteScreenBase checkoutComplete = checkoutStepTwo.clickFinishBtn();
        Assert.assertTrue(checkoutComplete.isOpened(), "Failed to navigate to 'Checkout complete' screen");
        Assert.assertTrue(checkoutComplete.isCheckOutCompleteMessageShown(), "Failed to display 'Checkout complete' message");
    }
}

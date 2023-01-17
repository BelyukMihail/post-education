package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carinademo.mobile.common.*;
import com.qaprosoft.carinademo.util.ValueGeneratorService;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends SauceAppTest {

    @Test
    public void checkIfUserCanCheckoutTest() {
        int[] productsCount = {1, 2};
        int symbolCount = 5;
        String expectedMessage = "THANK YOU FOR YOU ORDER";
        HomeScreenBase homeScreen = authService.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        addToCartService.addProductsToCart(productsCount);
        ShoppingCartScreenBase cart = homeScreen.clickShoppingCartBtn(cartXcoordinate, cartYcoordinate);
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
        Assert.assertEquals(checkoutComplete.getCheckoutCompleteMessage(), expectedMessage);
    }
}

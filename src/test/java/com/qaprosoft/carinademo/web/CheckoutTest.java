package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.*;
import com.qaprosoft.carinademo.web.uiobject.HomePageItem;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CheckoutTest extends SauceDemoWebTest {

    @Test
    public void checkIfUserCanCheckoutTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageItem> homePageItems = homePage.getItems();
        for (int i = 0; i < R.TESTDATA.getInt("products_count"); i++) {
            homePageItems.get(i).clickAddToCartButton();
        }
        ShoppingCartPage shoppingCart = homePage.clickShoppingCartBtn();
        Assert.assertTrue(shoppingCart.isPageOpened(), "Failed to open shopping cart page.");
        CheckoutStepOnePage checkoutStepOnePage = shoppingCart.clickCheckoutBtn();
        Assert.assertTrue(checkoutStepOnePage.isPageOpened(), "Failed to open 'Checkout step one page'");

        String firstName = R.TESTDATA.get("user_first_name");
        String lastName = R.TESTDATA.get("user_last_name");
        String postalCode = R.TESTDATA.get("user_postal_code");

        checkoutStepOnePage.enterFirstName(firstName);
        checkoutStepOnePage.enterLastName(lastName);
        checkoutStepOnePage.enterPostalCode(postalCode);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(checkoutStepOnePage.getEnteredFirstName(), firstName, "First name field content doesn't match input.");
        softAssert.assertEquals(checkoutStepOnePage.getEnteredLastName(), lastName, "Last name field content doesn't match input.");
        softAssert.assertEquals(checkoutStepOnePage.getEnteredPostalCode(), postalCode, "Last name field content doesn't match input.");
        softAssert.assertAll();

        CheckoutStepTwoPage stepTwoPage = checkoutStepOnePage.clickContinueBtn();
        Assert.assertTrue(stepTwoPage.isPageOpened(), "Failed to open 'Checkout step two page' ");
        CheckoutCompletePage completePage = stepTwoPage.clickFinishBtn();
        Assert.assertTrue(completePage.isPageOpened(), "Failed to open 'Checkout complete page'.");
    }
}

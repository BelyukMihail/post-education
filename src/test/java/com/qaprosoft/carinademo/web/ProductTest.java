package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.ProductPage;
import com.qaprosoft.carinademo.web.page.ShoppingCartPage;
import com.qaprosoft.carinademo.web.uiobject.HomePageItem;
import com.qaprosoft.carinademo.web.uiobject.ShoppingCartItem;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ProductTest extends SauceDemoWebTest {

    @Test
    public void compareItemDescriptionTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageItem> homePageItems = homePage.getItems();
        String homePageDescription;
        String productPageDescription;
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i <= homePageItems.size() - 1; i++) {
            homePageDescription = homePageItems.get(i).getItemDescription();
            ProductPage productPage = homePageItems.get(i).clickItemName();
            productPageDescription = productPage.getItemDescription();
            productPage.clickBackToProducts();
            softAssert.assertEquals(homePageDescription, productPageDescription);
        }
        softAssert.assertAll();
    }

    @Test
    public void itemsCanBeAddedToCartTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageItem> homePageItems = homePage.getItems();
        List<String> addedItemsNames = new ArrayList<>();
        for (int i = 0; i < R.TESTDATA.getInt("products_count"); i++) {
            homePageItems.get(i).clickAddToCartButton();
            String addedItemName = homePageItems.get(i).getItemName();
            addedItemsNames.add(addedItemName);
        }

        ShoppingCartPage cartPage = homePage.clickShoppingCartBtn();
        List<ShoppingCartItem> cartItems = cartPage.getCartItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addedItemsNames.size(), cartItems.size(), "The added products count doesn't match products count in cart");
        for (ShoppingCartItem shoppingCartItem : cartItems) {
            String cartItemName = shoppingCartItem.getItemName();
            softAssert.assertTrue(addedItemsNames.stream()
                    .anyMatch(name -> name.equals(cartItemName)), "No matching item names found");
        }
        softAssert.assertAll();
    }


}


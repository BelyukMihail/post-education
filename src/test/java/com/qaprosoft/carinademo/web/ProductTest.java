package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.ProductPage;
import com.qaprosoft.carinademo.web.page.ShoppingCartPage;
import com.qaprosoft.carinademo.web.uiobject.HomePageProductItem;
import com.qaprosoft.carinademo.web.uiobject.ShoppingCartProductItem;
import com.zebrunner.agent.core.annotation.TestRailCaseId;
import com.zebrunner.agent.core.registrar.TestRail;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ProductTest extends SauceDemoWebTest {

    @Test
    @TestRailCaseId("C3488")
    public void compareItemDescriptionTest() {
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageProductItem> homePageProductItems = homePage.getItems();
        String homePageDescription;
        String productPageDescription;
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i <= homePageProductItems.size() - 1; i++) {
            homePageDescription = homePageProductItems.get(i).getItemDescription();
            ProductPage productPage = homePageProductItems.get(i).clickItemName();
            productPageDescription = productPage.getItemDescription();
            productPage.clickBackToProducts();
            softAssert.assertEquals(homePageDescription, productPageDescription);
        }
        softAssert.assertAll();
    }

    @Test
    @TestRailCaseId("C3489")
    public void itemsCanBeAddedToCartTest() {
        int productCount = 5;
        HomePage homePage = authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<HomePageProductItem> homePageProductItems = homePage.getItems();
        List<String> addedItemsNames = new ArrayList<>();
        addProductsToCartService.addToCart(productCount);
        for (int i = 0; i < productCount; i++) {
            String addedItemName = homePageProductItems.get(i).getItemName();
            addedItemsNames.add(addedItemName);
        }
        ShoppingCartPage cartPage = homePage.clickShoppingCartBtn();
        List<ShoppingCartProductItem> cartItems = cartPage.getCartItems();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(addedItemsNames.size(), cartItems.size(), "The added products count doesn't match products count in cart");
        for (ShoppingCartProductItem shoppingCartProductItem : cartItems) {
            String cartItemName = shoppingCartProductItem.getItemName();
            softAssert.assertTrue(addedItemsNames.stream().anyMatch(name -> name.equals(cartItemName)), "No matching item names found");
        }
        softAssert.assertAll();
    }
}


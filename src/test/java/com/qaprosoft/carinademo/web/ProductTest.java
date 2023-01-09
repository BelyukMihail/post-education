package com.qaprosoft.carinademo.web;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.ProductPage;
import com.qaprosoft.carinademo.web.uiobject.Item;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductTest extends SauceDemoWebTest {

    @Test
    public void compareItemDescriptionTest() {
        authService.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        HomePage homePage = new HomePage(getDriver());
        List<Item> items = homePage.getItems();
        String homePageDescription;
        String productPageDescription;
        SoftAssert softAssert = new SoftAssert();
        for (int i = 0; i <= items.size() - 1; i++) {
            homePageDescription = items.get(i).getItemDescription();
            ProductPage productPage = items.get(i).clickItemName();
            productPageDescription = productPage.getItemDescription();
            productPage.clickBackToProducts();
            softAssert.assertEquals(homePageDescription, productPageDescription);
        }
        softAssert.assertAll();
    }
}


package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.qaprosoft.carinademo.web.page.ProductPage;
import com.qaprosoft.carinademo.web.uiobject.Item;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SauceDemoTest implements IAbstractTest {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        Assert.assertEquals(R.TESTDATA.get("home_page_url"), getDriver().getCurrentUrl());
    }

    @Test
    public void compareItemDescriptionTest() {
        HomePage homePage = new HomePage(getDriver());
        List<Item> items = homePage.getItems();
        int itemsOnPage = items.size() - 1;
        String homePageDescription;
        String productPageDescription;
        SoftAssert softAssert = new SoftAssert();
        while (itemsOnPage != -1) {
            homePageDescription = items.get(itemsOnPage).getItemDescription();
            ProductPage productPage = items.get(itemsOnPage).clickItemName();
            productPageDescription = productPage.getItemDescription();
            productPage.clickBackToProducts();
            itemsOnPage--;
            softAssert.assertEquals(homePageDescription, productPageDescription);
        }
        softAssert.assertAll();
    }
}


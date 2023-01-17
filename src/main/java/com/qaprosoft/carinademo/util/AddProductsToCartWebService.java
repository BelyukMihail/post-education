package com.qaprosoft.carinademo.util;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.uiobject.HomePageProductItem;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import java.util.List;

public class AddProductsToCartWebService implements ICustomTypePageFactory {

    public void addToCart(int productCount) {
        HomePage homePage = new HomePage(getDriver());
        List<HomePageProductItem> products = homePage.getItems();
        for (int i = 0; i < productCount; i++) {
            products.get(i).clickAddToCartButton();
        }
    }
}

package com.qaprosoft.carinademo.util;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import java.util.Arrays;
import java.util.List;

public class AddProductsToCartMobileService implements ICustomTypePageFactory {

    public void addProductsToCart(int... productCounts) {
        HomeScreenBase homeScreen = initPage(getDriver(), HomeScreenBase.class);
        List<ExtendedWebElement> products = homeScreen.getProducts();
        Arrays.stream(productCounts)
                .forEach(count -> products.get(count).click());
    }
}

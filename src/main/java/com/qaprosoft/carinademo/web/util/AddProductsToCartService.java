package com.qaprosoft.carinademo.web.util;

import com.qaprosoft.carinademo.web.uiobject.HomePageProductItem;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

import java.util.List;

public class AddProductsToCartService implements ICustomTypePageFactory {

    public static void addToCart(List<HomePageProductItem> items, int productCount) {
        for (int i = 0; i < productCount; i++) {
            items.get(i).clickAddToCartButton();
        }
    }
}

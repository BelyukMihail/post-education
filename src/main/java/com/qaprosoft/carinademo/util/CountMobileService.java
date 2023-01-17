package com.qaprosoft.carinademo.util;

import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class CountMobileService implements ICustomTypePageFactory {

    public int countProductsInShoppingCart() {
        ShoppingCartScreenBase shoppingCartScreen = initPage(getDriver(), ShoppingCartScreenBase.class);
        return shoppingCartScreen.getProductList().size();
    }
}

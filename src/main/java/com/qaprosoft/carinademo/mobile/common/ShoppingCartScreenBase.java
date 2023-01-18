package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class ShoppingCartScreenBase extends SauceDemoAbstractScreenBase {

    public ShoppingCartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void deleteProductsFromCartBySwipe();

    public abstract CheckoutStepOneScreenBase clickCheckoutBtn();

    public abstract int getProductsInCartCount();

}

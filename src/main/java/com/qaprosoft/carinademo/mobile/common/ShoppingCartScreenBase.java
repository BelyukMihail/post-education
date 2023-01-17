package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ShoppingCartScreenBase extends SauceDemoAbstractScreenBase {

    public ShoppingCartScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ExtendedWebElement> getProductList();

    public abstract void deleteProductsFromCartBySwipe();

    public abstract CheckoutStepOneScreenBase clickCheckoutBtn();

}

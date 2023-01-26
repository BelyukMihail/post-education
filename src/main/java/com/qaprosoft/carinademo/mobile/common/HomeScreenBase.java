package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomeScreenBase extends SauceDemoAbstractScreenBase {

    public HomeScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilterBtn();

    public abstract void clickPriceLowToHigh();

    public abstract List<String> getProductPrices();

    public abstract ShoppingCartScreenBase clickShoppingCartBtn();

    public abstract void addProductsToCart(int productCount);

    public abstract MenuScreenBase clickMenuBtn();

}



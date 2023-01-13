package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickFilterBtn();

    public abstract void clickPriceLowToHigh();

    public abstract List<String> getProductPrices();

}



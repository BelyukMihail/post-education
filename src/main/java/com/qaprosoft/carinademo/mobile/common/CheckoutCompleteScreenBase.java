package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutCompleteScreenBase extends SauceDemoAbstractScreenBase {

    public CheckoutCompleteScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getCheckoutCompleteMessage();

}

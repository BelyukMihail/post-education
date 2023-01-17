package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutStepTwoScreenBase extends SauceDemoAbstractScreenBase {

    public CheckoutStepTwoScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckoutCompleteScreenBase clickFinishBtn();

}

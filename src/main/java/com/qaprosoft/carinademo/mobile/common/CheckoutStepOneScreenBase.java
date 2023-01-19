package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutStepOneScreenBase extends SauceDemoAbstractScreenBase {

    public CheckoutStepOneScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterFirstName(String firstName);

    public abstract void enterLastName(String lastName);

    public abstract void enterPostalCode(String postalCode);

    public abstract CheckoutStepTwoScreenBase clickContinueBtn();

    public abstract String getFirstNameInput();

    public abstract String getLastNameInput();

    public abstract String getPostalCodeInput();

}

package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginScreenBase extends SauceDemoAbstractScreenBase {

    public LoginScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterUserName(String userName);

    public abstract void enterPassword(String password);

    public abstract HomeScreenBase clickLoginBtn();

    public abstract HomeScreenBase authenticate(String userName, String password);

}

package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carinademo.web.page.HomePage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends HomePage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterUserName(String userName);

    public abstract void enterPassword(String password);

    public abstract HomePageBase clickLoginBtn();

    public abstract HomePageBase authenticate(String userName, String password);

}

package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='user-name']")
    private ExtendedWebElement userNameField;

    @FindBy(xpath = "//*[@id='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//*[@id='login-button']")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
        open();
    }

    public void authenticate(String name, String password) {
        userNameField.type(name);
        passwordField.type(password);
        loginBtn.click();
    }
}
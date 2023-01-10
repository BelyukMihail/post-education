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

    public void enterName(String name) {
        userNameField.type(name);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public HomePage clickLoginButton() {
        loginBtn.click();
        return new HomePage(getDriver());
    }

    public HomePage authenticate(String name, String password) {
        enterName(name);
        enterPassword(password);
        return clickLoginButton();
    }
}

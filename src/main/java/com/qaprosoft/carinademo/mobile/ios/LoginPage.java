package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carinademo.mobile.common.HomePageBase;
import com.qaprosoft.carinademo.mobile.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "test-Username")
    private ExtendedWebElement userNameField;

    @FindBy(id = "test-Password")
    private ExtendedWebElement passwordField;

    @FindBy(id = "test-LOGIN")
    private ExtendedWebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUserName(String userName) {
        userNameField.type(userName);
    }

    @Override
    public void enterPassword(String password) {
        passwordField.type(password);
    }

    @Override
    public HomePageBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomePageBase.class);
    }

    @Override
    public HomePageBase authenticate(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        return clickLoginBtn();
    }
}

package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Username'`]")
    private ExtendedWebElement userNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeSecureTextType[`name='Password'`]")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name='test-LOGIN'`]")
    private ExtendedWebElement loginBtn;

    public LoginScreen(WebDriver driver) {
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
    public HomeScreenBase clickLoginBtn() {
        loginBtn.click();
        return initPage(getDriver(), HomeScreenBase.class);
    }

    @Override
    public HomeScreenBase login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        return clickLoginBtn();
    }
}

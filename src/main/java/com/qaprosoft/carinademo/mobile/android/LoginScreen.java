package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginScreenBase.class)
public class LoginScreen extends LoginScreenBase {

    public LoginScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterUserName(String userName) {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public void enterPassword(String password) {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public HomeScreenBase clickLoginBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public HomeScreenBase login(String userName, String password) {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public boolean isOpened() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

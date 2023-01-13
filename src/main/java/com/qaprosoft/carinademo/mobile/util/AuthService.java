package com.qaprosoft.carinademo.mobile.util;

import com.qaprosoft.carinademo.mobile.common.HomePageBase;
import com.qaprosoft.carinademo.mobile.common.LoginPageBase;
import com.qaprosoft.carinademo.mobile.ios.LoginPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthService implements ICustomTypePageFactory {

    public HomePageBase authenticate(String userName, String password) {
        LoginPageBase loginPage = new LoginPage(getDriver());
        return loginPage.authenticate(userName, password);
    }
}



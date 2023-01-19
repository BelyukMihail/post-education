package com.qaprosoft.carinademo.util;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthWebService implements ICustomTypePageFactory {

    public HomePage login(String userName, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage.authenticate(userName, password);
    }
}

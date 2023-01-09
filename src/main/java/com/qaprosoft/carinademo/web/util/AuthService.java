package com.qaprosoft.carinademo.web.util;

import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthService implements ICustomTypePageFactory {

    public void login(String userName, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authenticate(userName, password);
    }
}

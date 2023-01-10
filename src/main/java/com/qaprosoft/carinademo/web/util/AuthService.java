package com.qaprosoft.carinademo.web.util;

import com.qaprosoft.carinademo.web.page.HomePage;
import com.qaprosoft.carinademo.web.page.LoginPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthService implements ICustomTypePageFactory {

    public HomePage login(String userName, String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage.authenticate(userName, password);
    }
}

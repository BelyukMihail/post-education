package com.qaprosoft.carinademo.web.util;

import com.qaprosoft.carinademo.web.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class AuthService {

    public void login(String userName, String password, WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authenticate(userName, password);
    }
}

package com.qaprosoft.carinademo.util;

import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthMobileService implements ICustomTypePageFactory {

    public HomeScreenBase authenticate(String userName, String password) {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        return loginPage.login(userName, password);
    }
}



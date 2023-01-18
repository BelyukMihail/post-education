package com.qaprosoft.carinademo.util;

import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.LoginScreenBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class AuthMobileService implements ICustomTypePageFactory {

    public HomeScreenBase login(String userName, String password) {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        return loginPage.login(userName, password);
    }

    public HomeScreenBase loginBaseUser() {
        LoginScreenBase loginPage = initPage(getDriver(), LoginScreenBase.class);
        return loginPage.login(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
    }
}



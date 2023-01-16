package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ShoppingCartScreenBase.class)
public class ShoppingCartScreen extends ShoppingCartScreenBase {

    public ShoppingCartScreen(WebDriver driver) {
        super(driver);
    }
}

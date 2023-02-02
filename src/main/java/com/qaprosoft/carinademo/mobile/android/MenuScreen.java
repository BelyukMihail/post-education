package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.qaprosoft.carinademo.mobile.common.MenuScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {

    public MenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public DrawingScreenBase clickDrawingLink() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

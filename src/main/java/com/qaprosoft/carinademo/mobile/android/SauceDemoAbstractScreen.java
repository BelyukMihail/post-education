package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.SauceDemoAbstractScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SauceDemoAbstractScreenBase.class)
public abstract class SauceDemoAbstractScreen extends SauceDemoAbstractScreenBase {

    public SauceDemoAbstractScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
       throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

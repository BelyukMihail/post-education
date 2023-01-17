package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.CheckoutCompleteScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutCompleteScreenBase.class)
public class CheckoutCompleteScreen extends CheckoutCompleteScreenBase {

    private static final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID = "This method is not implemented on ANDROID";

    public CheckoutCompleteScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getCheckoutCompleteMessage() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public boolean isOpened() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

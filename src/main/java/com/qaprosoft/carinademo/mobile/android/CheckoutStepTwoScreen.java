package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.CheckoutCompleteScreenBase;
import com.qaprosoft.carinademo.mobile.common.CheckoutStepTwoScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutStepTwoScreenBase.class)
public class CheckoutStepTwoScreen extends CheckoutStepTwoScreenBase {

    public CheckoutStepTwoScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutCompleteScreenBase clickFinishBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingScreenBase.class)
public class DrawingScreen extends DrawingScreenBase {

    public DrawingScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public void clickClearBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public boolean isEmptyPadPresent() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public boolean isDrawingPresent() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

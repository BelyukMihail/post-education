package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.foundation.webdriver.device.Device;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carinademo.util.PlatformService;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class SauceDemoAbstractScreenBase extends AbstractPage implements IMobileUtils {

    protected final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID = "This method is not implemented on ANDROID";
    protected final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS = "This method is not implemented on IOS";
    protected final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_PROVIDED_DEVICE = "This method is not implemented on provided device";

    public SauceDemoAbstractScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        DeviceType.Type deviceType = PlatformService.getDeviceType();
        switch (deviceType) {
            case IOS_PHONE:
                throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS);
            case ANDROID_PHONE:
                throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
        }
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_PROVIDED_DEVICE);
    }

    public void tapElementBottomLeft(int pointXcoordinate, int pointYcoordinate, int elementHeight) {
        tap(pointXcoordinate + 1, pointYcoordinate + elementHeight - 1);
    }
}

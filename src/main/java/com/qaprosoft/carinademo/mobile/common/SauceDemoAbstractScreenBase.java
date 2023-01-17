package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class SauceDemoAbstractScreenBase extends AbstractPage implements IMobileUtils {

    protected final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID = "This method is not implemented on ANDROID";
    protected final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS = "This method is not implemented on IOS";

    public SauceDemoAbstractScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

}

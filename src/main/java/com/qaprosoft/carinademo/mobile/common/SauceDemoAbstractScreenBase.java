package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;

public abstract class SauceDemoAbstractScreenBase extends AbstractPage implements IMobileUtils {

    public SauceDemoAbstractScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

}

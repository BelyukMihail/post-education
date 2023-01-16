package com.qaprosoft.carinademo.mobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SauceDemoAbstractScreenBase extends AbstractPage {

    public SauceDemoAbstractScreenBase(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        throw new UnsupportedOperationException();
    }

}

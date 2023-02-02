package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class MenuScreenBase extends SauceDemoAbstractScreenBase {

    public MenuScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract DrawingScreenBase clickDrawingLink();

}

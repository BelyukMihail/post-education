package com.qaprosoft.carinademo.mobile.common;

import org.openqa.selenium.WebDriver;

public abstract class DrawingScreenBase extends SauceDemoAbstractScreenBase {

    public DrawingScreenBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawPicture();

    public abstract void clickClearBtn();

    public abstract boolean isEmptyPadPresent();

    public abstract boolean isDrawingPresent();

}

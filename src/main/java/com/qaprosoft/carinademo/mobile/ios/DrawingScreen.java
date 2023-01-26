package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingScreenBase.class)
public class DrawingScreen extends DrawingScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CLEAR'`]")
    private ExtendedWebElement clearBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Signature Pad demo'`]")
    private ExtendedWebElement signaturePad;

    @ExtendedFindBy(image = "img/empty_drawing_area.png")
    private ExtendedWebElement emptyDrawingArea;

    @ExtendedFindBy(image = "img/drawing.png")
    private ExtendedWebElement drawing;

    public DrawingScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawPicture() {
        swipe(259, 330, 138, 450, 500);
        swipe(138, 450, 250, 450, 500);
        swipe(250, 450, 140, 566, 500);
    }


    @Override
    public void clickClearBtn() {
        clearBtn.click();
    }

    @Override
    public boolean isOpened() {
        return signaturePad.isElementPresent();
    }

    @Override
    public boolean isEmptyPadPresent() {
        return emptyDrawingArea.isElementPresent();
    }

    @Override
    public boolean isDrawingPresent() {
        return drawing.isElementPresent();
    }
}

package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import io.appium.java_client.Setting;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
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
        Point position = signaturePad.getLocation();
        Dimension size = signaturePad.getSize();
        int startX = position.x + size.width / 10;
        int startY = position.y + size.height / 10;
        int endX = startX * 5;
        tap(startX, startY);
        int pixelCount = 0;
        for (int i = 0; i < 30; i++) {
            swipe(startX, startY + pixelCount, endX, startY, 200);
            pixelCount++;
        }
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
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        return emptyDrawingArea.isElementPresent();
    }

    @Override
    public boolean isDrawingPresent() {
        setSetting(Setting.FIX_IMAGE_TEMPLATE_SCALE, true);
        setSetting(Setting.IMAGE_MATCH_THRESHOLD, 0.7);
        return drawing.isElementPresent();
    }
}

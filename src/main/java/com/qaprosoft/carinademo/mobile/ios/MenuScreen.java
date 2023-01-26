package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.qaprosoft.carinademo.mobile.common.MenuScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuScreenBase.class)
public class MenuScreen extends MenuScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`label == 'DRAWING'`]")
    private ExtendedWebElement drawingLink;

    public MenuScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public DrawingScreenBase clickDrawingLink() {
        drawingLink.click();
        return initPage(getDriver(), DrawingScreenBase.class);
    }
}

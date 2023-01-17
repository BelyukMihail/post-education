package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.CheckoutCompleteScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutCompleteScreenBase.class)
public class CheckoutCompleteScreen extends CheckoutCompleteScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == 'THANK YOU FOR YOU ORDER'`]")
    private ExtendedWebElement checkoutCompleteMessage;

    public CheckoutCompleteScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getCheckoutCompleteMessage() {
        return checkoutCompleteMessage.getText();
    }

    @Override
    public boolean isOpened() {
        return checkoutCompleteMessage.isElementPresent();
    }
}


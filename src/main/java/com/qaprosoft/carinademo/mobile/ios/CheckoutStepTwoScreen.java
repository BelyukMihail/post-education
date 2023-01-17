package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.CheckoutCompleteScreenBase;
import com.qaprosoft.carinademo.mobile.common.CheckoutStepTwoScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutStepTwoScreenBase.class)
public class CheckoutStepTwoScreen extends CheckoutStepTwoScreenBase {

    private static final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS = "This method is not implemented on iOS";

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-FINISH'`]")
    private ExtendedWebElement finishBtn;

    public CheckoutStepTwoScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public CheckoutCompleteScreenBase clickFinishBtn() {
        finishBtn.click();
        return initPage(getDriver(), CheckoutCompleteScreenBase.class);
    }

    @Override
    public boolean isOpened() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS);
    }
}

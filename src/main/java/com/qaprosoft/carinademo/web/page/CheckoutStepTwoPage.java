package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='finish']")
    private ExtendedWebElement finishBtn;

    @FindBy(xpath = "//*[contains(text(),'Overview')]")
    private ExtendedWebElement pageTitle;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
    }

    public CheckoutCompletePage clickFinishBtn() {
        finishBtn.click();
        return new CheckoutCompletePage(getDriver());
    }
}

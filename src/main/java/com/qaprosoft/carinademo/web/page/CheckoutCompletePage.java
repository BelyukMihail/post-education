package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='pony_express']")
    private ExtendedWebElement ponyExpressPic;

    @FindBy(xpath = "//*[@class='complete-header']")
    private ExtendedWebElement completeHeader;

    @FindBy(xpath = "//*[@class='complete-text']")
    private ExtendedWebElement completeText;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(ponyExpressPic);
    }

    public String getCompleteHeaderText() {
        return completeHeader.getText();
    }

    public String getCompleteText() {
        return completeText.getText();
    }
}

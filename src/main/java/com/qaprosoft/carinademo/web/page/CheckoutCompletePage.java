package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='pony_express']")
    private ExtendedWebElement ponyExpressPic;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(ponyExpressPic);
    }
}

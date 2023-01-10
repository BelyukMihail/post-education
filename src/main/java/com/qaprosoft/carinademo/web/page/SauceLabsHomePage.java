package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SauceLabsHomePage extends AbstractPage {

    @FindBy(xpath = "//*[contains(text(),'DEVELOP WITH CONFIDENCE')]")
    private ExtendedWebElement superTitle;

    public SauceLabsHomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(superTitle);
    }
}

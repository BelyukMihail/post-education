package com.qaprosoft.carinademo.web.uiobject;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carinademo.web.page.SauceLabsHomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MenuBar extends AbstractUIObject {

    @FindBy(xpath = ".//*[@id='about_sidebar_link']")
    private ExtendedWebElement aboutLink;

    public MenuBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SauceLabsHomePage clickAboutLink() {
        aboutLink.click();
        return new SauceLabsHomePage(getDriver());
    }
}

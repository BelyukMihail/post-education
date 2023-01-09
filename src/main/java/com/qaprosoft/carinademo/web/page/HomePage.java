package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carinademo.web.uiobject.Item;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='inventory_list']//*[@class='inventory_item']")
    private List<Item> items;

    @FindBy(xpath = "//*[@class='app_logo']")
    private ExtendedWebElement logo;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public List<Item> getItems() {
        return items;
    }
}

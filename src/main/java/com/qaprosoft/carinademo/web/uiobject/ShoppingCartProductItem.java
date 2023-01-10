package com.qaprosoft.carinademo.web.uiobject;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class='inventory_item_name']")
    private ExtendedWebElement itemName;

    public ShoppingCartProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }
}

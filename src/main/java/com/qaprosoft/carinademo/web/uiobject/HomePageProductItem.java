package com.qaprosoft.carinademo.web.uiobject;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carinademo.web.page.ProductPage;
import com.qaprosoft.carinademo.web.page.ShoppingCartPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageProductItem extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class='inventory_item_name']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//*[@class='inventory_item_description']")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = ".//*[contains(text(),'Add to cart')]")
    private ExtendedWebElement addToCartBtn;

    public HomePageProductItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public ProductPage clickItemName() {
        itemName.click();
        return new ProductPage(getDriver());
    }

    public ShoppingCartPage clickAddToCartButton() {
        addToCartBtn.click();
        return new ShoppingCartPage(getDriver());
    }

    public String getItemName() {
        return itemName.getText();
    }
}

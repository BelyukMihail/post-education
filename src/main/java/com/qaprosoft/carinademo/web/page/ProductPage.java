package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='inventory_details_desc_container']")
    private ExtendedWebElement itemDescription;

    @FindBy(xpath = "//*[@id='back-to-products']")
    private ExtendedWebElement backToProductsBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public void clickBackToProducts() {
        backToProductsBtn.click();
    }
}

package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carinademo.web.uiobject.HomePageItem;
import com.qaprosoft.carinademo.web.uiobject.MenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='inventory_list']//*[@class='inventory_item']")
    private List<HomePageItem> homePageItems;

    @FindBy(xpath = "//*[@class='bm-menu']")
    private MenuBar menuBar;

    @FindBy(xpath = "//*[@class='app_logo']")
    private ExtendedWebElement logo;

    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    private ExtendedWebElement shoppingCartBtn;

    @FindBy(xpath = "//*[contains(@id,'menu-btn')]")
    private ExtendedWebElement menuBtn;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(logo);
    }

    public List<HomePageItem> getItems() {
        return homePageItems;
    }

    public ShoppingCartPage clickShoppingCartBtn() {
        shoppingCartBtn.click();
        return new ShoppingCartPage(getDriver());
    }

    public void clickMenuBtn() {
        menuBtn.click();
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }
}

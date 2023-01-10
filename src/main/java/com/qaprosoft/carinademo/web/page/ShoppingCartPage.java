package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carinademo.web.uiobject.ShoppingCartProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='cart_item']")
    private List<ShoppingCartProductItem> cartItems;

    @FindBy(xpath = "//*[@id='checkout']")
    private ExtendedWebElement checkoutBtn;

    @FindBy(xpath = "//*[contains(text(),'Cart')]")
    private ExtendedWebElement pageTitle;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
    }

    public List<ShoppingCartProductItem> getCartItems() {
        return cartItems;
    }

    public CheckoutStepOnePage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutStepOnePage(getDriver());
    }
}

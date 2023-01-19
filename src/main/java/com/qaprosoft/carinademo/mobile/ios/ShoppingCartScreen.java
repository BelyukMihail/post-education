package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.CheckoutStepOneScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ShoppingCartScreenBase.class)
public class ShoppingCartScreen extends ShoppingCartScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Item'`]")
    private List<ExtendedWebElement> products;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Delete'`]")
    private ExtendedWebElement binBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CHECKOUT'`]")
    private ExtendedWebElement checkOutBtn;

    public ShoppingCartScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void deleteProductsFromCartBySwipe() {
        products.forEach(product -> {
            swipeLeft(product, 1000);
            clickBinBtn();
        });
    }

    @Override
    public CheckoutStepOneScreenBase clickCheckoutBtn() {
        checkOutBtn.click();
        return initPage(getDriver(), CheckoutStepOneScreenBase.class);
    }

    @Override
    public int getProductsInCartCount() {
        return products.size();
    }

    public void clickBinBtn() {
        binBtn.click();
    }

    @Override
    public boolean isOpened() {
        return checkOutBtn.isElementPresent();
    }
}

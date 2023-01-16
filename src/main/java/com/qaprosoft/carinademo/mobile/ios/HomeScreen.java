package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]/XCUIElementTypeOther")
    private ExtendedWebElement shoppingCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == 'PRODUCTS'`]")
    private ExtendedWebElement homePageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]")
    private ExtendedWebElement filterBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Price (low to high)'`]")
    private ExtendedWebElement priceLowToHighBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private List<ExtendedWebElement> productPrices;

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickFilterBtn() {
        filterBtn.click();
    }

    @Override
    public void clickPriceLowToHigh() {
        priceLowToHighBtn.click();
    }

    @Override
    public List<String> getProductPrices() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartScreenBase clickShoppingCartBtn() {
        shoppingCartBtn.click();
        return initPage(getDriver(), ShoppingCartScreenBase.class);
    }

    @Override
    public boolean isOpened() {
        return homePageTitle.isElementPresent();
    }
}

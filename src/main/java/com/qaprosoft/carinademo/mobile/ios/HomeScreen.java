package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.MenuScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.qaprosoft.carinademo.util.PlatformService;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static com.qaprosoft.carinademo.mobile.DeviceName.IPHONE_14_PRO;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-ADD TO CART'`]")
    private List<ExtendedWebElement> addToCartBtns;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`label == 'PRODUCTS'`]")
    private ExtendedWebElement homePageTitle;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Modal Selector Button'`]")
    private ExtendedWebElement filterBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'Price (low to high)'`]")
    private ExtendedWebElement priceLowToHighBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeStaticText[`name == 'test-Price'`]")
    private List<ExtendedWebElement> productPrices;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Cart'`]")
    private ExtendedWebElement shoppingCartBtn;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-Menu'`]")
    private ExtendedWebElement menuBtn;

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
        if (PlatformService.isDevice(IPHONE_14_PRO.getDisplayName())) {
            Dimension dimension = shoppingCartBtn.getSize();
            Point point = shoppingCartBtn.getLocation();
            tap(point.x + 1, point.y + dimension.height - 1);
        } else {
            shoppingCartBtn.click();
        }
        return initPage(getDriver(), ShoppingCartScreenBase.class);
    }

    @Override
    public void addProductsToCart(int productCount) {
        addToCartBtns.stream()
                .limit(productCount)
                .forEach(ExtendedWebElement::click);
    }

    @Override
    public MenuScreenBase clickMenuBtn() {
        if (PlatformService.isDevice(IPHONE_14_PRO.getDisplayName())) {
            Dimension dimension = menuBtn.getSize();
            Point point = menuBtn.getLocation();
            tap(point.x + 1, point.y + dimension.height - 1);
        } else {
            menuBtn.click();
        }
        return initPage(getDriver(), MenuScreenBase.class);
    }

    @Override
    public boolean isOpened() {
        return homePageTitle.isElementPresent();
    }
}

package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @ExtendedFindBy(iosPredicate = "label == 'PRODUCTS' AND name == 'PRODUCTS' AND value == 'PRODUCTS'")
    private ExtendedWebElement productsTitle;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement filterBtn;

    @ExtendedFindBy(accessibilityId = "Price (low to high)")
    private ExtendedWebElement priceLowToHighBtn;

    @FindBy(name = "test-Price")
    private List<ExtendedWebElement> productPrices;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productsTitle);
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
}

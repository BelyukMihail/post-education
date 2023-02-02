package com.qaprosoft.carinademo.mobile.android;

import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.MenuScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomeScreenBase.class)
public class HomeScreen extends HomeScreenBase {

    public HomeScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickFilterBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);

    }

    @Override
    public void clickPriceLowToHigh() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public List<String> getProductPrices() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public ShoppingCartScreenBase clickShoppingCartBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public void addProductsToCart(int productCount) {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }

    @Override
    public MenuScreenBase clickMenuBtn() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_ANDROID);
    }
}

package com.qaprosoft.carinademo.mobile;

import com.google.common.collect.Comparators;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.qaprosoft.carinademo.util.ValueGeneratorService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsTest extends SauceAppTest {

    @Test
    public void sortProductPricesFromLowToHighTest() {
        HomeScreenBase homePage = authService.loginBaseUser();
        homePage.clickFilterBtn();
        homePage.clickPriceLowToHigh();
        List<Double> prices = homePage.getProductPrices().stream()
                .map(product -> Double.parseDouble(product.replace("$", "")))
                .collect(Collectors.toList());
        Assert.assertTrue(Comparators.isInOrder(prices, Comparator.naturalOrder()), "Products are not sorted by Price(low to high).");
    }

    @Test
    public void deleteProductFromCartUsingSwipeTest() {
        int maxProductCount = 6;
        int productCount = ValueGeneratorService.generateProductCount(maxProductCount);
        HomeScreenBase homeAbstractPage = authService.loginBaseUser();
        homeAbstractPage.addProductsToCart(productCount);
        ShoppingCartScreenBase shoppingCart = homeAbstractPage.clickShoppingCartBtn();
        int productsInCartBeforeDelete = shoppingCart.countProductsInCart();
        shoppingCart.deleteProductsFromCartBySwipe();
        int productsInCartAfterDelete = shoppingCart.countProductsInCart();
        Assert.assertEquals(productsInCartBeforeDelete, productCount, "Products are not added to the cart");
        Assert.assertEquals(productsInCartAfterDelete, 0, "Failed to delete products from cart.");
    }

    @Test
    public void checkIfProductPriceIsOfRightFormatTest() {
        String priceRegExp = "^\\$\\d\\.\\d{2}|\\$\\d{2}\\.\\d{2}$";
        HomeScreenBase homeScreen = authService.loginBaseUser();
        List<String> prices = homeScreen.getProductPrices();
        prices.forEach(price -> Assert.assertTrue(price.matches(priceRegExp), "Wrong price format. "));
    }
}

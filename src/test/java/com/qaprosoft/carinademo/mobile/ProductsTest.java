package com.qaprosoft.carinademo.mobile;

import com.google.common.collect.Comparators;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.ShoppingCartScreenBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsTest extends SauceAppTest {

    @Test
    public void sortProductPricesFromLowToHighTest() {
        HomeScreenBase homePage = authService.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        homePage.clickFilterBtn();
        homePage.clickPriceLowToHigh();
        List<Double> prices = homePage.getProductPrices().stream()
                .map(product -> Double.parseDouble(product.replace("$", "")))
                .collect(Collectors.toList());
        Assert.assertTrue(Comparators.isInOrder(prices, Comparator.naturalOrder()), "Products are not sorted by Price(low to high).");
    }

    @Test
    public void deleteProductFromCartUsingSwipeTest() {
        int[] productCounts = {1, 2, 3};
        HomeScreenBase homeAbstractPage = authService.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        addToCartService.addProductsToCart(productCounts);
        ShoppingCartScreenBase shoppingCart = homeAbstractPage.clickShoppingCartBtn();
        int productInCartBeforeDelete = countService.countProductsInShoppingCart();
        shoppingCart.deleteProductsFromCartBySwipe();
        int productsInCartAfterDelete = countService.countProductsInShoppingCart();
        Assert.assertTrue(productInCartBeforeDelete == productCounts.length && productsInCartAfterDelete == 0,
                "Failed to delete products from cart.");
    }

    @Test
    public void checkIfProductPriceIsOfRightFormatTest() {
        String priceRegExp = "^\\$\\d\\.\\d{2}|\\$\\d{2}\\.\\d{2}$";
        HomeScreenBase homeScreen = authService.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        List<String> prices = homeScreen.getProductPrices();
        prices.forEach(price -> Assert.assertTrue(price.matches(priceRegExp), "Wrong price format. "));
    }
}

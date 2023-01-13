package com.qaprosoft.carinademo.mobile;

import com.google.common.collect.Comparators;
import com.qaprosoft.carinademo.mobile.common.HomePageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsTest extends SauceAppTest {

    @Test
    public void sortProductPricesFromLowToHighTest() {
        HomePageBase homePage = authService.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
        homePage.clickFilterBtn();
        homePage.clickPriceLowToHigh();
        List<String> productPrices = homePage.getProductPrices();
        List<Double> prices = productPrices.stream()
                .map(product -> Double.parseDouble(product.replace("$", "")))
                .collect(Collectors.toList());
        Assert.assertTrue(Comparators.isInOrder(prices, Comparator.naturalOrder()), "Products are not sorted by Price(low to high).");
    }
}

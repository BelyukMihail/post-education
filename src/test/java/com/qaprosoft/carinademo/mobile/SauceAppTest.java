package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.util.AddProductsToCartMobileService;
import com.qaprosoft.carinademo.util.AuthMobileService;
import com.qaprosoft.carinademo.util.CountMobileService;
import com.qaprosoft.carinademo.util.ValueGeneratorService;

public class SauceAppTest implements IAbstractTest {

    protected AuthMobileService authService = new AuthMobileService();
    protected CountMobileService countService = new CountMobileService();
    protected AddProductsToCartMobileService addToCartService = new AddProductsToCartMobileService();
    protected int cartXcoordinate = 340;
    protected int cartYcoordinate = 70;

}

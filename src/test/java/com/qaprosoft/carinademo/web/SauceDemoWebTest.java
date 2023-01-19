package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.util.AddProductsToCartWebService;
import com.qaprosoft.carinademo.util.AuthWebService;

public class SauceDemoWebTest implements IAbstractTest {

    protected AuthWebService authService = new AuthWebService();
    protected AddProductsToCartWebService addProductsToCartService = new AddProductsToCartWebService();
}

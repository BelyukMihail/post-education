package com.qaprosoft.carinademo.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carinademo.web.util.AddProductsToCartService;
import com.qaprosoft.carinademo.web.util.AuthService;

public class SauceDemoWebTest implements IAbstractTest {

    protected AuthService authService = new AuthService();
    protected AddProductsToCartService addProductsToCartService = new AddProductsToCartService();
}

package com.qaprosoft.carinademo.util;

import org.apache.commons.lang3.RandomStringUtils;

public class ValueGeneratorService {

    public static String generateNumericString(int symbolCount) {
        return RandomStringUtils.randomNumeric(symbolCount);
    }

    public static String generateAlphabeticString(int symbolCount) {
        return RandomStringUtils.randomAlphabetic(symbolCount);
    }

    public static int generateProductCount(int maxCount){
        return (int)(Math.random()*maxCount)+1;
    }
}

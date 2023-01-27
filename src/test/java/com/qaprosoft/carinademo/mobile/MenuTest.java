package com.qaprosoft.carinademo.mobile;

import com.qaprosoft.carinademo.mobile.common.DrawingScreenBase;
import com.qaprosoft.carinademo.mobile.common.HomeScreenBase;
import com.qaprosoft.carinademo.mobile.common.MenuScreenBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends SauceAppTest {

    @Test
    public void checkIfPictureCanBeDrawnAndErasedTest() {
        HomeScreenBase homeScreen = authService.loginBaseUser();
        MenuScreenBase menuScreen = homeScreen.clickMenuBtn();
        DrawingScreenBase drawingScreen = menuScreen.clickDrawingLink();
        Assert.assertTrue(drawingScreen.isEmptyPadPresent(), "Drawing area is not empty.");
        drawingScreen.drawPicture();
        Assert.assertTrue(drawingScreen.isDrawingPresent(), "There is no drawing found.");
        drawingScreen.clickClearBtn();
        Assert.assertTrue(drawingScreen.isEmptyPadPresent(), "Drawing area is not cleared");
    }
}

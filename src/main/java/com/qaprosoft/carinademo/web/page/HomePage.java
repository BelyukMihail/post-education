package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carinademo.web.uiobject.Item;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='inventory_list']//div[@class='inventory_item']")
    private List<Item> items;

    public HomePage(WebDriver driver) {
        super(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authenticate(R.TESTDATA.get("user_name_good"), R.TESTDATA.get("password"));
    }

    public List<Item> getItems() {
        return items;
    }
}

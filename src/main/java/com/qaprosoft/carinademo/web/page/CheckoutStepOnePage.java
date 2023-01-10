package com.qaprosoft.carinademo.web.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static com.qaprosoft.carinademo.web.page.Attribute.VALUE;

public class CheckoutStepOnePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='first-name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//*[@id='last-name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//*[@id='postal-code']")
    private ExtendedWebElement postalCodeField;

    @FindBy(xpath = "//*[@id='continue']")
    private ExtendedWebElement continueBtn;

    @FindBy(xpath = "//*[contains(text(),'Your Information')]")
    private ExtendedWebElement pageTitle;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(pageTitle);
    }

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.type(postalCode);
    }

    public String getEnteredFirstName() {
        return firstNameField.getAttribute(VALUE);
    }

    public String getEnteredLastName() {
        return lastNameField.getAttribute(VALUE);
    }

    public String getEnteredPostalCode() {
        return postalCodeField.getAttribute(VALUE);
    }

    public CheckoutStepTwoPage clickContinueBtn() {
        continueBtn.click();
        return new CheckoutStepTwoPage(getDriver());
    }
}

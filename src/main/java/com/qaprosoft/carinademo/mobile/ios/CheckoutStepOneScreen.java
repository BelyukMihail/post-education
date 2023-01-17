package com.qaprosoft.carinademo.mobile.ios;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carinademo.mobile.common.CheckoutStepOneScreenBase;
import com.qaprosoft.carinademo.mobile.common.CheckoutStepTwoScreenBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutStepOneScreenBase.class)
public class CheckoutStepOneScreen extends CheckoutStepOneScreenBase {

    private static final String THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS = "This method is not implemented on iOS";

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-First Name'`]")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Last Name'`]")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeTextField[`name == 'test-Zip/Postal Code'`]")
    private ExtendedWebElement postalCodeField;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == 'test-CONTINUE'`]")
    private ExtendedWebElement continueBtn;

    public CheckoutStepOneScreen(WebDriver driver) {
        super(driver);
    }

    @Override
    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    @Override
    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    @Override
    public void enterPostalCode(String postalCode) {
        postalCodeField.type(postalCode);
    }

    @Override
    public CheckoutStepTwoScreenBase clickContinueBtn() {
        continueBtn.click();
        return initPage(getDriver(), CheckoutStepTwoScreenBase.class);
    }

    @Override
    public String getFirstNameInput() {
        return firstNameField.getText();
    }

    @Override
    public String getLastNameInput() {
        return lastNameField.getText();
    }

    @Override
    public String getPostalCodeInput() {
        return postalCodeField.getText();
    }

    @Override
    public boolean isOpened() {
        throw new UnsupportedOperationException(THIS_METHOD_IS_NOT_IMPLEMENTED_ON_IOS);
    }
}

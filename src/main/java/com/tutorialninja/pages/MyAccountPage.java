package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Jay Vaghani
 */
public class MyAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(MyAccountPage.class);

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueBtn;

    public String getMyAccountText() {
        log.info("Getting my account text: " + myAccountText.toString());
        return getTextFromElement(myAccountText);
    }

    public String getAccountLogoutText() {
        log.info("Getting Account Logout text: " + accountCreatedText.toString());
        return getTextFromElement(accountLogoutText);
    }

    public String getYourAccountHasBeenCreatedText() {
        log.info("Getting Your account has been created text: " + accountCreatedText.toString());
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        log.info("Clicking on continue button on My account page: " + continueBtn.toString());
    }
}
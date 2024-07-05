package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class AccountRegisterPage extends Utility {

    private static final Logger log = LogManager.getLogger(AccountRegisterPage.class);

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstNameField;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailField;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirmField;
    @CacheLookup
    @FindBy(xpath = "//fieldset[3]//input")
    List<WebElement> subscribeRadios;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicyCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueBtn;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getRegisterAccountText() {
        log.info("Getting register account text: " + registerAccountText.toString());
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String fName) {
        sendTextToElement(firstNameField, fName);
        log.info("Enter firstName : " + fName + " to firstName field " + firstNameField.toString());
    }

    public void enterLastName(String lName) {
        sendTextToElement(lastNameField, lName);
        log.info("Enter lastName : " + lName + " to lastName field " + lastNameField.toString());
    }

    public void enterEmail(String email) {
        sendTextToElement(emailField, email);
        log.info("Enter email : " + email + " to email field " + emailField.toString());
    }

    public void enterTelephone(String telephone) {
        sendTextToElement(telephoneField, telephone);
        log.info("Enter telephone : " + telephone + " to telephone field " + telephone.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Enter password : " + password + " to password field " + password.toString());
    }

    public void enterConfirmPassword(String cPassword) {
        sendTextToElement(passwordConfirmField, cPassword);
        log.info("Enter confirm password : " + cPassword + " to confirm password field " + cPassword.toString());
    }

    public void selectSubscription(String option) {
        for (WebElement e : subscribeRadios) {
            if (e.getText().equals(option)) {
                e.click();
                log.info("Selecting subscription option to " + option);
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckBox() {
        clickOnElement(privacyPolicyCheckBox);
        log.info("Clicking on privacy policy check box");
    }

    public void clickOnContinueButton() {
        clickOnElement(continueBtn);
        log.info("Clicking on continue button on account register page");
    }
}

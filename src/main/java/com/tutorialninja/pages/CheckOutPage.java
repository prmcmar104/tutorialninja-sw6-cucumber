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
public class CheckOutPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckOutPage.class);

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "(//h2[normalize-space()='New Customer'])[1]")
    WebElement checkNewCustomerText;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestCheckoutButton;

    @CacheLookup
    @FindBy(css = "#button-account")
    WebElement continueButtonAccount;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement addressField;

    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement cityName;

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement zipCode;

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;

    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement zoneName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonGuest;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement addCommentIn;

    @CacheLookup
    @FindBy(css = "input[value='1'][name='agree']")
    WebElement termsAndConditions;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonForPayment;

    @CacheLookup
    @FindBy(xpath = "//div[@class ='alert alert-danger alert-dismissible']")
    WebElement checkWarningForPayment;


    public String getCheckOutText() {
        String checkout = getTextFromElement(checkOutText);
        log.info("Getting checkout text: " + checkOutText.toString());
        return checkout;
    }

    public String getNewCustomerText() {
        String newCustomer = getTextFromElement(checkNewCustomerText);
        log.info("Getting new customer text: " + checkNewCustomerText.toString());
        return newCustomer;
    }

    public void clickOnGuestCheckOutRadioButton() {
        clickOnElement(guestCheckoutButton);
        log.info("Clicking on guest checkout radio button on checkout page: " + guestCheckoutButton.toString());
    }

    public void clickOnContinueButton() {
        clickOnElement(continueButtonAccount);
        log.info("Clicking on continue button on checkout page: " + continueButtonAccount.toString());
    }

    public void fillYourPersonalDetails(String firstName, String lastName, String email, String telephone,
                                      String address1, String city, String postcode, String country, String region) {
        sendTextToElement(this.firstName, firstName);
        sendTextToElement(this.lastName, lastName);
        sendTextToElement(emailAddress, email);
        sendTextToElement(this.telephone, telephone);
        sendTextToElement(addressField, address1);
        sendTextToElement(cityName, city);
        sendTextToElement(zipCode, postcode);
        selectByVisibleTextFromDropDown(countryName, country);
        selectByVisibleTextFromDropDown(zoneName, region);
        log.info("Filled all personal information on checkout page");
    }

    public void clickOnContinueButtonForGuest() {
        clickOnElement(continueButtonGuest);
        log.info("Clicking on guest continue button on checkout page: " + continueButtonGuest.toString());

    }

    public void addCommentsAboutYourOrderIntoTheTextArea(String comment) {
        sendTextToElement(addCommentIn, comment);
        log.info("Enter comment : " + comment + " in comment area " + addCommentIn.toString());
    }

    public void clickOnCheckBoxForTermsAndConditions() {
        clickOnElement(termsAndConditions);
        log.info("Clicking on terms and condition on checkout page: " + termsAndConditions.toString());
    }

    public void clickOnContinueButtonForPaymentMethod() {
        clickOnElement(continueButtonForPayment);
        log.info("Clicking on payment continue button on checkout page: " + continueButtonForPayment.toString());
    }

    public String getWarningMessageForPaymentMethod() {
       String warningMessage = getTextFromElement(checkWarningForPayment);
        log.info("Getting warning message for payment method: " + checkWarningForPayment.toString());
        return warningMessage;
    }
}

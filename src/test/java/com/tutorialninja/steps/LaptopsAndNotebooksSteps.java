package com.tutorialninja.steps;

import com.tutorialninja.pages.CheckOutPage;
import com.tutorialninja.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Created by Jay Vaghani
 */
public class LaptopsAndNotebooksSteps {

    @And("I should navigate to laptop and notebook page")
    public void iShouldNavigateToLaptopAndNotebookPage() {
    }

    @And("I click on update tab")
    public void iClickOnUpdateTab() {
        new ShoppingCartPage().clickOnQtyUpdateButton();
    }

    @And("I click on check out button")
    public void iClickOnCheckOutButton() {
        new ShoppingCartPage().clickOnCheckOutButton();
    }

    @And("I click on guest checkout button")
    public void iClickOnGuestCheckoutButton() {
        new CheckOutPage().clickOnGuestCheckOutRadioButton();
    }

    @And("I fill my personal details with firstName {string} lastName {string} email {string} telephone {string} address {string} city {string} postcode {string} country {string} and region {string}")
    public void iFillMyPersonalDetailsWithFirstNameLastNameEmailTelephoneAddressCityPostcodeCountryAndRegion(String fName, String lName, String email, String telephone, String address1, String city, String postcode, String country, String region) {
        new CheckOutPage().fillYourPersonalDetails(fName, lName, email, telephone, address1, city, postcode, country, region);
    }

    @And("I click on continue button for guest")
    public void iClickOnContinueButtonForGuest() {
        new CheckOutPage().clickOnContinueButtonForGuest();
    }

    @And("I add comment {string} in text area")
    public void iAddCommentInTextArea(String comment) {
        new CheckOutPage().addCommentsAboutYourOrderIntoTheTextArea(comment);
    }

    @And("I check the terms and conditions")
    public void iCheckTheTermsAndConditions() {
        new CheckOutPage().clickOnCheckBoxForTermsAndConditions();
    }

    @And("I click on continue button for payment method")
    public void iClickOnContinueButtonForPaymentMethod() {
        new CheckOutPage().clickOnContinueButtonForPaymentMethod();
    }

    @Then("I get a message {string}")
    public void iGetAMessage(String message) {
        Assert.assertTrue(new CheckOutPage().getWarningMessageForPaymentMethod().contains(message), "Warning message not display");
    }

    @When("I enter qty {string} on shopping cart page")
    public void iEnterQtyOnShoppingCartPage(String qty) {
        new ShoppingCartPage().changeQuantity(qty);
    }

    @Then("I see the message {string} on shopping cart page")
    public void iSeeTheMessageOnShoppingCartPage(String message) {
        Assert.assertTrue(new ShoppingCartPage().getSuccessModifiedMessage().contains(message), "Qty not updated");
    }

    @Then("I see the text {string} on checkout page")
    public void iSeeTheTextOnCheckoutPage(String text) {
        Assert.assertEquals(new CheckOutPage().getCheckOutText(), text, text + " text is not displayed");
    }

    @And("I click on continue button on checkout page")
    public void iClickOnContinueButtonOnCheckoutPage() {
        new CheckOutPage().clickOnContinueButton();
    }
}

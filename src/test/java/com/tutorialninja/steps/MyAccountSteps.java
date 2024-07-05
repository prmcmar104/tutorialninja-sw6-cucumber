package com.tutorialninja.steps;

import com.tutorialninja.pages.AccountLoginPage;
import com.tutorialninja.pages.AccountRegisterPage;
import com.tutorialninja.pages.HomePage;
import com.tutorialninja.pages.MyAccountPage;
import com.tutorialninja.utility.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Created by Jay Vaghani
 */
public class MyAccountSteps {

    static String email;

    @And("I select {string} option from my account options")
    public void iSelectOptionFromMyAccountOptions(String option) {
        new HomePage().selectMyAccountOptions(option);
    }

    @Then("I get a register text {string}")
    public void iGetARegisterText(String text) {
    }

    @Then("I get a login page text {string}")
    public void iGetALoginPageText(String text) {
    }

    @And("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        new AccountRegisterPage().enterFirstName(firstName);
    }

    @And("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        new AccountRegisterPage().enterLastName(lastName);
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        this.email = Utility.getRandomString(3) + email;
        new AccountRegisterPage().enterEmail(this.email);
    }

    @And("I enter telephone {string}")
    public void iEnterTelephone(String telephone) {
        new AccountRegisterPage().enterTelephone(telephone);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new AccountRegisterPage().enterPassword(password);
    }

    @And("I enter confirm password {string}")
    public void iEnterConfirmPassword(String cPassword) {
        new AccountRegisterPage().enterConfirmPassword(cPassword);
    }

    @And("I select {string} radio button for subscription")
    public void iSelectRadioButtonForSubscription(String radio) {
        new AccountRegisterPage().selectSubscription(radio);
    }

    @And("I click on privacy policy check box")
    public void iClickOnPrivacyPolicyCheckBox() {
        new  AccountRegisterPage().clickOnPrivacyPolicyCheckBox();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        new AccountRegisterPage().clickOnContinueButton();
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String message) {
        Assert.assertEquals(new MyAccountPage().getYourAccountHasBeenCreatedText(), message, "Register not successful");

    }

    @Then("I should see the text {string}")
    public void iShouldSeeTheText(String text) {
        Assert.assertEquals(new MyAccountPage().getAccountLogoutText(), text, "Not logout successful");
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new AccountLoginPage().clickOnLoginButton();
    }

    @Then("I can see the text {string}")
    public void iCanSeeTheText(String text) {
        if (text.equalsIgnoreCase("My Account")){
            Assert.assertEquals(new MyAccountPage().getMyAccountText(), text, text + " text not displayed");
        } else if (text.equalsIgnoreCase("Account Logout")){
            Assert.assertEquals(new MyAccountPage().getAccountLogoutText(), text, text + " text not displayed");
        }

    }

    @When("I click on continue button on my account")
    public void iClickOnContinueButtonOnMyAccount() {
       new MyAccountPage().clickOnContinueButton();
    }

    @And("I enter email {string} on login page")
    public void iEnterEmailOnLoginPage(String email) {
        new AccountLoginPage().enterEmailAddress(this.email);

    }

    @And("I enter password {string} on login page")
    public void iEnterPasswordOnLoginPage(String password) {
        new AccountLoginPage().enterPassword(password);
    }
}
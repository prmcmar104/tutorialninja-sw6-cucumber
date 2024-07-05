package com.tutorialninja.steps;

import com.tutorialninja.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * Created by Jay Vaghani
 */
public class BackgroundSteps {

    @Given("I am on home page")
    public void iAmOnHomePage() {
    }

    @When("I click on my account link")
    public void iClickOnMyAccountLink() {
        new HomePage().clickOnMyQAccountTab();
    }
}

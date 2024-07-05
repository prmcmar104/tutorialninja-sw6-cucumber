package com.tutorialninja.steps;

import com.tutorialninja.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

/**
 * Created by Jay Vaghani
 */
public class TopMenuSteps {

    @When("I mouse hover on {string} tab and click")
    public void iMouseHoverOnTabAndClick(String tab) {
        HomePage homePage = new HomePage();
        if (tab.contains("Desktops")) {
            homePage.mouseHoverOnDesktopsLinkAndClick();
        } else if (tab.contains("Laptops & Notebooks")) {
            homePage.mouseHoverOnLaptopsAndNotebooksLinkAndClick();
        } else if (tab.contains("Components")) {
            homePage.mouseHoverOnComponentLinkAndClick();
        }
    }

    @And("I select {string} option")
    public void iSelectOption(String option) {
        new HomePage().selectMenu(option);
    }

    @Then("I should navigate to {string} page successfully")
    public void iShouldNavigateToPageSuccessfully(String menu) {
        HomePage homePage = new HomePage();
        if (menu.contains("Desktops")) {
            Assert.assertEquals(new DesktopPage().getDesktopsText(), menu, "Not Navigate to " + menu + " page");
        } else if (menu.contains("Laptops & Notebooks")) {
            Assert.assertEquals(new LaptopsAndNotebooksPage().getLaptopsAndNotebooksText(), menu, "Not Navigate to " + menu + " page");
        } else if (menu.contains("Components")) {
            Assert.assertEquals(new ComponentsPage().getComponentsText(), menu, "Not Navigate to " + menu + " page");
        } else if (menu.contains("Register")) {
            Assert.assertEquals(new AccountRegisterPage().getRegisterAccountText(), menu, "Not Navigate to " + menu + " page");
        } else if (menu.contains("Login")) {
            Assert.assertEquals(new AccountLoginPage().getReturningCustomerText(), menu, "Not Navigate to " + menu + " page");
        }
    }

    @And("I see the text {string}")
    public void iSeeTheText(String text) {
        if (text.contains("Shopping Cart")) {
            Assert.assertEquals(new ShoppingCartPage().getShoppingCartText(), text,  text + " text not displayed");
        } else if (text.contains("Laptops & Notebooks")) {
            Assert.assertEquals(new LaptopsAndNotebooksPage().getLaptopsAndNotebooksText(), text, "Not Navigate to " + text + " page");
        } else if (text.contains("Components")) {
            Assert.assertEquals(new ComponentsPage().getComponentsText(), text, "Not Navigate to " + text + " page");
        } else if (text.contains("Register")) {
            Assert.assertEquals(new AccountRegisterPage().getRegisterAccountText(), text, "Not Navigate to " + text + " page");
        } else if (text.contains("Login")) {
            Assert.assertEquals(new AccountLoginPage().getReturningCustomerText(), text, "Not Navigate to " + text + " page");
        }
    }
}

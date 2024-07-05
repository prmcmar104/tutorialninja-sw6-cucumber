package com.tutorialninja.steps;

import com.tutorialninja.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;

/**
 * Created by Jay Vaghani
 */
public class DesktopSteps {

    static ArrayList<String> originalList;
    static ArrayList<String> afterSortByList;
    static ArrayList<Double> originalPriceList;
    static ArrayList<Double> afterSortByPriceList;

    @And("I select filter {string}")
    public void iSelectFilter(String filter) {
        new DesktopPage().selectSortByFilter(filter);
        if (filter.contains("Name")){
            afterSortByList = new DesktopPage().getProductsNameList();
        } else if (filter.contains("High") || filter.contains("Low")){
            afterSortByPriceList = new LaptopsAndNotebooksPage().getProductsPriceList();
        }
    }

    @Then("I should see the products arrange in {string} order")
    public void iShouldSeeTheProductsArrangeInOrder(String order) {
        if (order.equalsIgnoreCase("ascending") || order.equalsIgnoreCase("descending")){
            Assert.assertTrue(new DesktopPage().doesProductArrangedInOrder(order, originalList, afterSortByList), "Product doesn't arrange in " + order);
        } else if (order.equalsIgnoreCase("High to Low") || order.equalsIgnoreCase("Low to High")){
            Assert.assertTrue(new DesktopPage().doesProductPriceArrangedInOrder(order, originalPriceList, afterSortByPriceList), "Product price doesn't arrange in " + order);
        }
    }

    @And("I collect the original {string} list by order")
    public void iCollectTheOriginalProductListByOrder(String option) {
        if (option.equalsIgnoreCase("product")){
            originalList = new DesktopPage().getProductsNameList();
        } else if (option.equalsIgnoreCase("price")){
            originalPriceList = new LaptopsAndNotebooksPage().getProductsPriceList();
        }
    }

    @And("I select currency {string}")
    public void iSelectCurrency(String option) {
        new HomePage().selectCurrency(option);
    }

    @And("I click on the product name {string}")
    public void iClickOnTheProductName(String product) {
        new DesktopPage().selectProductByName(product);
    }

    @When("I enter qty {string}")
    public void iEnterQty(String qty) {
        new ProductPage().enterQuantity(qty);
    }

    @And("I click on AddToCart button")
    public void iClickOnAddToCartButton() {
        new ProductPage().clickOnAddToCartButton();
    }

    @Then("I see the message Success: You have added {string} to your shopping cart!")
    public void iSeeTheMessageYouHaveAddedToYourShoppingCart(String product) {
        String expectedMessage = "Success: You have added " + product + " to your shopping cart!\n×";
        Assert.assertEquals(new ProductPage().getProductAddedSuccessMessage(), expectedMessage, "Product doesn't added to cart");

    }

    @When("I click on shopping cart link display into the success message")
    public void iClickOnShoppingCartLinkDisplayIntoTheSuccessMessage() {
        new ProductPage().clickOnShoppingCartLinkIntoMessage();
    }

    @And("I see the product name {string}")
    public void iSeeTheProductName(String productName) {
        Assert.assertEquals(new ShoppingCartPage().getProductName(), productName, "Product name not matched");
    }

    @Then("I see the model number {string}")
    public void iSeeTheModelNumber(String modelNumber) {
        Assert.assertEquals(new ShoppingCartPage().getModel(), modelNumber, "Model Number not matched");
    }

    @Then("I see the total price {string}")
    public void iSeeTheTotalPrice(String totalPrice) {
        Assert.assertEquals(new ShoppingCartPage().getTotal(), totalPrice, "Total Price not matched");
    }

    @Then("I see the product name {string} on product page")
    public void iSeeTheProductNameOnProductPage(String product) {
        Assert.assertEquals(new ProductPage().getProductText(), product, "Not navigate to " + product + " product page");
    }

    @Then("I see the text {string} on Shopping cart page")
    public void iSeeTheTextOnShoppingCartPage(String text) {
        Assert.assertTrue(new ShoppingCartPage().getShoppingCartText().contains(text), "Not navigate to " + text + " product page");
    }
}

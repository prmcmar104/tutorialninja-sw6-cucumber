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
public class ShoppingCartPage extends Utility {

    private static final Logger log = LogManager.getLogger(ShoppingCartPage.class);

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement model;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement total;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;
    @CacheLookup
    @FindBy(xpath = "(//div[@class='alert alert-success alert-dismissible'])[1]")
    WebElement successModifiedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement checkOutBtn;

    public String getShoppingCartText() {
        log.info("Getting shopping cart text: " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        log.info("Getting product name: " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getDeliveryDate() {
        log.info("Getting delivery date: " + deliveryDate.toString());
        return getTextFromElement(deliveryDate);
    }

    public String getModel() {
        log.info("Getting model: " + model.toString());
        return getTextFromElement(model);
    }

    public String getTotal() {
        log.info("Getting total price: " + total.toString());
        return getTextFromElement(total);
    }

    public void changeQuantity(String qty) {
        clearTextOnElement(qtyField);
        sendTextToElement(qtyField, qty);
        log.info("Enter quantity on shopping cart page: " + qty.toString());
    }

    public void clickOnQtyUpdateButton() {
        clickOnElement(qtyUpdateBtn);
        log.info("Clicking on qty update button: " + qtyUpdateBtn.toString());
    }

    public String getSuccessModifiedMessage() {
        log.info("Getting success modified message: " + successModifiedMessage.toString());
        return getTextFromElement(successModifiedMessage);
    }

    public void clickOnCheckOutButton(){
        clickOnElement(checkOutBtn);
        log.info("Clicking on checkout button: " + checkOutBtn.toString());
    }
}
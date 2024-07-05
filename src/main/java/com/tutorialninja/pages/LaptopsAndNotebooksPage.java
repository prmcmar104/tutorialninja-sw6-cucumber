package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class LaptopsAndNotebooksPage extends Utility {

    private static final Logger log = LogManager.getLogger(LaptopsAndNotebooksPage.class);

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;
    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    public String getLaptopsAndNotebooksText() {
        log.info("Getting Laptops and Notebooks text: " + laptopsAndNotebooksText.toString());
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList<Double> getProductsPriceList() {
        ArrayList<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : productsPrices) {
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        log.info("Getting original price list: " + originalProductsPrice);
        return originalProductsPrice;
    }
}
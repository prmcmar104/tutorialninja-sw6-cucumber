package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class DesktopPage extends Utility {

    private static final Logger log = LogManager.getLogger(DesktopPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;
    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;

    public String getDesktopsText() {
        return getTextFromElement(desktopsText);
    }

    public ArrayList<String> getProductsNameList() {
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : productsList) {
            originalProductsName.add(e.getText());
        }
        log.info("Getting original product name list: " + originalProductsName);
        return originalProductsName;
    }

    public void selectProductByName(String product) {
        for (WebElement e : productsList) {
            if (e.getText().equals(product)) {
                e.click();
                log.info("Selecting product " + product);
                break;
            }
        }
    }

    public boolean doesProductArrangedInOrder(String order, ArrayList<String> original, ArrayList<String> afterSortBy) {
        if (order.equalsIgnoreCase("ascending")) {
            log.info("Product arranged in ascending order");
            return original.equals(afterSortBy);
        } else if (order.equalsIgnoreCase("descending")) {
            Collections.reverse(original);
            log.info("Product arranged in descending order");
            return original.equals(afterSortBy);
        } else {
            log.info("Products are not arranged in order");
            return false;
        }
    }

    public boolean doesProductPriceArrangedInOrder(String order, ArrayList<Double> original, ArrayList<Double> afterSortBy) {
        if (order.equalsIgnoreCase("High to Low")) {
            Collections.sort(original, Collections.reverseOrder());
            log.info("Price arranged in High to Low order");
            return original.equals(afterSortBy);
        } else if (order.equalsIgnoreCase("Low to High")) {
            Collections.reverse(original);
            log.info("Price arranged in Low to High order");
            return original.equals(afterSortBy);
        } else {
            log.info("Prices are not arranged in order");
            return false;
        }
    }

    public void selectSortByFilter(String option) {
        selectByVisibleTextFromDropDown(sortBy, option);
        log.info("Selecting sort by filter " + option);
    }
}
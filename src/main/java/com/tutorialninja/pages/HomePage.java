package com.tutorialninja.pages;

import com.tutorialninja.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Jay Vaghani
 */
public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class);
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLinks;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;
    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;
    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;

    public void selectMenu(String menu) {
        try {
            for (WebElement element : topMenu) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                    log.info("Selecting menu " + menu);
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mouseHoverOnDesktopsLinkAndClick() {
        mouseHoverToElementAndClick(desktopLink);
        log.info("Mouse hovering on Desktop link and click " + desktopLink.toString());
    }

    public void mouseHoverOnLaptopsAndNotebooksLinkAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooksLink);
        log.info("Mouse hovering on Laptops And Notebooks link and click " + laptopsAndNotebooksLink.toString());
    }

    public void mouseHoverOnComponentLinkAndClick() {
        mouseHoverToElementAndClick(componentsLinks);
        log.info("Mouse hovering on Components link and click " + componentsLinks.toString());
    }

    public void selectCurrency(String currency) {
        waitUntilVisibilityOfElementLocated(currencyTab, 5).click();
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase(currency)) {
                e.click();
                log.info("Selecting currency: " + currency);
                break;
            }
        }
    }

    public void clickOnMyQAccountTab() {
        clickOnElement(myAccountTab);
        log.info("Clicking on My account Tab");
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = myAccountOptions;
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                    log.info("Selecting my account option: " + option);
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = myAccountOptions;
        }
    }
}
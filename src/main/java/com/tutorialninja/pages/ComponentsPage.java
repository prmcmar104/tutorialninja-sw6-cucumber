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
public class ComponentsPage extends Utility {

    private static final Logger log = LogManager.getLogger(ComponentsPage.class);
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsText;
    public String getComponentsText() {
        String text = getTextFromElement(componentsText);
        log.info("Getting " + text + " text : " + componentsText.toString());
        return text;
    }
}

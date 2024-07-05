package com.tutorialninja.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Created by Jay Vaghani
 */
@CucumberOptions(features = "src/test/resources/features",
        glue = "com/tutorialninja/steps",
        plugin = {"html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/rerun.txt"},
        tags = "@myAccountPage"
)
public class RunCuke extends AbstractTestNGCucumberTests {

}
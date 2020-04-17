package com.test.framework.selenium;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.test.framework.support.Property.BROWSER_NAME;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "json:target/cucumber.json",
        features = {"classpath:features"},
        glue = {"com.selenium.test.stepdefs", "com.selenium.framework.hook"},
        tags = {"not @ignore"})
public class RunSeleniumTest {

    private static final Logger LOG = Logger.getLogger(RunSeleniumTest.class);

    @BeforeClass
    public static void startSelenium() {
        LOG.info("### Starting Selenium " + BROWSER_NAME.toString().toUpperCase() + " ###");
    }

    @AfterClass
    public static void stopSelenium() {
        LOG.info("### Stopping Selenium ###");
    }
}
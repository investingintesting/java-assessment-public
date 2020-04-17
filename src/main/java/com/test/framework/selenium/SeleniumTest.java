package com.test.framework.selenium;

import com.test.framework.selenium.base.*;
import com.test.framework.selenium.driver.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.test.framework.support.Property.BASE_URL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SeleniumTest {
    public static SeleniumBase seleniumBase;

    public SeleniumTest(){
        StartTest();
    }


    //create selenium base if it is not null
    //create for chrome use the path based on os type
    public void StartTest(){
        if(seleniumBase==null) {
            String OS = System.getProperty("os.name", "generic").toLowerCase();
            String chromedriverpath = "";
            if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
                chromedriverpath = "chromedriver/mac";
            } else if (OS.indexOf("win") >= 0) {
                chromedriverpath = "chromedriver/windows/chromedriver.exe";
            } else if (OS.indexOf("nux") >= 0) {
                chromedriverpath = "chromedriver/linux";
            }
            System.setProperty("webdriver.chrome.driver", chromedriverpath);
            seleniumBase = new SeleniumBase(new ChromeDriver());
        }

    }

    //end test make selenium base null
    public static void EndTest(){
        seleniumBase.getDriver().quit();
        seleniumBase = null;
    }


    //Asserts regurlarly used in Selenium Tests

    public static void assertElementAndUrl(WebElement element, String url, int duration) {
        assertElementPresent(element, duration);
        assertEquals(BASE_URL + url, seleniumBase.getDriver().getCurrentUrl());
    }

    public static void assertElementNotPresent(WebElement element) {
        assertTrue(seleniumBase.elementNotPresent(element));
    }

    public static void assertElementNotPresent(WebElement element, int duration) {
        assertTrue(seleniumBase.elementNotPresent(element, duration));
    }

    public static void assertElementPresent(WebElement element, int duration) {
        assertTrue(seleniumBase.elementPresent(element, duration));
    }

    public static void assertElementPresent(WebElement element) {
        assertTrue(seleniumBase.elementPresent(element));
    }

    public static void assertElementsNotPresent(List<WebElement> elements, int duration) {
        assertTrue(seleniumBase.elementsNotPresent(elements, duration));
    }

    public static void assertElementsPresent(List<WebElement> elements, int duration) {
        assertTrue(seleniumBase.elementsPresent(elements, duration));
    }
}

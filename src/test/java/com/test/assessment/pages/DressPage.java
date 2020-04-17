package com.test.assessment.pages;

import com.test.framework.selenium.SeleniumTest;
import com.test.framework.selenium.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("cucumber-glue")
public class DressPage extends SeleniumBase {


    @FindBy(linkText = "Sign in")
    public static WebElement LOGIN_BUTTON;

    @FindBy(xpath = "//div//ul//li//a[@title='Add to cart']")
    public static WebElement ADDCART_BUTTON;

    @FindBy(id = "search_query_top")
    public static WebElement SEARCH_BAR;

    @FindBy(name = "submit_search")
    public static WebElement SEARCH_BUTTON;

    @FindBy(xpath = "//a[@class='product-name']")
    public static List<WebElement> DRESSES;


    public static String url = "http://automationpractice.com/index.php";


    public DressPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstDressToCart(){
        ADDCART_BUTTON.click();
    }

    public Boolean onDressPage(){
        return ADDCART_BUTTON.isDisplayed();
    }

    public Boolean searchForDress(String dressName) throws InterruptedException {
        SEARCH_BAR.clear();
        Thread.sleep(200);
        SEARCH_BAR.sendKeys(dressName);
        Thread.sleep(200);
        SEARCH_BUTTON.click();
        Thread.sleep(200);
        for(WebElement dress:DRESSES){
            if(dress.getText().equals(dressName))
                return true;
        }
        return false;
    }

    public Boolean searchForPartialDressName(String dressName) throws InterruptedException {
        SEARCH_BAR.clear();
        Thread.sleep(200);
        SEARCH_BAR.sendKeys(dressName);
        Thread.sleep(200);
        SEARCH_BUTTON.click();
        Thread.sleep(200);
        for(WebElement dress:DRESSES){
            if(dress.getText().contains(dressName))
                return true;
        }
        return false;
    }
}
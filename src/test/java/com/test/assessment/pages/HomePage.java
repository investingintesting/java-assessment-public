package com.test.assessment.pages;

import com.test.framework.selenium.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class HomePage extends SeleniumBase {


    @FindBy(linkText = "Sign in")
    public static WebElement LOGIN_BUTTON;

    public static String url = "http://automationpractice.com/index.php";


    public HomePage(WebDriver driver) {
        super(driver);
    }
}
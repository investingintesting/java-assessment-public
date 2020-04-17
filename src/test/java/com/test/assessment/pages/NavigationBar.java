package com.test.assessment.pages;

import com.test.framework.selenium.SeleniumTest;
import com.test.framework.selenium.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class NavigationBar extends SeleniumBase {


    @FindBy(linkText = "Sign out")
    public static WebElement LOGOUT_BUTTON;

    @FindBy(linkText = "Sign in")
    public static WebElement LOGIN_BUTTON;

    @FindBy(linkText = "Dresses")
    public static WebElement DRESS_BUTTON;


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public static void LogoutButtonExists(){
        SeleniumTest.assertElementPresent(LOGOUT_BUTTON, 10);
    }

    public void Logout(){
        try{
            LOGOUT_BUTTON.click();
        }catch(Exception e){
            LOGOUT_BUTTON.click();
        }

    }

    public Boolean LoggedIn(){
        return elementPresent(LOGIN_BUTTON, 10);
    }

    public void goToDressPage(){
        DRESS_BUTTON.click();
    }
}
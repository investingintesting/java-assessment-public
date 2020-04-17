package com.test.assessment.pages;

import com.test.framework.selenium.base.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class MiscPage extends SeleniumBase {

    @FindBy(linkText = "Gallery")
    public static WebElement GALLERY_BUTTON;

    public static String url = "http://the-internet.herokuapp.com/disappearing_elements";


    public MiscPage(WebDriver driver) {
        super(driver);
    }

    public void GoToGallery(){
        GALLERY_BUTTON.click();
    }

    public Boolean OnGallery(){
        return getDriver().getPageSource().contains("Not Found");
    }
}
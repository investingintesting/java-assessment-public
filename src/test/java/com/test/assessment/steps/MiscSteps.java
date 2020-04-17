package com.test.assessment.steps;

import com.test.assessment.pages.LoginPage;
import com.test.assessment.pages.MiscPage;
import com.test.framework.selenium.SeleniumTest;
import com.test.framework.selenium.base.SeleniumBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.test.assessment.pages.LoginPage.*;

/***
 * Steps for the login page
 */


public class MiscSteps {

    //@Autowired
    public MiscPage miscPage;
    public SeleniumTest seleniumTest;

    @Given("I am on the navigation misc page")
    public void i_visit_navigation_misc(){
        seleniumTest = new SeleniumTest();
        this.miscPage = new MiscPage(SeleniumTest.seleniumBase.getDriver());
        miscPage.gotoURL(miscPage.url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I go to the Gallery")
    public void i_visit_gallery(){
        miscPage.GoToGallery();
    }

    @Then("I should see Gallery")
    public void i_see_gallery(){
        Assert.assertTrue(miscPage.getDriver().findElement(By.tagName("h1")).getText().contains("Not Found"));
        SeleniumTest.EndTest();
    }

}

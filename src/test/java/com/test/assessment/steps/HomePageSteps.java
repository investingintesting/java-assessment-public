package com.test.assessment.steps;

import com.test.assessment.pages.HomePage;
import com.test.framework.selenium.SeleniumTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.nio.file.*;

/***
 * Steps for the login page
 */


public class HomePageSteps {

    //@Autowired
    public HomePage homePage;
    public SeleniumTest seleniumTest;

    @Given("I visit the homepage")
    public void i_visit_the_homepage() {
        seleniumTest = new SeleniumTest();
        this.homePage = new HomePage(SeleniumTest.seleniumBase.getDriver());
        this.homePage.gotoURL(homePage.url);
        seleniumTest.assertElementPresent(HomePage.LOGIN_BUTTON, 10);
        Assert.assertEquals("pagesource has changed", readFileAsString("HomePage.txt"), homePage.getDriver().getPageSource());
    }

    @Then("I am not logged in")
    public void i_am_not_logged_in(){
        Boolean loginButtonExists = SeleniumTest.seleniumBase.elementPresent(HomePage.LOGIN_BUTTON, 10);
        seleniumTest.EndTest();
    }

    public static String readFileAsString(String fileName)
    {
        try {
            String data = "";
            data = new String(Files.readAllBytes(Paths.get(fileName)));
            return data;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}

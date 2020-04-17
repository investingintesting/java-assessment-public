package com.test.assessment.steps;

import com.test.assessment.pages.HomePage;
import com.test.assessment.pages.NavigationBar;
import com.test.framework.selenium.SeleniumTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/***
 * Steps for the login page
 */


public class NavigationSteps {

    //@Autowired
    public NavigationBar navBar;


    @Then("the logout button should be visible")
    public void logout_button_is_visible(){
        navBar.LogoutButtonExists();
        SeleniumTest.EndTest();
    }

    @When("I press the logout button")
    public void click_logout(){
        navBar.Logout();
    }


    @Then("I should be logged out")
    public void logged_out(){
        Assert.assertTrue("User is logged out", navBar.LoggedIn());
        SeleniumTest.EndTest();
    }

}

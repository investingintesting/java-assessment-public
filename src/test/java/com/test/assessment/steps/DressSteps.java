package com.test.assessment.steps;

import com.test.assessment.pages.DressPage;
import com.test.assessment.pages.NavigationBar;
import com.test.framework.selenium.SeleniumTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/***
 * Steps for the login page
 */


public class DressSteps {

    //@Autowired
    public NavigationBar navBar;
    public DressPage dressPage;


    @When("I put FirstDress in the cart")
    public void add_first_dress(){
        navBar.goToDressPage();
        dressPage.addFirstDressToCart();
    }


    @Then("I am no longer on the dress page")
    public void not_on_dress_page(){
        Assert.assertTrue("User is no longer on the dress page", !dressPage.onDressPage());
        SeleniumTest.EndTest();
    }

}

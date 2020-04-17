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


public class ShoppingCartSteps {

    //@Autowired
    public NavigationBar navBar;
    public DressPage dressPage;


    @When("I see FirstDress in the cart")
    public void first_dress_in_cart(){
        Boolean firstDressAdded = dressPage.getDriver().getPageSource().contains("There is 1 item in your cart.");
        Assert.assertTrue(firstDressAdded);
    }

    @Then("I see two FirstDress in the cart")
    public void two_first_dress_in_cart(){
        Boolean firstDressAdded = dressPage.getDriver().getPageSource().contains("There are 2 items in your cart.");
        Assert.assertTrue(firstDressAdded);
        SeleniumTest.EndTest();
    }

}

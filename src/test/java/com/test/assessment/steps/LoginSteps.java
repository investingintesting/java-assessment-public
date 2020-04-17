package com.test.assessment.steps;

import com.test.assessment.pages.LoginPage;
import com.test.framework.selenium.SeleniumTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;

import static com.test.assessment.pages.LoginPage.*;
import static io.restassured.RestAssured.given;

/***
 * Steps for the login page
 */


public class LoginSteps {

    //@Autowired
    public LoginPage loginPage;
    public SeleniumTest seleniumTest;
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;



    @Given("I visit login")
    @Given("I am on the login page")
    @Given("I'm on login")
    @Given("I'm on the login page")
    public void given_i_visit_login() {
        seleniumTest = new SeleniumTest();
        this.loginPage = new LoginPage(SeleniumTest.seleniumBase.getDriver());
        this.loginPage.gotoURL("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        seleniumTest.assertElementPresent(LoginPage.EMAIL, 10);
    }

    @When("I'm on login page")
    public void i_visit_login() {
        seleniumTest = new SeleniumTest();
        this.loginPage = new LoginPage(SeleniumTest.seleniumBase.getDriver());
        this.loginPage.gotoURL("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        seleniumTest.assertElementPresent(LoginPage.EMAIL, 10);
    }

    @When("^I enter '(.*)' in the email field$")
    //@When("I enter investingintesting@gmail.com in the email field")
    public void i_enter_my_email(String email) {
        EMAIL.sendKeys(email);
    }

    @When("I enter the wrong password '(.*)' in the password field")
    @When("^I enter '(.*)' in the password field$")
    public void i_enter_my_supersecretpassword_into_the_password_field(String password) {
        PASSWORD.sendKeys(password);
    }

    @When("I press the login button")
    public void i_press_the_login_button() {
        LOGIN_BUTTON.click();
    }

    @Then("I should see the My Account page")
    public void i_should_see_the_My_Account_page() {
        String title = loginPage.getDriver().getTitle();
        Assert.assertEquals(title, "My account - My Store");
        seleniumTest.EndTest();
    }

    @Then("I should see an error")
    public void iShouldSeeAnError() {
        Boolean authenticationFailed = loginPage.getDriver().getPageSource().contains("Authentication failed");
        Assert.assertTrue(authenticationFailed);
        seleniumTest.EndTest();
    }

    @When("I have logged in")
    @Given("I am logged in")
    public void given_i_am_logged_in() {
        given_i_visit_login();
        i_enter_my_email("investingintesting@gmail.com");
        i_enter_my_supersecretpassword_into_the_password_field("p4ssw0rd");
        i_press_the_login_button();
        i_should_see_the_My_Account_page();

    }

    @When("I login as a valid user using the api")
    public void login_using_api(){
        RestAssured.baseURI  = "http://automationpractice.com/index.php?controller=authentication";

        response = given().
                        body("email=investingintesting%40gmail.com&passwd=p4ssw0rd&back=my-account&SubmitLogin=").
                        when().
                        post("");

    }

    @Then("I should be logged in")
    public void i_should_be_logged_in(){
        json = response.then().statusCode(200);
    }
}

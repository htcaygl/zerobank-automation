package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefs {

    @Given("the user in on the login page")
    public void the_user_in_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("the user enters the valid credentials")
    public void the_user_enters_the_valid_credentials() {

        String username= ConfigurationReader.get("username");
        String password= ConfigurationReader.get("password");

        LoginPage loginPage= new LoginPage();

        loginPage.login(username,password);

        loginPage.advancedBtn.click();
        loginPage.proceedLink.click();

    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {

        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary", actualTitle);
    }

    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        String actualTitle= Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary", actualTitle);
    }

    @When("the user enters wrong username or wrong password")
    public void the_user_enters_wrong_username_or_wrong_password() {

        String username= "wrong";
        String password= "wrong";

        LoginPage loginPage= new LoginPage();

        loginPage.login(username,password);

    }

    @Then("user should not be able to login")
    public void user_should_not_be_able_to_login() {

        String actualTitle= Driver.get().getTitle();
        Assert.assertNotEquals("Zero - Account Summary", actualTitle);

    }

    @Then("user should see {string} error message")
    public void user_should_see_error_message(String message) {

        String actualMsg= new LoginPage().loginErrorMsg.getText();

        Assert.assertEquals("Verify that Login error message should be displayed.",message,actualMsg);
    }

    @When("the user enters blank username and valid password")
    public void the_user_enters_blank_username_and_valid_password() {

        new LoginPage().login("",ConfigurationReader.get("password"));
    }

    @When("the user enters valid username and blank password")
    public void the_user_enters_valid_username_and_blank_password() {

        new LoginPage().login(ConfigurationReader.get("username"),"");

    }

    @Given("the user in logged in")
    public void the_user_in_logged_in() {

        the_user_in_on_the_login_page();
        the_user_enters_the_valid_credentials();

    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {

        LoginPage loginPage= new LoginPage();

        loginPage.login(username,password);


    }
}

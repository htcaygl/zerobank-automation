package com.zerobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public class PayBillsStepDefs {

    @When("user completes successfully Pay operation")
    public void user_completes_successfully_Pay_operation() {

        Faker faker = new Faker();
        new PayBillsPage().amountInput.sendKeys(""+faker.number().numberBetween(1,9999)+"");
        new PayBillsPage().dateInput.sendKeys(""+faker.date()+"");
        new PayBillsPage().payBtn.click();

    }

    @Then("user should see {string} message")
    public void user_should_see_message(String msg) {

        Assert.assertEquals(msg,new PayBillsPage().alertMsg.getText());
    }

    @When("user doesn't enter amount or date and click pay button")
    public void user_doesn_t_enter_amount_or_date_and_click_pay_button() {

        new PayBillsPage().payBtn.click();

    }

    @Then("user should see {string} warning message")
    public void user_should_see_warning_message(String msg) {

        //this is browser msg, not html msg. So we dont locate element
        String actualMsg= new PayBillsPage().amountInput.getAttribute("validationMessage");

        Assert.assertEquals(msg,actualMsg);
    }

}

package com.zerobank.stepdefinitions;

import com.github.javafaker.Faker;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Given("{string} tab")
    public void add_New_Payee_tab(String tab) {
        new PayBillsPage().getTab(tab).click();
        BrowserUtils.waitFor(2);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information( Map<String, String> info) {

        PayBillsPage payBillsPage=new PayBillsPage();

        payBillsPage.payeeInputs.get(0).sendKeys(info.get("Payee Name"));
        payBillsPage.payeeInputs.get(1).sendKeys(info.get("Payee Address"));
        payBillsPage.payeeInputs.get(2).sendKeys(info.get("Account"));
        payBillsPage.payeeInputs.get(3).sendKeys(info.get("Payee details"));

        payBillsPage.addBtn.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String msg) {

       Assert.assertEquals(msg, new PayBillsPage().newPayeeMsg.getText());
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> options) {

        List<String> actualOptions= BrowserUtils.getElementsText(new PayBillsPage().dropdownCurrencyOptions());


        Assert.assertEquals(options,actualOptions);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        new PayBillsPage().calculateCostBtn.click();
        new PayBillsPage().alert();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_selecting_entering_a_value() {
        new PayBillsPage().calculateCostBtn.click();
        new PayBillsPage().alert();
    }


    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        String alertMsg=new PayBillsPage().alert().getText();

        System.out.println("alertMsg = " + alertMsg);

        Assert.assertFalse(alertMsg.isEmpty());

    }

    @When("user tries to send alphabetical characters to date field")
    public void user_tries_to_send_alphabetical_characters_to_date_field() {

        new PayBillsPage().dateInput.sendKeys("some input");

    }

    @Then("user should not be able to sendkeys to date field")
    public void user_should_not_be_able_to_sendkeys_to() {


        Assert.assertFalse(new PayBillsPage().dateInput.getText().equals("some input"));
    }



}

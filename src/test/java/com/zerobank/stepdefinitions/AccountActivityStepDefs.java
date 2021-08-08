package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


import java.util.List;

public class AccountActivityStepDefs {

//    @When("user on {string} page")
//    public void user_on_Account_Activity_page(String page) {
//
//        new AccountSummaryPage().tab(page).click();
//
//    }

    @Then("dropdown default option should be {string}")
    public void dropdown_default_option_should_be(String dropdownDefault) {

        String actualDefaultOption =new AccountActivityPage().dropdownDefault().getText();
        Assert.assertEquals(dropdownDefault,actualDefaultOption);


    }

    @Then("dropdown should have following options")
    public void dropdown_should_have_following_options(List<String> options) {

        List<String> actualOptions= BrowserUtils.getElementsText(new AccountActivityPage().dropdownOptions());


        Assert.assertEquals(options,actualOptions);
        System.out.println("options = " + options);
        System.out.println("actualOptions = " + actualOptions);
    }

    @Then("Transaction table should have following column names")
    public void transaction_table_should_have_following_column_names(List<String> columns) {

        BrowserUtils.waitFor(3);
        List<String> actualColumns=BrowserUtils.getElementsText(new AccountActivityPage().tableColumns);

        Assert.assertEquals(columns,actualColumns);
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {

        new AccountSummaryPage().getLink(link).click();

    }





}

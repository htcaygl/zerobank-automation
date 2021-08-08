package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;

public class AccountSummaryStepDefs {


    @Then("the user should be able to see {string} title")
    public void the_user_should_be_able_to_see_title(String title) {

       Assert.assertEquals(title, Driver.get().getTitle());
    }

    @When("user on {string} page")
    public void user_on_page(String page) {

        new AccountSummaryPage().tab(page).click();

    }


    @Then("Account Summary page should have following account types")
    public void account_Summary_page_should_have_following_account_types(List<String> accountTypes) {

        List<String> actualAccountTypes= BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);

        Assert.assertEquals(accountTypes,actualAccountTypes);

    }

    @Then("{string} table must have following columns")
    public void table_must_have_following_columns(String accountType, List<String> columns) {


        List<String> actualColumns= BrowserUtils.getElementsText(new AccountSummaryPage().getColumns(accountType));

        Assert.assertEquals(columns,actualColumns);

        System.out.println("columns = " + columns);

        System.out.println("actualColumns = " + actualColumns);


    }




}

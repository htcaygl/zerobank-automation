package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import javafx.collections.transformation.SortedList;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.junit.Assert;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.LinkedList;
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


    @And("the user accesses the Find Transactions tab")
    public void theUserAccessesTheFindTransactionsTab() {

        new AccountActivityPage().findTransactions.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {

        new AccountActivityPage().dateFrom.clear();
        new AccountActivityPage().dateTo.clear();
        new AccountActivityPage().dateFrom.sendKeys(date1);
        new AccountActivityPage().dateTo.sendKeys(date2);

    }

    @When("clicks search")
    public void clicks_search() {
        new AccountActivityPage().findBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String date1, String date2) {


        List<String> expectedDates= new ArrayList<>();
        expectedDates.add(date1);
        expectedDates.add(date2);

        List<WebElement> actualDatesElement= new ArrayList<>();
        BrowserUtils.waitFor(3);

        actualDatesElement.add(new AccountActivityPage().dates.get(new AccountActivityPage().dates.size()-1));
        actualDatesElement.add(new AccountActivityPage().dates.get(0));

        List<String> actualDates= BrowserUtils.getElementsText(actualDatesElement);

        System.out.println("expectedDates = " + expectedDates);
        System.out.println("actualDates = " + actualDates);


        Assert.assertTrue(date1.compareTo(actualDates.get(actualDates.size()-1))<=0);


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {


        //compareTo() method compare two DATES,
        // if first date occurs after second date (it means sorted by most recent), it returns<0
        int value= (new AccountActivityPage().dates.get(new AccountActivityPage().dates.size() - 1)).getText().compareTo((new AccountActivityPage().dates.get(0)).getText());

        Assert.assertTrue(value<0);


    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {



        List<WebElement> actualDatesElement= new ArrayList<>();

        actualDatesElement.add(new AccountActivityPage().dates.get(new AccountActivityPage().dates.size()-1));
        actualDatesElement.add(new AccountActivityPage().dates.get(0));

        List<String> actualDates= BrowserUtils.getElementsText(actualDatesElement);

        System.out.println("date = " + date);
        System.out.println("actualDates = " + actualDates);


        Assert.assertFalse(actualDates.contains(date));

    }



}

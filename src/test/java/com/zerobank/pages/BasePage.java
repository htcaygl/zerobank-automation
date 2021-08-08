package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


//    @FindBy(css = "#account_summary_tab>a")
//    public WebElement accountSummaryTab;
//
//    @FindBy(css = "#account_activity_tab>a")
//    public WebElement accountActivityTab;
//
//    @FindBy(css = "#transfer_funds_tab>a")
//    public WebElement transferFundsTab;
//
//    @FindBy(css = "#pay_bills_tab>a")
//    public WebElement payBillsTab;
//
//    @FindBy(css = "#money_map_tab>a")
//    public WebElement myMoneyMapTab;
//
//    @FindBy(css = "#online_statements_tab>a")
//    public WebElement onlineStatementsTab;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    public String getTitle(){

        return Driver.get().getTitle();
    }

    public WebElement tab(String tab){

        String element="";

        switch (tab){

            case "Account Summary":
                element="account_summary";
                break;
            case "Account Activity":
                element="account_activity";
                break;
            case "Transfer Funds":
                element="transfer_funds";
                break;
            case "Pay Bills":
                element="pay_bills";
                break;
            case "My Money Map":
                element="money_map";
                break;
            case "Online Statements":
                element="online_statements";
        }

        return Driver.get().findElement(By.cssSelector("#"+element+"_tab>a"));
    }

}

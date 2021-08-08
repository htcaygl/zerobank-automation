package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {


    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;


    public WebElement getLink(String linkName){

        int i =0;

        switch (linkName) {
            case "Savings":
                i= 1;
                break;
            case "Brokerage":
                i=3;
                break;

            case "Checking":
                i=4;
                break;

            case "Credit Card":
                i=5;
                break;

            case "Loan":
                i=6;
                break;


        }

        return Driver.get().findElement(By.xpath("(//a[@style='text-decoration: underline'])["+i+"]"));
    }




    public WebElement getAccountType(String accountType){

        String xpath ="//h2[.='"+accountType+"')][@class='board-header']";
        return Driver.get().findElement(By.xpath(xpath));
    }


    // get columns from table
    public List<WebElement> getColumns(String accountType){

        int i=0;

        switch (accountType)
            {
            case "Cash Accounts" :
                i=1;
                break;

             case "Investment Accounts" :
               i=2;
               break;

            case "Credit Accounts" :
                i=3;
                break;

            case "Loan Accounts" :
               i=4;
               break;

            }

        return Driver.get().findElements(By.xpath("(//table)["+i+"]//th"));

    }




}

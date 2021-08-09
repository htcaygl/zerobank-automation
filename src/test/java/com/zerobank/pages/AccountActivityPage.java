package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{


    Select dropdown= new Select(Driver.get().findElement(By.id("aa_accountId")));

    public WebElement dropdownDefault(){

        return dropdown.getFirstSelectedOption();
    }

    public List<WebElement> dropdownOptions(){
        return dropdown.getOptions();
    }

    @FindBy(css = "#all_transactions_for_account th")
    public List<WebElement> tableColumns;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(id= "aa_fromDate")
    public WebElement dateFrom;

    @FindBy(id = "aa_toDate")
    public WebElement dateTo;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findBtn;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//td[contains(text(),'2012-09')]")
    public List<WebElement> dates;

    @FindBy(id="aa_description")
    public WebElement description;


    public List<WebElement> getTableDescriptionInfo(String str){

        return Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//td[contains(text(),'"+str+"')]"));

    }

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> underDepositColumns;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> underWithdrawalColumns;

}

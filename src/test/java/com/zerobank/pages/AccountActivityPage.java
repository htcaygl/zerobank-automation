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




}

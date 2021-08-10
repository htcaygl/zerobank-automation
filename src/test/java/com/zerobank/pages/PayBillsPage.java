package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(id="sp_amount")
    public WebElement amountInput;

    @FindBy(id="sp_date")
    public WebElement dateInput;

    @FindBy(id="sp_description")
    public WebElement descriptionInput;

    @FindBy(css = "#alert_content>span")
    public WebElement alertMsg;

    @FindBy(id="pay_saved_payees")
    public WebElement payBtn;


    public WebElement getTab(String tab){

        return Driver.get().findElement(By.xpath("//li[contains(@class, 'ui-state-default ui-corner-top')]//a[contains(text(),'"+tab+"')]"));
    }

    @FindBy(xpath = "//*[contains(@id,'np_new_payee_')]")
    public List<WebElement> payeeInputs;

    @FindBy(id="add_new_payee")
    public WebElement addBtn;

    @FindBy(id="alert_content")
    public WebElement newPayeeMsg;

    public List<WebElement> dropdownCurrencyOptions(){

        Select dropCurrency= new Select(Driver.get().findElement(By.id("pc_currency")));

        return dropCurrency.getOptions();
    }

}

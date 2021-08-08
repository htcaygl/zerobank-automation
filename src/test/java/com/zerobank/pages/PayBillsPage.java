package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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



}

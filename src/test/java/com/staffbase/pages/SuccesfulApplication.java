package com.staffbase.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccesfulApplication extends BasePage{
    @FindBy(xpath = "//h1[.='Thank you for applying.']")
    public WebElement confirmationMessage;
}

package com.staffbase.pages;

import com.staffbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobDescriptionPage extends BasePage {


    @FindBy(xpath = "//a[.='Apply']")
    public WebElement applyButton;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement cookiesAccept;

}

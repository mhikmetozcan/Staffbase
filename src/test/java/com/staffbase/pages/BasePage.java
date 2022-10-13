package com.staffbase.pages;

import com.staffbase.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){// initializing the page object for locating the web elements of the web page (POM design pattern)
        PageFactory.initElements(Driver.getDriver(), this);
    }
}

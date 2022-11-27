package com.staffbase.pages;

import com.staffbase.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedIn extends BasePage {
    ApplicationPage applicationPage = new ApplicationPage();

    @FindBy(xpath = "//iframe[@id='grnhse_iframe']")
    public WebElement parentIFrame;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInWithLinkedIn;

    @FindBy(xpath = "//iframe[@title='LinkedIn Embedded Content']")
    public WebElement linkedInFrame;

    @FindBy(xpath = "//button[@id='apply-with-linkedin']")
    public WebElement applyWithLinkedInButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement linkedInUsernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement linkedInPasswordBox;

    @FindBy(xpath = "//button[.='Allow']")
    public WebElement allowButton;

    public String getTextFromField(String fieldName) {
        Driver.getDriver().switchTo().frame(parentIFrame);
        switch (fieldName) {
            case "firstName":
                System.out.println("applicationPage.firstName.getText() = " + applicationPage.firstName.getAttribute("value"));
                return applicationPage.firstName.getAttribute("value");
            case "lastName":
                System.out.println("applicationPage.lastName.getText() = " + applicationPage.lastName.getAttribute("value"));
                return applicationPage.lastName.getAttribute("value");

            case "email":
                System.out.println("applicationPage.email.getText() = " + applicationPage.email.getAttribute("value"));
                return applicationPage.email.getAttribute("value");

            case "phone":
                System.out.println("applicationPage.phone.getText() = " + applicationPage.phone.getAttribute("value"));
                return applicationPage.phone.getAttribute("value");

            case "resume":
                return applicationPage.manualResume.getAttribute("value");
        }
        return null;
    }
}

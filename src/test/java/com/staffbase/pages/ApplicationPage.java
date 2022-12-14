package com.staffbase.pages;

import com.staffbase.utilities.BrowserUtils;
import com.staffbase.utilities.ConfigurationReader;
import com.staffbase.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ApplicationPage extends BasePage{

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @FindBy(xpath = "(//button[.='Attach'])[1]")
    public WebElement resume;

    @FindBy(xpath = "(//button[.='Attach'])[2]")
    public WebElement coverLetter;

    @FindBy(id = "job_application_answers_attributes_1_answer_selected_options_attributes_1_question_option_id")
    public WebElement dropDown;

    @FindBy(xpath = "//textarea[@name='job_application[answers_attributes][2][text_value]']")
    public WebElement gitHubRepo;

    @FindBy(xpath = "//input[@value='Submit Application']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='field-error-msg']")
    public WebElement errorMessage;

    @FindBy(xpath = "//button[.='or enter manually']")
    public WebElement enterManually;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@id='job_application_answers_attributes_0_text_value']")
    public WebElement workPermit;

    @FindBy(xpath = "//textarea[@id='resume_text']")
    public WebElement manualResume;


    public void dataEntryToInputBox(String fieldName, String fieldValue){
        switch (fieldName){
            case "firstName":
              //  WebElement firstName =(WebElement)js.executeScript("return document.querySelector('#first_name')");
                firstName.sendKeys(fieldValue);
                break;
            case "lastName":
              //  WebElement lastName = (WebElement)js.executeScript("return document.querySelector('#last_name')");
                lastName.sendKeys(fieldValue);
                break;
            case "email":
              //  WebElement email = (WebElement)js.executeScript("return document.querySelector('#email')") ;
                email.sendKeys(fieldValue);
                break;
            case "phone":
              //  WebElement phone = (WebElement)js.executeScript("return document.querySelector(\"#phone\")");
                phone.sendKeys(fieldValue);
                break;
            case "work permit status":
              //  WebElement workPermit = (WebElement)js.executeScript("return document.querySelector('#job_application_answers_attributes_0_text_value')");
                workPermit.sendKeys(fieldValue);
                break;
            case "gitHubRepo":
                gitHubRepo.sendKeys(fieldValue);
                break;
            default:
                break;
        }
    }



    public void dataEntryToInputBox(String fieldValue){
        switch (fieldValue){
            case "John":
              //  WebElement firstName =(WebElement)js.executeScript("return document.querySelector('#first_name')");
                firstName.sendKeys(fieldValue);
                break;
            case "Doe":
             //   WebElement lastName = (WebElement)js.executeScript("return document.querySelector('#last_name')");
                lastName.sendKeys(fieldValue);
                break;
            case "johndoe@gmail.com":
              //  WebElement email = (WebElement)js.executeScript("return document.querySelector('#email')") ;
                email.sendKeys(fieldValue);
                break;
            case "123456789":
             //   WebElement phone = (WebElement)js.executeScript("return document.querySelector(\"#phone\")");
                phone.sendKeys(fieldValue);
                break;
            case "John Doe the QA Engineer":
                enterManually.click();
                //WebElement resume = (WebElement)js.executeScript("return document.querySelector(\"#resume_text\")");
                manualResume.sendKeys(fieldValue);
                break;
            case "https://github.com/johndoe":
                gitHubRepo.sendKeys(fieldValue);
                break;
            default:
                break;
        }
    }

    public void uploadDocument(String documentName){
        StringSelection stringSelection;
        switch (documentName){
            case "resume":
                resume.click();
                BrowserUtils.waitFor(2);
                stringSelection  = new StringSelection(ConfigurationReader.getProperty("resume"));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                BrowserUtils.waitFor(1);
                BrowserUtils.pasteContent();
                BrowserUtils.waitFor(1);
                BrowserUtils.hitEnter();
                break;

            case "cover letter":
                coverLetter.click();
                BrowserUtils.waitFor(2);
                stringSelection = new StringSelection(ConfigurationReader.getProperty("coverLetter"));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                BrowserUtils.waitFor(1);
                BrowserUtils.pasteContent();
                BrowserUtils.waitFor(1);
                BrowserUtils.hitEnter();
                break;
        }


    }

}



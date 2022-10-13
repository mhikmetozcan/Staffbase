package com.staffbase.pages;

import com.staffbase.utilities.BrowserUtils;
import com.staffbase.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationPage extends BasePage{


    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();



    @FindBy(xpath = "(//button[.='Attach'])[1]")
    public WebElement resume;

    @FindBy(xpath = "(//button[.='Attach'])[2]")
    public WebElement coverLetter;


    @FindBy(xpath = "//select[@id='job_application_answers_attributes_1_answer_selected_options_attributes_1_question_option_id']")
    public WebElement dropDown;

    @FindBy(xpath = "//textarea[@name='job_application[answers_attributes][2][text_value]']")
    public WebElement gitHubRepo;

    @FindBy(xpath = "//input[@value='Submit Application']")
    public WebElement submitButton;

    @FindBy(xpath = "//iframe[@id='grnhse_iframe']")
    public WebElement iFrame;


    public void dataEntryToInputBox(String fieldName, String fieldValue){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),50);
        switch (fieldName){

            case "firstName":
                WebElement firstName =(WebElement)js.executeScript("return document.querySelector('#first_name')");
                firstName.sendKeys(fieldValue);
                break;
            case "lastName":
                WebElement lastName = (WebElement)js.executeScript("return document.querySelector('#last_name')");
                lastName.sendKeys(fieldValue);
                break;
            case "email":
                WebElement email = (WebElement)js.executeScript("return document.querySelector('#email')") ;
                email.sendKeys(fieldValue);
                break;
            case "phone":
                WebElement phone = (WebElement)js.executeScript("return document.querySelector(\"#phone\")");
                phone.sendKeys(fieldValue);
                break;
            case "work permit status":
                WebElement workPermit = (WebElement)js.executeScript("return document.querySelector('#job_application_answers_attributes_0_text_value')");
                workPermit.sendKeys(fieldValue);
                break;
            case "gitHubRepo":
//                wait.until(ExpectedConditions.visibilityOf(gitHubRepo));
                gitHubRepo.sendKeys(fieldValue);
                break;
            default:
                break;
        }
    }

}



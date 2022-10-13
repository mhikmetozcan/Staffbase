package com.staffbase.stepDefinitions;

import com.nick318.search.by.frames.SearchByFrames;
import com.nick318.search.by.frames.SearchByFramesFactory;
import com.staffbase.pages.ApplicationPage;
import com.staffbase.pages.JobDescriptionPage;
import com.staffbase.utilities.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

public class SubmitApplicationStepDefinitions {

    ApplicationPage applicationPage = new ApplicationPage();
    ButtonGenerator buttonGenerator = new ButtonGenerator();
    IFrameGenerator iFrameGenerator = new IFrameGenerator();

    @Given("user is on the {string} page")
    public void userIsOnThePage(String page) {
        String url = ConfigurationReader.getProperty(page);
        Driver.getDriver().get(url);
    }

    @And("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        buttonGenerator.clickButton(buttonName);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String fieldName, String fieldValue) {
        Driver.getDriver().switchTo().frame("grnhse_iframe");
        applicationPage.dataEntryToInputBox(fieldName, fieldValue);
        Driver.getDriver().switchTo().parentFrame();
    }

    @When("the resume is attached")
    public void the_resume_is_attached() {
        Driver.getDriver().switchTo().frame("grnhse_iframe");
        applicationPage.resume.sendKeys("C:\\Users\\HuG0\\IdeaProjects\\Staffbase\\MustafaHikmet_Özcan_Resume.pdf");
        Driver.getDriver().switchTo().parentFrame();
    }
    @When("the cover letter is attached")
    public void the_cover_letter_is_attached() {

    }

    @When("the privacy notice is confirmed")
    public void the_privacy_notice_is_confirmed() {
        Driver.getDriver().switchTo().frame("grnhse_iframe");
        Select select = new Select(applicationPage.dropDown);
        //select.selectByVisibleText("Yes");
        BrowserUtils.dropdownOptions(applicationPage.dropDown).get(1);// now works, needs to be made sure if yes is selected
        Driver.getDriver().switchTo().parentFrame();
    }


}

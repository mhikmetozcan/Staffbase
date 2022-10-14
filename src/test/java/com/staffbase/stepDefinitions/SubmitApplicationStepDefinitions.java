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

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.security.KeyFactorySpi;
import java.util.List;
import java.util.Optional;

public class SubmitApplicationStepDefinitions {

    ApplicationPage applicationPage = new ApplicationPage();
    ButtonGenerator buttonGenerator = new ButtonGenerator();

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
    public void the_resume_is_attached() throws AWTException {
        Driver.getDriver().switchTo().frame("grnhse_iframe");
        applicationPage.resume.click();
        BrowserUtils.waitFor(2);
        StringSelection stringSelection = new StringSelection("C:\\Users\\HuG0\\IdeaProjects\\Staffbase\\files\\MustafaHikmet_Özcan_Resume.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        BrowserUtils.waitFor(1);
        BrowserUtils.pasteContent();
        BrowserUtils.waitFor(1);
        BrowserUtils.hitEnter();
        Driver.getDriver().switchTo().parentFrame();
    }
    @When("the cover letter is attached")
    public void the_cover_letter_is_attached() {

    }

    @When("the privacy notice is confirmed")
    public void the_privacy_notice_is_confirmed() {
        Driver.getDriver().switchTo().frame("grnhse_iframe");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].setAttribute('style', 'width: 200px')",applicationPage.dropDown);
         Select select = new Select(applicationPage.dropDown);
         select.selectByValue("95567109002");
        Driver.getDriver().switchTo().parentFrame();
    }


}

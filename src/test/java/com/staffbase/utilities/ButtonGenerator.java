package com.staffbase.utilities;

import com.staffbase.pages.ApplicationPage;
import com.staffbase.pages.JobDescriptionPage;
import com.staffbase.pages.LinkedIn;
import org.openqa.selenium.*;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ButtonGenerator {

    JobDescriptionPage jobDescriptionPage;
    ApplicationPage applicationPage;
    LinkedIn linkedIn = new LinkedIn();

    /**
     * Is used for clicking any button with a single step definition as "click on 'button'"
     * @param buttonName name of the button to be clicked
     */
    public void clickButton(String buttonName){
        String origin;
        setComponent();
        switch (buttonName){
            case "Apply":
                jobDescriptionPage.applyButton.click();
                break;
            case "Accept":
                jobDescriptionPage.cookiesAccept.click();
                break;
            case "Submit Application":
                Driver.getDriver().switchTo().frame("grnhse_iframe");
            //    applicationPage.submitButton.click();
                Driver.getDriver().switchTo().parentFrame();
                break;
            case "Apply With LinkedIn":
                Driver.getDriver().switchTo().frame(linkedIn.parentIFrame);
                Driver.getDriver().switchTo().frame(linkedIn.linkedInFrame);
                linkedIn.applyWithLinkedInButton.click();
                Driver.getDriver().switchTo().parentFrame();
                Driver.getDriver().switchTo().parentFrame();
                break;
            case "sign in":
                origin = Driver.getDriver().getWindowHandle();
                BrowserUtils.switchToWindow("LinkedIn Login, Sign in | LinkedIn");
                linkedIn.signInWithLinkedIn.click();
                Driver.getDriver().switchTo().window(origin);
                break;
            case "allow":
                origin = Driver.getDriver().getWindowHandle();
                BrowserUtils.switchToWindow("LinkedIn Login, Sign in | LinkedIn");
                if(linkedIn.allowButton.isDisplayed())
                linkedIn.allowButton.click();
                Driver.getDriver().switchTo().window(origin);
                break;
        }
    }

    /**
     * Prepares the page object instance
     */
    public void setObject(){
        if (jobDescriptionPage == null){
            jobDescriptionPage = new JobDescriptionPage();
        }
        if(applicationPage == null){
            applicationPage = new ApplicationPage();
        }
        if(linkedIn == null){
            linkedIn = new LinkedIn();
        }
    }

    /**
     * Destroys previous instances of the page objects
     */
    public void resetObject(){
        jobDescriptionPage = null;
        applicationPage = null;
        linkedIn = null;
    }

    /**
     * Sets the page objects for the use
     */
    public void setComponent(){
        resetObject();
        setObject();
    }


}

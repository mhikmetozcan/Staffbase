package com.staffbase.utilities;

import com.staffbase.pages.ApplicationPage;
import com.staffbase.pages.JobDescriptionPage;

public class ButtonGenerator {

    JobDescriptionPage jobDescriptionPage;
    ApplicationPage applicationPage;

    /**
     * Is used for clicking any button with a single step definition as "click on 'button'"
     * @param buttonName name of the button to be clicked
     */
    public void clickButton(String buttonName){
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
                applicationPage.submitButton.click();
                Driver.getDriver().switchTo().parentFrame();
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
    }

    /**
     * Destroys previous instances of the page objects
     */
    public void resetObject(){
        jobDescriptionPage = null;
        applicationPage = null;
    }

    /**
     * Sets the page objects for the use
     */
    public void setComponent(){
        resetObject();
        setObject();
    }


}

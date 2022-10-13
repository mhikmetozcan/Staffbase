package com.staffbase.utilities;

import com.staffbase.pages.JobDescriptionPage;

public class ButtonGenerator {

    JobDescriptionPage jobDescriptionPage;

    /**
     *
     * @param buttonName
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
        }
    }

    /**
     *
     */
    public void setObject(){
        if (jobDescriptionPage == null){
            jobDescriptionPage = new JobDescriptionPage();
        }
    }

    /**
     *
     */
    public void resetObject(){
        jobDescriptionPage = null;
    }

    /**
     *
     */
    public void setComponent(){
        resetObject();
        setObject();
    }


}

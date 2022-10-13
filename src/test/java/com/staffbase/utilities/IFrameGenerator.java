package com.staffbase.utilities;

import com.staffbase.pages.ApplicationPage;
import com.staffbase.pages.JobDescriptionPage;
import org.openqa.selenium.WebElement;

public class IFrameGenerator {

    ApplicationPage applicationPage;

    /**
     *
     * @param frameID
     */
//    public void switchToFrame(WebElement iframe){
//        setComponent();
//        switch (frameID){
//            case "grnhse_iframe":
//                Driver.getDriver().switchTo().frame(frameID);
//                break;
//        }
//
//    }

    /**
     *
     */
    public void setObject(){
        if (applicationPage == null){
            applicationPage = new ApplicationPage();
        }
    }

    /**
     *
     */
    public void resetObject(){
        applicationPage = null;
    }

    /**
     *
     */
    public void setComponent(){
        resetObject();
        setObject();
    }

}

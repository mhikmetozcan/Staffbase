package com.staffbase.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options in a List of WebElements.
     * @param dropdownElement
     * @return List<WebElement> actualOptionsAsWebElement
     */
    public static List<WebElement> dropdownOptions(WebElement dropdownElement){
        Select select = new Select(dropdownElement);

        //List of all ACTUAL <options> as a web element
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        return  actualOptionsAsWebElement;

    }

    /**
     * Switches to new window by the exact title. Returns to original window if target title not found
     * @param targetTitle
     */
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     */

    public static void switchToFrame(WebElement iframe){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        Driver.getDriver().switchTo().frame(iframe);
    }
}

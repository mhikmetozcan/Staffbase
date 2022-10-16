package com.staffbase.stepDefinitions;

import com.staffbase.utilities.BrowserUtils;
import com.staffbase.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    //After scenario ends the WebDriver session and takes screenshot if the scenario fails
    @After
    public void tearDownScenario(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
        }
        BrowserUtils.waitFor(5);
        Driver.closeDriver();
    }
}

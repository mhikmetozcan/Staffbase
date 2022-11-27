package com.staffbase.stepDefinitions;

import com.staffbase.pages.LinkedIn;
import com.staffbase.utilities.ApachePOI;
import com.staffbase.utilities.BrowserUtils;
import com.staffbase.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LinkedInStepDefinitions {

    LinkedIn linkedIn = new LinkedIn();
    @When("user enters LinkedIn {string}")
    public void userEntersLinkedIn(String inputBox) {
        String origin = Driver.getDriver().getWindowHandle();
        BrowserUtils.switchToWindow("LinkedIn Login, Sign in | LinkedIn");
        switch (inputBox){
            case "username":
                linkedIn.linkedInUsernameBox.sendKeys(ApachePOI.readFromExcel(1,0));
                break;
            case "password":
                linkedIn.linkedInPasswordBox.sendKeys(ApachePOI.readFromExcel(1,1));
                break;
        }
        Driver.getDriver().switchTo().window(origin);
    }

    @Then("User verifies {string} is filled")
    public void userVerifiesIsFilled(String fieldName) {
        Assert.assertNotEquals("",linkedIn.getTextFromField(fieldName));
    }
}

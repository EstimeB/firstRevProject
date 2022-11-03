package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

public class NegativeDefectReportSteps {
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        Alert alert;
        String actualRes;
        try{
            alert = BasicRunner.driver.switchTo().alert();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
            actualRes = null;
            Assert.assertEquals(actualRes, null);
        }
    }
}

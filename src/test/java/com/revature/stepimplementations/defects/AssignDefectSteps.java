package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.revature.runners.BasicRunner.assignedDefectId;
import static com.revature.runners.BasicRunner.wait;

public class AssignDefectSteps {

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        String expectedRes = "Defect ID"+" Defect desc"+" Select";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//table/thead")));
        String actulRes = BasicRunner.driver.findElement(By.xpath
                ("//table/thead")).getText();
        Assert.assertEquals(actulRes, expectedRes);
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        //will select the first defect's select button
        BasicRunner.driver.findElement(By.xpath
                ("//tbody/tr[1]/td/button[text()='Select']"))
                .click();
        //attempting to store the defect id to be retrieved in later steps
        BasicRunner.assignedDefectId = BasicRunner.driver.findElement
                (By.xpath("//table/tbody/tr[1]/td[1]")).getText();
    }
    public static String actualRes;
    @Then("The defect description should appear in {string}")
    public void the_defect_description_should_appear_in_bold(String expectedRes) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div/h4")));
        WebElement defectDesc = BasicRunner.driver.findElement(By.cssSelector("h4"));
        int elCsVal = Integer.parseInt(defectDesc.getCssValue("font-weight"));

        if (elCsVal >= 700) {
            actualRes = "bold";
        }
        Assert.assertEquals(actualRes, expectedRes);
    }
    @When("The manager selects a tester from the drop down")
    public void the_manager_selects_a_tester_from_the_drop_down() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h4/following::input")));
        BasicRunner.driver.findElement(
                By.xpath("//h4/following::input"))
                .sendKeys("ryeGuy");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        BasicRunner.driver.findElement(By.xpath
                ("//h4/following::button[text()='Assign']")).click();
    }
    public static String actualR;
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        String expectedR = null;
        actualR = null;
        String dlText;
        try {
            BasicRunner.driver.findElements(
                    By.xpath("//tr"));
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                    ("//tr")));
            List<WebElement> defectList = BasicRunner.driver.findElements(
                    By.xpath("//tr"));

            for (WebElement dl : defectList) {
                dlText = dl.getText();
                if (dlText.equals(assignedDefectId)) {
                    actualR = dlText;
                    break;
                }
            }
            Assert.assertEquals(actualR, expectedR);
        }
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> pendingDefectList = BasicRunner.driver.findElements(By.xpath
                ("//ul/li/div/span/p/b[text()='ID: ']"));
        String pdlText;
        String actualPendingDefect;
        String expectedPendingDefect = BasicRunner.assignedDefectId;

        for (WebElement pdl: pendingDefectList) {
            pdlText = pdl.getText().trim();
            if (pdlText.equals(BasicRunner.assignedDefectId)) {
                actualPendingDefect = pdlText;
                Assert.assertEquals(actualPendingDefect, expectedPendingDefect);
                break;
            } else if (pdl.equals(pendingDefectList.size()-1)) {
                actualPendingDefect = pdlText;
                Assert.assertEquals(actualPendingDefect, expectedPendingDefect);
            }
        }
    }
}

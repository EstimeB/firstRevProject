package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class AssignDefectSteps {

    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {

    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        //will select the first defect's select button
        BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/table/tbody/tr[1]/td[3]/button"))
                .click();
        //attempting to store the defect id to be retrieved in later steps
        BasicRunner.assignedDefectId = BasicRunner.driver.findElement
                (By.xpath("//*[@id='root']/table/tbody/tr[1]/td[1]")).getText();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {

    }
    @When("The manager selects a tester from the drop down")
    public void the_manager_selects_a_tester_from_the_drop_down() {
        Select testerList = new Select(BasicRunner.driver.findElement(
                By.xpath("//*[@id='root']/div/input")));
        testerList.selectByVisibleText("ryeGuy");
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/div/button")).click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {

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

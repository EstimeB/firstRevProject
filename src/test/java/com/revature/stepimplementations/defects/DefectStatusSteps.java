package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.List;

import static com.revature.runners.BasicRunner.wait;

public class DefectStatusSteps {

    public static String defectStatusBtnText;
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() throws InterruptedException {
        Thread.sleep(1000);

        List<WebElement> testersDefectsList = BasicRunner.driver
                .findElements(By.xpath("//li/div"));

        for (WebElement td: testersDefectsList) {
            td.click();
            break;
        }
    }
    @When("The tester changes the defect to any status")
    public void the_tester_changes_the_defect_to_any_status() throws InterruptedException {
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/span/button[text()='Change Status']")));
        BasicRunner.driver.findElement(By.xpath
                        ("//div/span/button[text()='Change Status']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div/div/button")));
        List<WebElement> defectStatuses = BasicRunner.driver.findElements(By.xpath
                ("//div/div/button"));

        for (WebElement ds: defectStatuses) {
            Thread.sleep(1000);
            defectStatusBtnText = ds.getText();
            ds.click();
            break;
        }

    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        WebElement defectStatus = BasicRunner.driver.findElement(By.xpath
                ("//div/span/p/b[2]"));
        String actualDefectStatus = defectStatus.getText();

        String expectedDefectStatus = defectStatusBtnText;

        Assert.assertEquals(actualDefectStatus, expectedDefectStatus);

    }
}

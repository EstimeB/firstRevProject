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
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        String expectedRes = "My Defects";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h3[text()='My Defects']")));
        String actualRes = BasicRunner.driver.findElement(By.xpath
                ("//h3[text()='My Defects']")).getText();

        Assert.assertEquals(actualRes, expectedRes);
    }
    @When("The tester changes the defect to any status")
    public void the_tester_changes_the_defect_to_any_status() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[1]")));
        BasicRunner.driver.findElement(By.xpath
                ("//li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[1]/div/div/div/div[1]/span/button[text()='Change Status']")));
        BasicRunner.driver.findElement(By.xpath
                        ("//li[1]/div/div/div/div[1]/span/button[text()='Change Status']"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[1]/div/div/div/div[1]/div/div/button")));
        List<WebElement> defectStatuses = BasicRunner.driver.findElements(By.xpath
                ("//li[1]/div/div/div/div[1]/div/div/button"));

        for (WebElement ds: defectStatuses) {
            defectStatusBtnText = ds.getText();
            ds.click();
            break;
        }
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[1]/div/span/p/b[2]")));
        WebElement defectStatus = BasicRunner.driver.findElement(By.xpath
                ("//li[1]/div/span/p/b[2]"));
        String actualDefectStatus = defectStatus.getText();

        String expectedDefectStatus = defectStatusBtnText;

        Assert.assertEquals(actualDefectStatus, expectedDefectStatus);
    }
}

package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PositiveDefectReportSteps {

    public static Alert alert;
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();

        Thread.sleep(1000);
        BasicRunner.loginPage.reportADefectLink.click();

    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        BasicRunner.driver.findElement(By.xpath("//*[@id='defectReport']/input[1]"))
                .sendKeys("2-november-2022");
    }
    @When("The employee types in Description with")
    public void the_employee_types_in_Description_with(String description) {
        BasicRunner.driver.findElement(By.xpath("//*[@id='defectReport']/textarea[1]"))
                .sendKeys(description);

    }
    @When("The employee types in Steps with")
    public void the_employee_types_in_Steps_with(String steps) {
        BasicRunner.driver.findElement(By.xpath("//*[@id='defectReport']/textarea[2]"))
                .sendKeys(steps);
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        Select priorityLevel = new Select(BasicRunner.driver.findElement(
                By.xpath("//*[@id='defectReport']/input[3]")));
        priorityLevel.selectByVisibleText("High");
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        Select severityLevel = new Select(BasicRunner.driver.findElement(
                By.xpath("//*[@id='defectReport']/input[2]")));
        severityLevel.selectByVisibleText("LOW");
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        BasicRunner.driver.findElement(By.xpath
                ("//*[@id='defectReport']/button")).click();
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        alert = BasicRunner.driver.switchTo().alert();
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        alert.accept();
    }
    @Then("A modal should appear with a {string} ID")
    public void a_modal_should_appear_with_a_defect_id(String expectedResult) {
        String actualResult = BasicRunner.driver.findElement(By.xpath
                ("/html/body/div[3]/div/div/h4/text()[1]")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        BasicRunner.driver.findElement(By.xpath
                ("/html/body/div[3]/div/div/button")).click();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {

    }
}

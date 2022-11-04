package com.revature.stepimplementations.defects;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.revature.runners.BasicRunner.driver;
import static com.revature.runners.BasicRunner.wait;

public class PositiveDefectReportSteps {

    public static Alert alert;
    public static String defectId;
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[3]"))).sendKeys("High");
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//input[2]"))).sendKeys("LOW");
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        BasicRunner.driver.findElement(By.xpath
                ("//button[text()='Report']")).click();
    }
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        alert = BasicRunner.driver.switchTo().alert();
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        alert.accept();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h4")));
        defectId = BasicRunner.driver.findElement(By.xpath
                ("//h4")).getText();
    }
    @Then("A modal should appear with a defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        String expectedResult = defectId;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h4")));
        String actualResult = BasicRunner.driver.findElement(By.xpath
                ("//h4")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        BasicRunner.driver.findElement(By.xpath
                ("//button[text()='Close']")).click();
    }
    public static String actualRes;
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        // if the findElements() method where to return/added multiple elements to the list
        //that would mean that the modal is still open
        List<WebElement> el = driver.findElements(By.xpath("//div[2]"));

        for (WebElement ar: el) {
            String arstr = ar.getAttribute("class=\"ReactModalPortal\"");
            actualRes =arstr;
        }
        System.out.println(actualRes);
        String expectedRes = null;
        //if the modal is closed, this would be the element that would return from the fetch

        Assert.assertEquals(actualRes, expectedRes);
    }
}

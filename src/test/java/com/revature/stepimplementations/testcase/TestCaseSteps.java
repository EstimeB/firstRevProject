package com.revature.stepimplementations.testcase;

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

import static com.revature.runners.BasicRunner.wait;

public class TestCaseSteps {

    public static Alert alert;
    public static String descRTC;
    public static String stepsRTC;
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();

        Thread.sleep(1000);
        BasicRunner.loginPage.testCasesLink.click();
    }
    @When("The tester types Description into input with")
    public void the_tester_types_Description_into_input_with(String description) {
        BasicRunner.testCasePage.descriptionTextArea.sendKeys(description);
    }
    @When("The tester types Steps into input with")
    public void the_tester_types_into_Steps_into_with(String steps) {
        BasicRunner.testCasePage.stepsTextArea.sendKeys(steps);
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        BasicRunner.testCasePage.testCaseSubmitBtn.click();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        BasicRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/table/tbody/tr/td")));
        List<WebElement> testCases = BasicRunner.driver.findElements(
                By.xpath("//*[@id='root']/table/tbody/tr/td"));

        String expectedDescription = "Verify that usernames cannot have illegal characters";
        String actualRes;
        String tcText;

        for (WebElement tc: testCases) {
            tcText = tc.getText();
            if (tcText.equals(expectedDescription)) {
                actualRes = tcText;
                Assert.assertEquals(actualRes, expectedDescription);
                break;
            }
        }

    }
    @Then("The test case result should say {string}")
    public void the_test_case_result_should_say_unexecuted(String expectedResult) {
        WebElement testCase = BasicRunner.driver.findElement(
        By.xpath
    (
    "//*[@id='root']/table/tbody/tr/td[text()='Verify that usernames cannot have illegal characters']/following::td[text()='UNEXECUTED']"));
        String actualResult = testCase.getText();


        Assert.assertEquals(actualResult, expectedResult);

    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {


        BasicRunner.testCasePage.detailsBtn.click();
    }
    @Then("A test case modal should appear showing the {string} ID")
    public void a_test_case_modal_should_appear_showing_the_case_id(String expectedCaseId) {
        WebElement  atci = BasicRunner.driver.findElement(
                By.xpath("/html/body/div[3]/div/div/h3"));
        String actualTestCaseId = atci.getText();

        Assert.assertEquals(actualTestCaseId, expectedCaseId);

    }
    @Then("The performed by field should say {string}")
    public void the_performed_by_field_should_say_no_one(String expectedText) {

        WebElement at = BasicRunner.driver.findElement(
                By.xpath("/html/body/div[3]/div/div/p[6]"));
        String actualText = at.getText();

        Assert.assertEquals(actualText, expectedText);
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        BasicRunner.testCasePage.closeButton.click();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() throws org.openqa.selenium.StaleElementReferenceException {

//        String actualRes;
//        //location to the closed modal div
//        String expectedRes = "/html/body/div[2]";
//        try {
//            BasicRunner.driver.findElement(By.xpath("/html/body/div[3]/div/div"));
//        } catch (org.openqa.selenium.StaleElementReferenceException e) {
//            e.printStackTrace();
//            actualRes = "/html/body/div[2]";
//            Assert.assertEquals(actualRes, expectedRes);
//        }
    }
    //scenario 2
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() throws InterruptedException {
        Thread.sleep(1000);
        BasicRunner.testCasePage.detailsBtn.click(); /////
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        BasicRunner.testCasePage.editButton.click();
    }
    @Then("The Tester should be on the {string} for that case")
    public void the_tester_should_be_on_the_Case_Editor_for_that_case(String expectedPageTitle) {
        String actualPageTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        WebElement descFieldsStatus = (WebElement) BasicRunner.driver.findElement(
                By.xpath("//*[@id='root']/fieldset[1]/textarea[1]"));
        String actualFieldsStatus  = descFieldsStatus.getAttribute("disabled");
        String expectedFieldsStatus = "disabled";

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);
    }
    @When("The tester clicks on the edit button again")
    public void the_tester_clicks_on_the_edit_button_again() {
        BasicRunner.testCasePage.editBtn.click();
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        WebElement fieldsStatus = BasicRunner.driver.findElement(
                By.xpath("//*[@id='root']/fieldset[1]/textarea"));
        String actualFieldsStatus  = fieldsStatus.getAttribute("disabled");
        String expectedFieldsStatus = null;

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        descRTC = BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[1]")).getText();
        BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[1]"))
                .sendKeys("Modify that username to fit the criteria");
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        stepsRTC = BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[1]")).getText();
        BasicRunner.driver.findElement(By.xpath
                        ("//*[@id='root']/fieldset[1]/textarea[1]"))
                .sendKeys("""
        1. Go to create a new account page
        2. create One or several users with each username having 1 illegal character
        """);
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        BasicRunner.testCasePage.automateCheckMark.click();
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        List<WebElement> performedDropDownMenu = BasicRunner.driver
                .findElements(By.xpath("//*[@id='root']/fieldset[1]/select"));
        String pddmText;
        for (WebElement pddm: performedDropDownMenu) {
            pddmText = pddm.getText();
            if (pddmText.equals("ryeGuy")) {
                pddm.click();
                break;
            }
        }
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        List<WebElement> testResultDropDownMenu = BasicRunner.driver
                .findElements(By.xpath("//*[@id='root']/fieldset[2]/select"));
        String trddmText;
        for (WebElement trddm: testResultDropDownMenu) {
            trddmText = trddm.getText();
            if (trddmText.equals("FAIL")) {
                trddm.click();
                break;
            }
        }
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        BasicRunner.testCasePage.summaryTextArea
                .sendKeys("This will be the test cases to be implemented.");
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        BasicRunner.testCasePage.testCaseSaveBtn.click();
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        alert = BasicRunner.driver.switchTo().alert();
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        alert.accept();
    }
    @Then("An alert says the {string}")
    public void an_alert_says_the_Test_Case_has_been_Saved(String expectedAlertText) {
        String actualAlertText = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(actualAlertText, expectedAlertText);
    }
    //scenarion 3
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() throws InterruptedException {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();

        Thread.sleep(1000);
        BasicRunner.loginPage.testCasesLink.click();

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//                ("//*[@id='root']/nav/a[2][text()='Test Cases']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='root']/table/tbody/tr[1]/td[4]/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("/html/body/div[3]/div/div/button[2]"))).click();
    }
    @Then("The fields should be uneditable for test case reset")
    public void The_fields_should_be_uneditable_for_test_case_reset() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[1]")));
        WebElement descFieldsStatus = BasicRunner.driver.findElement(
                By.xpath("//*[@id='root']/fieldset[1]/textarea[1]"));
        String actualFieldsStatus  = descFieldsStatus.getAttribute("disabled");
        String expectedFieldsStatus = "disabled";

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);

    }
    @When("The Tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='root']/button"))).click();
    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='root']/button[1]"))).click();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        String expectedValues = descRTC  + "" +
                stepsRTC;

        String actDescRTC = BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[1]")).getText();
        String actStepRTC = BasicRunner.driver.findElement(By.xpath
                ("//*[@id='root']/fieldset[1]/textarea[2]")).getText();
        String actualValues = actDescRTC + "" +
                actStepRTC;

        Assert.assertEquals(actualValues, expectedValues);
    }
}

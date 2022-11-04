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

import static com.revature.runners.BasicRunner.driver;
import static com.revature.runners.BasicRunner.wait;

public class TestCaseSteps {

    public static Alert alert;
    public static String descRTC;
    public static String stepsRTC;
    public static int caseId;
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
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
    public void the_test_case_should_appear_at_the_bottom_of_the_table() throws InterruptedException {
        String expectedRes = "Verify that usernames cannot have illegal characters";
        String actualRes;

        try {
            driver.findElement(
                    By.xpath("//tr[last()]/td[2]")).getText();
            driver.findElement(
                    By.xpath("//tr[last()]/td[1]")).getText();
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            //to check if the test case was successfully created
            BasicRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//tr[last()]/td[2]")));
            actualRes = driver.findElement(
                    By.xpath("//tr[last()]/td[2]")).getText();

            Assert.assertEquals(actualRes, expectedRes);
            BasicRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//tr[last()]/td[1]")));
        }
        //to find and store the new created test case's id for later use
        Thread.sleep(1000);
        caseId = Integer.parseInt(driver.findElement(
                By.xpath("//tr[last()]/td[1]")).getText());
    }
    @Then("The test case result should say {string}")
    public void the_test_case_result_should_say_unexecuted(String expectedResult) {
        WebElement testCase = driver.findElement(
                By.xpath
                        ("//tr[last()]/td[3]"));
        String actualResult = testCase.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        BasicRunner.testCasePage.detailsBtn.click();
    }
    @Then("A test case modal should appear showing the {string} ID")
    public void a_test_case_modal_should_appear_showing_the_case_id(String string) throws InterruptedException {
        Thread.sleep(1000);
        String  actualTestCaseId = driver.findElement(
                By.xpath("//h3[1]")).getText();

        String expectedCaseId = string +" " + caseId;

        Assert.assertEquals(actualTestCaseId, expectedCaseId);
    }
    @Then("The performed by field should say {string}")
    public void the_performed_by_field_should_say_no_one(String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//div[3]/div/div/h4[text()='Performed By']/following::p")));
        WebElement at = driver.findElement(
                By.xpath("//div[3]/div/div/h4[text()='Performed By']/following::p"));
        String actualText = at.getText();

        Assert.assertEquals(actualText, expectedText);
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        BasicRunner.testCasePage.closeButton.click();
    }
    public static String actualRes;
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        // if the findElements() method where to return/added multiple elements to the list
        //that would mean that the modal is still open
        List<WebElement> el = driver.findElements(By.xpath("/html/body/div[2]"));

        for (WebElement ar: el) {
            String arstr = ar.getAttribute("class=\"ReactModalPortal\"");
            actualRes =arstr;
        }
        System.out.println(actualRes);
        String expectedRes = null;
        //if the modal is closed, this would be the element that would return from the fetch

        Assert.assertEquals(actualRes, expectedRes);
    }

    //scenario 2
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() throws InterruptedException {
        Thread.sleep(1000);
        BasicRunner.testCasePage.detailsBtn.click();
    }
    @Then("The Tester should be on the {string} for that case")
    public void the_tester_should_be_on_the_Case_Editor_for_that_case(String expectedPageTitle) {
        String actualPageTitle = driver.getTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() throws InterruptedException {
        Thread.sleep(900);
        BasicRunner.testCasePage.editButton.click();
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//fieldset[1]/textarea[1]")));
        String actualFieldsStatus = driver.findElement(
                By.xpath("//fieldset[1]/textarea[1]"))
                .getAttribute("disabled");
        String expectedFieldsStatus = "true";

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);
    }
    @When("The tester clicks on the edit button again")
    public void the_tester_clicks_on_the_edit_button_again() {
        BasicRunner.testCasePage.editBtn.click();
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        WebElement fieldsStatus = driver.findElement(
                By.xpath("//*[@id='root']/fieldset[1]/textarea"));
        String actualFieldsStatus  = fieldsStatus.getAttribute("disabled");
        String expectedFieldsStatus = null;

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        descRTC = driver.findElement(By.xpath
                ("//fieldset[1]/textarea[1]")).getText();
        driver.findElement(By.xpath
                ("//fieldset[1]/textarea[1]"))
                .sendKeys("Modify that username to fit the criteria");
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        stepsRTC = driver.findElement(By.xpath
                ("//fieldset[1]/textarea[2]")).getText();
        driver.findElement(By.xpath
                        ("//fieldset[1]/textarea[2]"))
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
        List<WebElement> performedDropDownMenu = driver
                .findElements(By.xpath("//fieldset[1]/select/option"));
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
        List<WebElement> testResultDropDownMenu = driver
                .findElements(By.xpath("//fieldset[2]/select/option"));
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
        alert = driver.switchTo().alert();
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        alert.accept();
    }
    @Then("An alert says the {string}")
    public void an_alert_says_the_Test_Case_has_been_Saved(String expectedAlertText) throws InterruptedException {
        Thread.sleep(1000);
        Alert alrt = driver.switchTo().alert();
        String actualAlertText = alrt.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText);
        alrt.accept();
    }

    //scenarion 3
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() throws InterruptedException {
        driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginbutton.click();

        Thread.sleep(1000);
        BasicRunner.loginPage.testCasesLink.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//table/tbody/tr[last()]/td[4]/button[text()='Details']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button/a[text()='Edit']"))).click();
    }
    @Then("The fields should be uneditable for test case reset")
    public void The_fields_should_be_uneditable_for_test_case_reset() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//fieldset[1]/textarea[1]")));
        String actualFieldsStatus = driver.findElement(
                By.xpath("//fieldset[1]/textarea[1]")).getAttribute("disabled");
        String expectedFieldsStatus = "true";

        Assert.assertEquals(actualFieldsStatus, expectedFieldsStatus);
    }
    @When("The Tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[text()='Edit']"))).click();
    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//button[text()='Reset']"))).click();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        String expectedValues = descRTC  + "" +
                stepsRTC;

        String actDescRTC = driver.findElement(By.xpath
                ("//fieldset[1]/textarea[1]")).getText();
        String actStepRTC = driver.findElement(By.xpath
                ("//fieldset[1]/textarea[2]")).getText();
        String actualValues = actDescRTC + "" +
                actStepRTC;

        Assert.assertEquals(actualValues, expectedValues);
    }
}

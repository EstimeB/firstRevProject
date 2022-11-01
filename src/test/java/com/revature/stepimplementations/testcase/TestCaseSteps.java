package com.revature.stepimplementations.testcase;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCaseSteps {
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/testcases");
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String description, String docString) {
        BasicRunner.testCasePage.descriptionTextArea.sendKeys(docString);
    }

    ///
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        BasicRunner.testCasePage.testCaseSubmitBtn.click();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {

    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {

    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        BasicRunner.testCasePage.detailsBtn.click();
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {

    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {

    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        BasicRunner.testCasePage.closeButton.click();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {

    }
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() {
        BasicRunner.testCasePage.detailsBtn.click(); /////
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        BasicRunner.testCasePage.editButton.click();
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {

    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {

    }
    @When("The tester clicks on the edit button again")
    public void the_tester_clicks_on_the_edit_button_again() {
        BasicRunner.testCasePage.editBtn.click();
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {

    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {

    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {

    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        BasicRunner.testCasePage.automateCheckMark.click();
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        //
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        //
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        BasicRunner.testCasePage.summaryTextArea.sendKeys(); ////
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        BasicRunner.testCasePage.testCaseSaveBtn.click();
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {

    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {

    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {

    }
    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() {

    }
    @When("The Tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {

    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {

    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {

    }
}

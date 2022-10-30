package com.revature.stepimplementations.matrix;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Matrix {

    public static String titleText;
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        BasicRunner.matrixPage.createAMatrixBtn.click();
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        BasicRunner.matrixPage.matrixTitle.sendKeys("ProjectOne RTM");

        //store title to var to be used further down
        titleText = BasicRunner.matrixPage.matrixTitle.getText();
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() {
        //write a user story
        BasicRunner.matrixPage.matrixUserStory.sendKeys("I want to be able to login to the web page.");

        String priority[] = {String.valueOf(BasicRunner.matrixPage.matrixHighPriority),
                String.valueOf(BasicRunner.matrixPage.matrixMediumPriority),
                String.valueOf(BasicRunner.matrixPage.matrixLowPriority)};
        //to randomly select a priority
        for (String p: priority) {
            if (BasicRunner.matrixPage.matrixLowPriority.equals(p)) {
                BasicRunner.matrixPage.matrixLowPriority.click();
            } else if (BasicRunner.matrixPage.matrixMediumPriority.equals(p)) {
                BasicRunner.matrixPage.matrixMediumPriority.click();
            } else if (BasicRunner.matrixPage.matrixHighPriority.equals(p)) {
                BasicRunner.matrixPage.matrixHighPriority.click();
            }
        }
        //write a note
        BasicRunner.matrixPage.matrixNote.sendKeys("This is a must!");
        //add requirement
        BasicRunner.matrixPage.addRequirementBtn.click();
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() {
        //create matrix
        BasicRunner.matrixPage.createMatrixBtn.click();
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {
        Thread.sleep(1000);

        String matricePage = "https://bugcatcher-jasdhir.coe.revaturelabs.com/matrices";
        String expectedNewVisibleMatrix = String.valueOf(matricePage.contains(titleText));

        List<WebElement> nvm = BasicRunner.driver.findElements(By.tagName("li"));

        String actualNewVisibleMatrix = String.valueOf(nvm.get(nvm.size() - 1));

        Assert.assertEquals(actualNewVisibleMatrix, expectedNewVisibleMatrix);
    }
    //scenario 2
    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() {
        List<WebElement> matrices = BasicRunner.driver.findElements(By.xpath("//span/button"));

        //select random matrix
        for (WebElement m: matrices) {
            m.click();
            break;
        }
    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        //add
        //BasicRunner.matrixPage.testCaseInput.sendKeys("821");
        //BasicRunner.matrixPage.addTestCaseBtn.click();

        //remove
        List<WebElement> testCaseRemoveBtns = BasicRunner.driver
                .findElements(By.xpath("//ul[1]/li/button[text()= 'Remove']"));
        for (WebElement tcrbtns: testCaseRemoveBtns) {
            tcrbtns.click();
            break;
        }
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        BasicRunner.matrixPage.saveRequirementBtn.click();
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {

    }
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() {
        //add
        //BasicRunner.matrixPage.defectListInput.sendKeys("978");
        //BasicRunner.matrixPage.addDefectBtn.click();

        //remove
        List<WebElement> defectRemoveBtns = BasicRunner.driver
                .findElements(By.xpath("//ul[2]/li/button[text()= 'Remove']"));
        for (WebElement drbtns: defectRemoveBtns) {
            drbtns.click();
            break;
        }
    }

}

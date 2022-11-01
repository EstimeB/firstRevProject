package com.revature.stepimplementations.matrix;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.revature.runners.BasicRunner.driver;
import static com.revature.runners.BasicRunner.wait;

public class MatrixSteps {

    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[text()='Create A new Requirements Matrix']")));
        BasicRunner.matrixPage.createAMatrixBtn.click();
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        BasicRunner.matrixPage.matrixTitle.sendKeys("ProjectOne RTM");
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() {
        //write a user story
        BasicRunner.matrixPage.matrixUserStory.sendKeys("I want to be able to login to the web page.");

        WebElement[] priority = {BasicRunner.matrixPage.matrixHighPriority,
                BasicRunner.matrixPage.matrixMediumPriority,
                BasicRunner.matrixPage.matrixLowPriority};
        //to randomly select a priority
        for (WebElement p: priority) {
                p.click();
        }
        //write a note
        BasicRunner.matrixPage.matrixNote.sendKeys("This is a must!");
        //add requirement
        BasicRunner.matrixPage.addRequirementBtn.click();
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() {
        //create matrix
        //BasicRunner.matrixPage.createMatrixBtn.click();
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        try {
            BasicRunner.matrixPage.createMatrixBtn.click();
            Alert alert = wait.until((ExpectedCondition<Alert>) driver -> {
                try {
                    return driver.switchTo().alert();
                } catch (NoAlertPresentException e) {
                    return null;
                }
            });

            alert.accept();
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            /* Ignore */
        }
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws InterruptedException {

        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/matrices']")));

        driver.findElement(By.xpath("//a[@href='/matrices']")).click();

        String expectedNewVisibleMatrix = "ProjectOne RTM";

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul/li")));

        List<WebElement> nVisibleMatrix = BasicRunner.driver.findElements(By.xpath("//ul/li"));
        List liList = new ArrayList<>();
        String actualNewVisibleMatrix;

        for (WebElement nvm: nVisibleMatrix) {
            String liText = nvm.getText();
            liList.add(liText);
        }

        for (Object l: liList) {
            if (l.equals(expectedNewVisibleMatrix)) {
                actualNewVisibleMatrix = l.toString();
                Assert.assertEquals(actualNewVisibleMatrix, expectedNewVisibleMatrix);
                break;
            } else if (l.equals(liList.size()-1)) {
                actualNewVisibleMatrix = (String) l;
                Assert.assertEquals(actualNewVisibleMatrix, expectedNewVisibleMatrix);
            }
        }
    }
    //scenario 2
    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/matrices']")));

        driver.findElement(By.xpath("//a[@href='/matrices']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/button[text()='Show']")));
        List<WebElement> matrices = BasicRunner.driver.findElements(
                By.xpath("//span/button[text()='Show']"));

        //select random matrix
        for (WebElement m: matrices) {
            m.click();
            break;
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/button")));
        List<WebElement> editBtnList = BasicRunner.driver.findElements(
                By.xpath("//td/button"));
        String editBtnText;

        for (WebElement editbtn: editBtnList) {
                editbtn.click();
                break;
        }
    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        //add
        BasicRunner.matrixPage.testCaseInput.sendKeys("821");
        BasicRunner.matrixPage.addTestCaseBtn.click();

        BasicRunner.matrixPage.testCaseInput.sendKeys("811");
        BasicRunner.matrixPage.addTestCaseBtn.click();

        //remove
//        List<WebElement> testCaseRemoveBtns = BasicRunner.driver
//                .findElements(By.xpath("//ul[1]/li/button[text()= 'Remove']"));
//
//        for (WebElement tcrbtns: testCaseRemoveBtns) {
//            tcrbtns.click();
//            break;
//        }
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        BasicRunner.matrixPage.saveRequirementBtn.click();
    }
    @Then("Then the changes to the defects should saved")
    public void then_the_changes_to_the_defects_should_saved() {

        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/matrices']")));

        driver.findElement(By.xpath("//a[@href='/matrices']")).click();

        WebElement num1 = driver.findElement(By.xpath("//li[text()='821']"));
        WebElement num2 = driver.findElement(By.xpath("//li[text()='811']"));
        int[] actualDefectIdsInserted = {Integer.parseInt(num1.getText()),
                Integer.parseInt(num2.getText())};
        int[] expectedResult = {821, 811};

        Assert.assertEquals(actualDefectIdsInserted, expectedResult);

    }
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() {
        //add
        BasicRunner.matrixPage.defectInput.sendKeys("978");
        BasicRunner.matrixPage.addDefectBtn.click();
        BasicRunner.matrixPage.defectInput.sendKeys("968");
        BasicRunner.matrixPage.addDefectBtn.click();

        //to randomly remove a test case
//        List<WebElement> defectRemoveBtns = BasicRunner.driver
//                .findElements(By.xpath("//ul[2]/li/button[text()= 'Remove']"));
//        for (WebElement drbtns: defectRemoveBtns) {
//            drbtns.click();
//            break;
//        }

        //remove a specific test case
        WebElement num = driver.findElement(By.xpath("//li[text()='978']/button[text()='Remove']"));
        num.click();
    }
    @Then("Then the changes to the test cases should saved")
    public void then_the_changes_to_the_test_cases_should_saved() {
        List<WebElement> testCaseIds = driver.findElements(By.xpath("//ul/li"));
        int res;
        int actualResult;
        int expectedResult = 0;

        for (WebElement tcid: testCaseIds) {
            res = Integer.parseInt(tcid.getText());
            if (res == 978) {
                actualResult = res;
                Assert.assertEquals(actualResult, expectedResult);
                break;
            } else {
                actualResult = 0;
                Assert.assertEquals(actualResult, expectedResult);
            }
        }
    }

}

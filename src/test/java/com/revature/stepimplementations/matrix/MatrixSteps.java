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
        for (WebElement p : priority) {
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
    public void the_matrix_should_be_visible_for_all_testers_and_managers() throws ClassCastException {

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
        List<Object> liList = new ArrayList<>();
        Object actualNewVisibleMatrix;

        for (WebElement nvm : nVisibleMatrix) {
            String liText = nvm.getText();
            liList.add(liText);
        }

        for (Object l : liList) {
            if (l.equals(expectedNewVisibleMatrix)) {
                actualNewVisibleMatrix = l.toString();
                Assert.assertEquals(actualNewVisibleMatrix, expectedNewVisibleMatrix);
                break;
            } else if (l.equals(liList.size() - 1)) {
                actualNewVisibleMatrix = l;
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
        for (WebElement m : matrices) {
            m.click();
            break;
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/button")));
        List<WebElement> editBtnList = BasicRunner.driver.findElements(
                By.xpath("//td/button"));
        String editBtnText;

        for (WebElement editbtn : editBtnList) {
            editbtn.click();
            break;
        }
    }

    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_Test_Cases() {
        //add
        BasicRunner.matrixPage.testCaseInput.sendKeys("821");
        BasicRunner.matrixPage.addTestCaseBtn.click();

        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        try {
            BasicRunner.matrixPage.saveRequirementBtn.click();
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

    @Then("Then the changes to the test cases should saved")
    public void then_the_changes_to_the_test_cases_should_saved() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='collapsible-content-1667345545715']/div/ul[1]/li")));
        List<WebElement> testCaseIds = BasicRunner.driver.findElements(
                By.xpath("//*[@id='collapsible-content-1667345545715']/div/ul[1]/li"));

        String n1 = "821";
        String tcText;
        List<Object> actualSavedTestCaseIds = new ArrayList<>();

        for (WebElement tcid : testCaseIds) {

            tcText = tcid.getText();

            if (tcText.equals(n1)) {
                actualSavedTestCaseIds.add(tcid);
                break;
            }
        }

        Object expectedResult = "821";

        Assert.assertEquals(actualSavedTestCaseIds, expectedResult);
    }

    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        //BasicRunner.matrixPage.saveRequirementBtn.click();
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        try {
            BasicRunner.matrixPage.saveRequirementBtn.click();
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

    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        //add
        BasicRunner.matrixPage.defectInput.sendKeys("978");
        BasicRunner.matrixPage.addDefectBtn.click();
        BasicRunner.matrixPage.defectInput.clear();
        BasicRunner.matrixPage.defectInput.sendKeys("968");
        BasicRunner.matrixPage.addDefectBtn.click();

        /////
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        try {
            BasicRunner.matrixPage.saveRequirementBtn.click();
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

        //below are steps in removing a defect
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//h3[contains(text(), 'Defect IDs')]/following::button[text()= 'Remove']")));
        List<WebElement> removeBtns = BasicRunner.driver.findElements(
                By.xpath("//h3[contains(text(), 'Defect IDs')]/following::button[text()= 'Remove']"));
        String rbtnTetxt;


        //loop through to remove a specific test case (968)
        for (WebElement rbtn: removeBtns) {
            rbtnTetxt = rbtn.getText();
            if (rbtnTetxt.equals("968")) {
                if (wait == null) {
                    wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                }

                try {
                    rbtn.click();
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
        }
    }

    @Then("Then the changes to the defects should saved")
    public void then_the_changes_to_the_defects_should_saved() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//*[@id='collapsible-content-1667345545715']/div/ul[2]/li")));
        List<WebElement> defectIds = BasicRunner.driver.findElements(
                By.xpath("//*[@id='collapsible-content-1667345545715']/div/ul[2]/li"));

        String n1 = "968";
        String didText;
        List<Object> actualDeletedDefect = new ArrayList<>();

        for (WebElement did : defectIds) {
            didText = did.getText();
            if (didText.equals(n1)) {
                actualDeletedDefect.add(did);
                break;
            }
        }

        Assert.assertEquals(actualDeletedDefect, null);
    }
}

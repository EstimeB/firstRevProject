package com.revature.stepimplementations.navigation;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NavigationSteps {

    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        BasicRunner.repetitiveMLSoC.managerLogin();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException {
        Thread.sleep(1000);
        String actualPage = BasicRunner.driver.getCurrentUrl();
        String expectedPage = "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome";

        Assert.assertEquals(actualPage, expectedPage);
    }
    @Then("The manager should see links for {string}, {string}, {string} and {string}")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview(
            String matrice, String testCase, String reportADefect, String defectOverview) {
        String[] actualLinks = {String.valueOf(BasicRunner.loginPage.matricesLink.getText()),
                String.valueOf(BasicRunner.loginPage.testCasesLink.getText()),
                String.valueOf(BasicRunner.loginPage.reportADefectLink.getText()),
                String.valueOf(BasicRunner.loginPage.defectOverviewLink.getText())};
        String[] expectedLinks = {matrice, testCase, reportADefect, defectOverview};

        Assert.assertEquals(actualLinks, expectedLinks);
    }

    //scenario 2
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        BasicRunner.loginPage.matricesLink.click();
    }
    @Then("The title of the page should be {string} page")
    public void the_title_of_the_page_should_be_matrix_page(String expectedPageTitle) throws InterruptedException { String titleText = BasicRunner.driver.getTitle().trim();
        String actualPageTitle = BasicRunner.driver.getTitle().replaceFirst(" Dashboard", "");

        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        BasicRunner.driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page has {string} in the tile")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_has_home_in_the_tile(String expectedTitle) {
        String actualTitle = BasicRunner.driver.getTitle().replaceFirst("Manager ", "");

        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        BasicRunner.loginPage.testCasesLink.click();
    }

    //scenario 3
    @When("The manager clicks on {string}")
    public void the_manager_clicks_on(String link) {
        if (link.equals(BasicRunner.loginPage.matricesLink.getText())) {
            BasicRunner.loginPage.matricesLink.click();
        }
        if (link.equals(BasicRunner.loginPage.testCasesLink.getText())) {
            BasicRunner.loginPage.testCasesLink.click();
        }
        if (link.equals(BasicRunner.loginPage.reportADefectLink.getText())) {
            BasicRunner.loginPage.reportADefectLink.click();
        }
        if (link.equals(BasicRunner.loginPage.defectOverviewLink.getText())) {
            BasicRunner.loginPage.defectOverviewLink.click();
        }
    }
    @Then("The title of page should be {string}")
    public void the_title_of_page_should_be(String expectedTitle) {
        String actualTitle = BasicRunner.driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}

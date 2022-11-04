package com.revature.stepimplementations.login;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PositiveLoginSteps {

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        BasicRunner.driver.get("https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2");
    }
    @When("The employee types {string} into username input")
    public void the_employee_types_username_into_username_input(String username) {
        BasicRunner.loginPage.usernameIput.sendKeys(username);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_password_into_password_input(String password) {
        BasicRunner.loginPage.passwordInput.sendKeys(password);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        BasicRunner.loginPage.loginbutton.click();
    }
    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_role_page(String expectedPageRole) throws InterruptedException {
        Thread.sleep(1000);
        String actualPageRole = BasicRunner.driver.getTitle().trim().replaceFirst("Home", "");
        Assert.assertEquals(actualPageRole, expectedPageRole);
    }
    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_fname_lname_on_the_home_page(String expectedEmpFName, String expectedEmpLName) throws InterruptedException {
        Thread.sleep(1000);

        String nameString = BasicRunner.loginPage.name.getText();
        String split[] = nameString.split(" ", 0);

        String actualEmpFName = split[1];
        String actualEmpLName = split[2];
        String actualEmpName = actualEmpFName + " " + actualEmpLName;

        String expectedEmpName = expectedEmpFName + " "  + expectedEmpLName;

        Assert.assertEquals(actualEmpName, expectedEmpName);
    }

}

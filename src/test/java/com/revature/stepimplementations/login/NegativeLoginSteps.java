package com.revature.stepimplementations.login;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NegativeLoginSteps {

    //Negative login Scenario 1
    @When("The employee types in {string} into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input(String username) {
        BasicRunner.loginPage.usernameIput.sendKeys(username);
    }
    @When("The employee types in {string} into the password input")
    public void the_employee_types_in_chomp_into_the_password_input(String password) {
        BasicRunner.loginPage.passwordInput.sendKeys(password);
    }

    //Negative login Scenario 2
    @Then("The employee should see an alert saying {string}")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found(String expectedAlert) throws InterruptedException {
        Thread.sleep(1000);
        String actualAlert = BasicRunner.driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlert, expectedAlert);
    }
}

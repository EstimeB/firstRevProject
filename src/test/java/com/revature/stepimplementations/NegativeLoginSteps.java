package com.revature.stepimplementations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NegativeLoginSteps {

    //Negative login Scenario 1
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {

    }
    @When("The employee types in chomp! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {

    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {

    }
    //Negative login Scenario 2
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {

    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {

    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {

    }

}

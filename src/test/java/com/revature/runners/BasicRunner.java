package com.revature.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "classpath:features", glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {

}

package com.revature.runners;

import com.revature.pages.LoginPage;
import com.revature.pages.MatrixPage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//will link the feature files to the step implementation classes
@CucumberOptions(features = "classpath:features",
        glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;
    public static LoginPage loginPage;

    public static MatrixPage matrixPage;

    //methods bellow are used to reduce redundancy
    @BeforeMethod
    public void setup() {

        //will download & configure the browser driver
        WebDriverManager.edgedriver().setup();

        //create a new instance/object of the browser driver
        //to open and control the browser
        driver = new EdgeDriver();

        //an instance/object of the page class that locate
        // & initialize the web elements, passing in ...
        loginPage = new LoginPage(driver);

        matrixPage= new MatrixPage(driver);
    }

    //will run after each Cucumber scenario to close the driver
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}

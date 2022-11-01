package com.revature.runners;

import com.revature.pages.LoginPage;
import com.revature.pages.MatrixPage;
import com.revature.pages.TestCasePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

//will link the feature files to the step implementation classes
@CucumberOptions(features = "classpath:features",
        glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {

    public static WebDriver driver;

    public static WebDriverWait wait;
    public static LoginPage loginPage;

    public static MatrixPage matrixPage;

    public static TestCasePage testCasePage;

    //methods bellow are used to reduce redundancy
    @BeforeMethod
    public void setup() {

        //will download & configure the browser driver
        WebDriverManager.edgedriver().setup();

        //create a new instance/object of the browser driver
        //to open and control the browser
        driver = new EdgeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //an instance/object of the page class that locate
        // & initialize the web elements, passing in ...
        loginPage = new LoginPage(driver);

        matrixPage = new MatrixPage(driver);

        testCasePage = new TestCasePage(driver);
    }

    //will run after each Cucumber scenario to close the driver
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}

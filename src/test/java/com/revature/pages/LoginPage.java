package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This class will be used to reduce redundancy
public class LoginPage {

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameIput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginbutton;

    @FindBy(xpath = "//nav/p")
    public WebElement name;

    @FindBy(xpath = "//a[@href='/matrices']")
    public WebElement matricesLink;

    @FindBy(xpath = "//a[@href='/testcases']")
    public WebElement testCasesLink;

    @FindBy(xpath = "//a[@href='/defectreporter']")
    public WebElement reportADefectLink;

    @FindBy(xpath = "//a[@href='/defectoverview']")
    public WebElement defectOverviewLink;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    ////
    @FindBy(xpath = "//button[text()='Create A new Requirements Matrix']")
    public WebElement createAMatrixBtn;

    @FindBy(xpath = "//input[@name='title']")
    public WebElement matrixTitle;

    @FindBy(xpath = "//input[@placeholder='User Story']")
    public WebElement matrixUserStory;

    @FindBy(xpath = "//select/option[@value='Low']")
    public WebElement matrixLowPriority;

    @FindBy(xpath = "//select/option[@value='Medium']")
    public WebElement matrixMediumPriority;

    @FindBy(xpath = "//select/option[@value='High']")
    public WebElement matrixHighPriority;

    @FindBy(xpath = "//input[@placeholder='Note']")
    public WebElement matrixNote;

    @FindBy(xpath = "//button[text()='Add Requirement']")
    public WebElement addRequirementBtn;

    @FindBy(xpath = "//button[text()='Create Matrix']")
    public WebElement createMatrixBtn;

    @FindBy(xpath = "//ul/li/input[@list='testlist']")
    public WebElement testCaseInput;

    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::button[text()= 'Add'][1]")
    public WebElement addTestCaseBtn;

//    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::button[1]")
//    public WebElement removeTestCaseBtn;

    @FindBy(xpath = "//ul/li/input[@list='defectlist']")
    public WebElement defectInput;

    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::button[2]")
    public WebElement addDefectBtn;

    @FindBy(xpath = "//div/button[text()='Save Requirements']")
    public WebElement saveRequirementBtn;

}

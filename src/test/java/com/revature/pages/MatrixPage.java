package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatrixPage {

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

    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::input[@list= 'testlist']")
    public WebElement testCaseInput;

    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::button[text()= 'Add'][1]")
    public WebElement addTestCaseBtn;

//    @FindBy(xpath = "//h3[contains(text(), 'Test Case IDs')]/following::button[1]")
//    public WebElement removeTestCaseBtn;

    @FindBy(xpath = "//h3[contains(text(), 'Defect IDs')]/following::input[@list= 'defectlist']")
    public WebElement defectInput;

    @FindBy(xpath = "//h3[contains(text(), 'Defect IDs')]/following::button[text()= 'Add'][1]")
    public WebElement addDefectBtn;

    @FindBy(xpath = "//div/button[text()='Save Requirements']")
    public WebElement saveRequirementBtn;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editMatrice;

    public MatrixPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

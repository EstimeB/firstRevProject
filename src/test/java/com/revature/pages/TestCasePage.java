package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasePage {

    @FindBy(name = "desc")
    public WebElement descriptionTextArea;

    @FindBy(name = "steps")
    public WebElement stepsTextArea;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement testCaseSubmitBtn;

    @FindBy(xpath = "//*[@id='root']/table/tbody/tr/td[text()='Verify that usernames cannot have illegal characters']/following::button[text()='Details']")
    public WebElement detailsBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement closeButton;

    @FindBy(xpath = "//button/a[@href='/caseeditor/801']")
    public WebElement editButton;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement automateCheckMark;

    //@FindBy()
    //public WebElement selectTesterBtn; //select elements, add into array, then loop through to select randomly

    //@FindBy()
    //public WebElement selectTestResultBtn;

    @FindBy(xpath = "//textarea[text()='No issues']")
    public WebElement summaryTextArea;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement testCaseSaveBtn;

    public TestCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

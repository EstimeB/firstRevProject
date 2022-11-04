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

    @FindBy(xpath = "//tr[last()]/td[4]")
    public WebElement detailsBtn;

    @FindBy(xpath = "/html/body/div[3]/div/div/button[1]")
    public WebElement closeButton;

    @FindBy(xpath = "//button/a[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editBtn;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement automateCheckMark;

    @FindBy(xpath = "//fieldset[2]/textarea")
    public WebElement summaryTextArea;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement testCaseSaveBtn;

    public TestCasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

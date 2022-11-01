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

}

package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//This class will be used to reduce redundancy
public class LoginPage {

    @FindBy
    public WebElement username;

    @FindBy
    public WebElement password;

    @FindBy
    public WebElement loginbutton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}

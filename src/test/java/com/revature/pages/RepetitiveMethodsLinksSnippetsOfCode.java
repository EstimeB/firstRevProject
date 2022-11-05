package com.revature.pages;

import com.revature.runners.BasicRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepetitiveMethodsLinksSnippetsOfCode {

    public String loginPage = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=2";

    public void managerLogin() {
        BasicRunner.driver.get(BasicRunner.repetitiveMLSoC.loginPage);
        BasicRunner.loginPage.usernameIput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginbutton.click();
    }

    public RepetitiveMethodsLinksSnippetsOfCode(WebDriver driver) {

    }

}

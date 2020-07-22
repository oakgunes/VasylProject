package com.weborders.pages;

import com.weborders.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy(id = "ctl00_MainContent_username")
    private WebElement userNameElement;

    @FindBy(id = "ctl00_MainContent_password")
    private WebElement passwordElement;

    public void login(String userName, String password){ //we need a constructor because of java and pagefactory
        //will be inhertied
        wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password, Keys.ENTER);
    }


    public void login(){
        String userName = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");
        //this explicit wait
        wait.until(ExpectedConditions.visibilityOf(userNameElement)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(passwordElement)).sendKeys(password, Keys.ENTER);
    }
}
//explicit wait only one time and begining of the test ,used before findelement methods called whenever
// we have page but does not have any documents webdriver showed nonullsuch Exceptiom for exp explict time 10 second
//webdriver wait 10 seconds (documents can be-recourse-file)  excplitict wait onlt for element


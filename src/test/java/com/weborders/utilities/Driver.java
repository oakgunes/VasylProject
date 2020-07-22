package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver;
    private Driver(){  //we are making constructor private because we want to make sure noone can create the obj
       // Driver driver = new Driver(); //means that obj does not necessary because we dont want or anyone can create the obj
    }
    //this method we need whenever we need an obj
    public static WebDriver getDriver(){  //we are creating the setter to read the private data with sattic again
        String browser = ConfigurationReader.getProperty("browser"); //will go to C.R class to get browser
        if (driver == null) {
            switch (browser) {
                case "chrome":
                case "CHROME":
                case "chrome-browser":
                case "Chrome":
                    WebDriverManager.chromedriver().setup(); //here will connect to chromedriver
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }
    //this method we need to close so will be end the end of each test
    public static void closeDriver() { //if this browser exist not null
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
//if you want to send any comment the only one subject
//singlrton will create oly one object for test but we will use for
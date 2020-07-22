package com.weborders;

public class OHNotes_day7_8 {
}
/*
ffice hours:
​
  Agenda:
      - Create a project for web orders website
      - Automate basic test case where user has to create order and verify that order is saved.
​
  Scenario: 1. Create order
    Given user is on the login page
    And user logs in
    And user navigates to "Order" page
    When user enters product information:
      | Product     | Quantity | Price per unit | Discount |
      | ScreenSaver | 12       | 20             | 10%      |
    And user click on calculate button
    Then user should verify that total 216 is displayed
    When user enters address information:
      | Customer name | Street  | City     | State    | Zip   |
      | Test User     | 5th Ave | New York | New York | 10011 |
    And user enters payment information:
      | Card | Card Nr:    | Expire date (mm/yy) |
      | Visa | 12345667890 | 04/25               |
    And user click on process button
    And user navigates to "View all orders" page
    Then user verifies that order is displayed
      | Name      | Product     |
      | Test User | ScreenSaver |
​
Step 1. Create maven project for WebOrders application
​
   artifact id: WebOrdersAutomationSpring2020
   group id: com.automation
​
Step 2. Create .gitignore file and add following content into it:
​
right click on project name --> new --> file --> .gitignore
​
    .idea
    target
    *.iml
​
Step 3. Create configuration.properties file with following content:
​
​
browser=chrome
url=http://secure.smartbearsoftware.com/samples/testcomplete12/weborders
username=Tester
password=test
​
​
* make sure, values don't contain spaces
​
​
Step 4. Add dependencies to pom.xml file
​
​
use (MAC) command + option + L to rearrange code, for windows control + alt + L
​
​
Step 5. Under utilities create:
- ConfigurationReader class
​
    public class ConfigurationReader {
​
      private static Properties properties;
​
      static {
          try (FileInputStream fileInputStream = new FileInputStream("configuration.properties")) {
              properties = new Properties();
              properties.load(fileInputStream);
          } catch (IOException e) {
              e.printStackTrace();
              throw new RuntimeException("Unable to find configuration.properties file!");
          }
      }
​
      public static String getProperty(String key) {
          return properties.getProperty(key);
      }
  }
​
- Driver class:
​
  public class Driver {
    private static WebDriver driver;
​
    private Driver() {
​
    }
​
    public static WebDriver getDriver() {
        String browser = ConfigurationReader.getProperty("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome":
                case "CHROME":
                case "chrome-browser":
                case "Chrome":
                    WebDriverManager.chromedriver().setup();
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
​
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
​
}
​
Step 6: Create pages package
​
Step 7: Create BasePage class:
​
    public abstract class BasePage {
​
        public BasePage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }
Step 8: Create login page class:
​
  public class LoginPage extends BasePage {

  }


 */
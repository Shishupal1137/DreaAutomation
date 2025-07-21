package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set path to chromedriver if needed
        driver = new ChromeDriver();
        Reporter.log("Browser launched successfully", true);
    }

    @Test
    public void openGoogleHomePage() {
        driver.get("https://www.google.com");
        Reporter.log("Navigated to Google.com", true);

        String title = driver.getTitle();
        Reporter.log("Page title is: " + title, true);
    }

    @Test
    public void searchSeleniumTestNG() {
        driver.get("https://www.google.com");
        Reporter.log("Opened Google for search test", true);

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium TestNG Tutorial");
        Reporter.log("Entered search text: 'Selenium TestNG Tutorial'", true);

        searchBox.submit();
        Reporter.log("Search submitted", true);
    }

  /*  @Test
    public void verifyFooterLinks() {
        driver.get("https://www.google.com");
        Reporter.log("Google home opened for footer check", true);

        boolean isFooterDisplayed = driver.findElement(By.id("fsl")).isDisplayed();
        Reporter.log("Footer section is displayed: " + isFooterDisplayed, true);
    }*/

    @AfterClass
    public void tearDown() {
        driver.quit();
        Reporter.log("Browser closed after test execution", true);
    }
}

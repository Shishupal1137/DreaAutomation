package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Allure {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    public void logoPresence() throws InterruptedException {
        Thread.sleep(3000); // Optional for demo; better to use WebDriverWait
        WebElement logo = driver.findElement(By.xpath("//img[@alt = 'company-branding']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed on the login page.");
    }

    @Test(priority = 2)
    public void loginTest() {
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        // Wait and then verify login success (by checking some element after login or URL)
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed or Dashboard not loaded.");
    }

    @Test(priority = 3)
    public void registration() {
        throw new SkipException("Skipping registration test - not implemented.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

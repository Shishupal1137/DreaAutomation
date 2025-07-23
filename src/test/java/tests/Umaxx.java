package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class Umaxx {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://test-umaxx-tv.herokuapp.com/");

        // Open menu and navigate to login
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@id='nav-link-1']")).click();
        Thread.sleep(2000);

        // Enter credentials
        driver.findElement(By.xpath("(//input[@type='email'])[1]"))
              .sendKeys("chetana1.workfh@gmail.com");
        driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]"))
              .sendKeys("Himani2023");

        // Pause for manual CAPTCHA
        System.out.println("⏳ Please solve the CAPTCHA manually in the browser...");

        // Wait for Login button, then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']"))
        );
        loginButton.click();
        System.out.println("✅ CAPTCHA solved. Login button clicked.");

        // Click “View Details”
        WebElement viewDetails = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Details']"))
        );
        viewDetails.click();
        System.out.println("✅ Successfully clicked on View Details");

        // Wait for details section to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Email']")));

        // Expected values
        String expectedEmail        = "chetana1.workfh@gmail.com";
        String expectedFirstName    = "Himani";
        String expectedLastName     = "sharma";
        String expectedStatus       = "Payment Done";
        String expectedSubscription = "Unsubscribe All";

        // Validate Email
        WebElement emailElement = driver.findElement(
            By.xpath("//*[text()='Email']/following-sibling::*")
        );
        String actualEmail = emailElement.getText().trim();
        System.out.println("Email: " + actualEmail);
        assert actualEmail.equals(expectedEmail) : "❌ Email mismatch!";

        // Validate First Name
        WebElement firstNameElement = driver.findElement(
            By.xpath("//*[text()='First Name']/following-sibling::*")
        );
        String actualFirstName = firstNameElement.getText().trim();
        System.out.println("First Name: " + actualFirstName);
        assert actualFirstName.equals(expectedFirstName) : "❌ First name mismatch!";

        // Validate Last Name
        WebElement lastNameElement = driver.findElement(
            By.xpath("//*[text()='Last Name']/following-sibling::*")
        );
        String actualLastName = lastNameElement.getText().trim();
        System.out.println("Last Name: " + actualLastName);
        assert actualLastName.equals(expectedLastName) : "❌ Last name mismatch!";

        // Scroll window down by 500px
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("window.scrollBy(0, 500);");
        Thread.sleep(1000);
        System.out.println("⬇️ Window scrolled down by 500 pixels.");

        // Validate Payment Status
        WebElement statusElement = driver.findElement(
            By.xpath("//*[text()='Status']/following-sibling::*")
        );
        String actualStatus = statusElement.getText().trim();
        System.out.println("Status: " + actualStatus);
        assert actualStatus.equals(expectedStatus) : "❌ Payment status mismatch!";

        // Validate presence of “Unsubscribe All” link (no click)
        By unsubscribeLocator = By.xpath(
            "//a[@data-method='get' and contains(@href,'/unsubscribe') and normalize-space(text())='Unsubscribe All']"
        );
        WebElement unsubscribeElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(unsubscribeLocator)
        );
        assert unsubscribeElement.isDisplayed() : "❌ Unsubscribe link is not displayed!";
        String actualSubscription = unsubscribeElement.getText().trim();
        System.out.println("Subscription Link Text: " + actualSubscription);
        assert actualSubscription.equals(expectedSubscription) : "❌ Subscription text mismatch!";

        System.out.println("✅ All validations passed successfully.");

        driver.quit();
    }
}



package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Validation {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://test-umaxx-tv.herokuapp.com/");

       
        String actualTitle = driver.getTitle();

        
        String expectedTitle = "UMAXX TV";  // Replace this with the real title of the page

        // Assert validation
       // Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");

        // Example interaction
        driver.findElement(By.xpath("(//img[@alt = 'UMAXX'])[1]//following::span[1]")).click();
        
        Thread.sleep(5000);

        driver.quit();
    }
}

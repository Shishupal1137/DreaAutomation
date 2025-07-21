package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DreamTotalPage {
    private WebDriver driver;
    
    public DreamTotalPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Locators
    private By goodDreams = By.id("goodDreamsCount");
    private By badDreams = By.id("badDreamsCount");
    private By totalDreams = By.id("totalDreamsCount");
    private By recurringDreams = By.id("recurringDreamsCount");
    private By recurringList = By.cssSelector("#recurringDreamsList li");
    
    public int getGoodDreamsCount() {
        return Integer.parseInt(driver.findElement(goodDreams).getText());
    }
    
    public int getBadDreamsCount() {
        return Integer.parseInt(driver.findElement(badDreams).getText());
    }
    
    public int getTotalDreamsCount() {
        return Integer.parseInt(driver.findElement(totalDreams).getText());
    }
    
    public int getRecurringDreamsCount() {
        return Integer.parseInt(driver.findElement(recurringDreams).getText());
    }
    
    public boolean verifyRecurringDreamsExist(String dreamName) {
        List<WebElement> dreams = driver.findElements(recurringList);
        for (WebElement dream : dreams) {
            if (dream.getText().contains(dreamName)) {
                return true;
            }
        }
        return false;
    }
}
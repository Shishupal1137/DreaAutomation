package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String mainWindow; // Store main window handle as instance variable
    
    // Locators
    private final By loadingAnimation = By.id("loading-animation");
    private final By mainContent = By.id("main-content");
    private final By myDreamsButton = By.id("my-dreams-btn");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void navigateTo() {
        driver.get("https://arjitnigam.github.io/myDreams/index.html");
        mainWindow = driver.getWindowHandle(); // Initialize main window
        waitForLoadingToComplete();
    }
    
    public void waitForLoadingToComplete() {
        // Wait for animation to be visible first
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingAnimation));
        
        // Then wait for it to disappear within 3 seconds
        wait.withTimeout(Duration.ofSeconds(3))
            .until(ExpectedConditions.invisibilityOfElementLocated(loadingAnimation));
    }
    
    public boolean isMainContentVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mainContent))
                   .isDisplayed();
    }
    
    public boolean isMyDreamsButtonVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(myDreamsButton))
                   .isDisplayed();
    }
    
    public void clickMyDreamsButton() {
        driver.findElement(myDreamsButton).click();
        
        // Wait for new windows to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
    }
    
    public boolean verifyNewTabsOpened() {
        // Get all window handles
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        
        // Remove main window from the list
        handles.remove(mainWindow);
        
        if (handles.size() != 2) {
            return false;
        }
        
        boolean foundDiary = false;
        boolean foundTotal = false;
        
        // Check both new tabs
        for (String handle : handles) {
            driver.switchTo().window(handle);
            String url = driver.getCurrentUrl();
            
            if (url.endsWith("dreams-diary.html")) {
                foundDiary = true;
            } else if (url.endsWith("dreams-total.html")) {
                foundTotal = true;
            }
        }
        
        // Return to main window
        driver.switchTo().window(mainWindow);
        
        return foundDiary && foundTotal;
    }
}
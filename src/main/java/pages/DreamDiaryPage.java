package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DreamDiaryPage {
    private final WebDriver driver;
    
 
    private final By table = By.cssSelector("table");
    private final By headerRow = By.cssSelector("thead tr");
    private final By dataRows = By.cssSelector("tbody tr");
    private final By dreamNameCol = By.cssSelector("td:first-child");
    private final By daysAgoCol = By.cssSelector("td:nth-child(2)");
    private final By dreamTypeCol = By.cssSelector("td:last-child");
    
    public DreamDiaryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void navigateTo() {
        driver.get("https://arjitnigam.github.io/myDreams/dreams-diary.html");
        waitForPageLoad();
    }
    
    private void waitForPageLoad() {
      
        if (!driver.findElements(table).isEmpty()) {
            driver.findElement(headerRow); // Wait for header
        }
    }
    
    public int getDreamEntryCount() {
        return driver.findElements(dataRows).size();
    }
    
    public boolean verifyAllDreamTypesValid() {
        List<WebElement> rows = driver.findElements(dataRows);
        for (WebElement row : rows) {
            String type = row.findElement(dreamTypeCol).getText().trim();
            if (!type.equals("Good") && !type.equals("Bad")) {
                System.out.println("Invalid dream type found: " + type);
                return false;
            }
        }
        return true;
    }
    
    public boolean verifyAllRowsFilled() {
        List<WebElement> rows = driver.findElements(dataRows);
        for (WebElement row : rows) {
            if (row.findElement(dreamNameCol).getText().isBlank() ||
                row.findElement(daysAgoCol).getText().isBlank() ||
                row.findElement(dreamTypeCol).getText().isBlank()) {
                System.out.println("Empty cell found in row: " + row.getText());
                return false;
            }
        }
        return true;
    }
    
    public boolean isRecurringDream(String dreamName) {
        List<WebElement> names = driver.findElements(dreamNameCol);
        int count = 0;
        for (WebElement nameElement : names) {
            if (nameElement.getText().trim().equals(dreamName)) {
                count++;
                if (count > 1) return true;
            }
        }
        return false;
    }
}
package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import java.time.Duration;

public class NewTest {

    WebDriver driver;

    public void openAndUpdatePage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://test-umaxx-tv.herokuapp.com/");
        Reporter.log("✅ Launched Home Page", true);
        System.out.println("✅ Launched Home Page");

        driver.get("https://test-umaxx-tv.herokuapp.com/finance/error");
        Reporter.log("✅ Navigated to Finance Error Page", true);
        System.out.println("✅ Navigated to Finance Error Page");
    }

    public void clickPlanSectionLink() {
        String xpath = "//div[@id='plan-section']//div[4]//div[2]//div[3]//a[1]";
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);
            element.click();
            Reporter.log("✅ Clicked Plan Section link", true);
            System.out.println("✅ Clicked Plan Section link");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click Plan Section link: " + e.getMessage(), true);
            System.out.println("❌ Failed to click Plan Section link: " + e.getMessage());
        }
    }

    public void enterZipCode() {
        String xpath = "//input[@id='coverage-code']";
        try {
            WebElement input = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            input.clear();
            input.sendKeys("12345");
            Reporter.log("✅ Entered ZIP code: 12345", true);
            System.out.println("✅ Entered ZIP code: 12345");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter ZIP code: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter ZIP code: " + e.getMessage());
        }
    }

    public void clickGoButton() {
        String xpath = "(//button[normalize-space()='GO'])[1]";
        try {
            WebElement goButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            goButton.click();
            Reporter.log("✅ Clicked 'GO' button", true);
            System.out.println("✅ Clicked 'GO' button");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click 'GO' button: " + e.getMessage(), true);
            System.out.println("❌ Failed to click 'GO' button: " + e.getMessage());
        }
    }

    public void clickProductIds32Button() {
        String xpath = "(//button[@id='product-ids-32-full'])[1]";
        try {
            WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(500);
            button.click();
            Reporter.log("✅ Clicked product button", true);
            System.out.println("✅ Clicked product button");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click product button: " + e.getMessage(), true);
            System.out.println("❌ Failed to click product button: " + e.getMessage());
        }
    }

    public void clickContinueButton() {
        String xpath = "//div[@class='modal-footer py-2']//button[@id='product-ids-32-full']";
        try {
            WebElement continueButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);
            Thread.sleep(500);
            continueButton.click();
            Reporter.log("✅ Clicked 'Continue' button in modal", true);
            System.out.println("✅ Clicked 'Continue' button in modal");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click 'Continue' button: " + e.getMessage(), true);
            System.out.println("❌ Failed to click 'Continue' button: " + e.getMessage());
        }
    }

    public void clickFinalContinueLink() {
        String xpath = "//a[normalize-space()='Continue']";
        try {
            WebElement continueLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            continueLink.click();
            Reporter.log("✅ Clicked final 'Continue' link", true);
            System.out.println("✅ Clicked final 'Continue' link");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click final 'Continue' link: " + e.getMessage(), true);
            System.out.println("❌ Failed to click final 'Continue' link: " + e.getMessage());
        }
    }

    public void enterEmailAddress() {
        String xpath = "(//input[@id='order_email'])[1]";
        try {
            WebElement email = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            email.sendKeys("tetst@gmail.com");
            Reporter.log("✅ Entered email", true);
            System.out.println("✅ Entered email");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter email: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter email: " + e.getMessage());
        }
    }

    public void enterPassword() {
        String xpath = "(//input[@id='order_password'])[1]";
        try {
            WebElement pass = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            pass.sendKeys("32abcgdd12");
            Reporter.log("✅ Entered password", true);
            System.out.println("✅ Entered password");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter password: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter password: " + e.getMessage());
        }
    }

    public void enterPhoneNumber() {
        String xpath = "(//input[@id='order_phone'])[1]";
        try {
            WebElement phone = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            phone.sendKeys("9876547698");
            Reporter.log("✅ Entered phone number", true);
            System.out.println("✅ Entered phone number");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter phone number: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter phone number: " + e.getMessage());
        }
    }

    public void enterFirstName() {
        String xpath = "//input[@id='order_first_name']";
        try {
            WebElement firstName = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            firstName.sendKeys("tttest");
            Reporter.log("✅ Entered first name", true);
            System.out.println("✅ Entered first name");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter first name: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter first name: " + e.getMessage());
        }
    }

    public void enterLastName() {
        String xpath = "//input[@id='order_last_name']";
        try {
            WebElement lastName = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            lastName.sendKeys("ddeemo");
            Reporter.log("✅ Entered last name", true);
            System.out.println("✅ Entered last name");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter last name: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter last name: " + e.getMessage());
        }
    }

    public void enterAddress() {
        String xpath = "//input[@id='order_address']";
        try {
            WebElement address = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            address.sendKeys("San Diego, CA, USA");
            Reporter.log("✅ Entered address", true);
            System.out.println("✅ Entered address");
        } catch (Exception e) {
            Reporter.log("❌ Failed to enter address: " + e.getMessage(), true);
            System.out.println("❌ Failed to enter address: " + e.getMessage());
        }
    }

    public void clickAcceptCheckbox() {
        String xpath = "(//input[@id='accept-checkbox'])[1]";
        try {
            WebElement checkbox = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (!checkbox.isSelected()) {
                checkbox.click();
                Reporter.log("✅ Clicked accept checkbox", true);
                System.out.println("✅ Clicked accept checkbox");
            }
        } catch (Exception e) {
            Reporter.log("❌ Failed to click accept checkbox: " + e.getMessage(), true);
            System.out.println("❌ Failed to click accept checkbox: " + e.getMessage());
        }
    }

    public void clickProceedToFinalStep() {
        String xpath = "(//button[normalize-space()='PROCEED TO FINAL STEP'])[1]";
        try {
            WebElement proceed = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", proceed);
            Thread.sleep(500);
            proceed.click();
            Reporter.log("✅ Clicked 'PROCEED TO FINAL STEP'", true);
            System.out.println("✅ Clicked 'PROCEED TO FINAL STEP'");
        } catch (Exception e) {
            Reporter.log("❌ Failed to click 'PROCEED TO FINAL STEP': " + e.getMessage(), true);
            System.out.println("❌ Failed to click 'PROCEED TO FINAL STEP': " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        NewTest test = new NewTest();
        test.openAndUpdatePage();
        test.clickPlanSectionLink();
        test.enterZipCode();
        test.clickGoButton();
        test.clickProductIds32Button();
        test.clickContinueButton();
        test.openAndUpdatePage();
        test.clickFinalContinueLink();
        test.enterEmailAddress();
        test.enterPassword();
        test.enterPhoneNumber();
        test.enterFirstName();
        test.enterLastName();
        test.enterAddress();
        test.clickAcceptCheckbox();
        test.clickProceedToFinalStep();
    }
}

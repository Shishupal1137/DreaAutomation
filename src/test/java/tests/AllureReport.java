package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllureReport {
	
	WebDriver driver;
	@BeforeClass
	public void setup() {
		  driver = new ChromeDriver(); // Initialize Chrome browser
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
	    	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    	        driver.manage().window().maximize();
			
		
	}
	
	
	
	@Test(priority = 1, enabled = false)

	  public void logoPresence() throws Exception {
		  
		boolean disstatus =  driver.findElement(By.xpath("//img[@alt = 'company-branding']")).isDisplayed();
		Thread.sleep(5000);
	     
		   Assert.assertEquals(disstatus, true);
	  }

	
	
	
  @Test(priority =2)
  public void loginTest() {
	  
	  driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("Admin");
	  
	  driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("admin123");
	  
	  driver.findElement(By.xpath("//button[text() = ' Login ']")).click();
	  
	// Assert.assertEquals(driver.getTitle(), "hello");
	  
	  
  }


@Test(priority =3, enabled = false)
public void registration() {
	
	throw new SkipException("Skipping this Test");
	
}

@AfterClass
public void tearDown() {
	
	driver.quit();
	
}


}
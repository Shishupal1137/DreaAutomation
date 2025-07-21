package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lauchingbrowser {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://arjitnigam.github.io/myDreams/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

	}

}

package application;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToApplication {
	private static WebDriver webDriver;
 
	@BeforeClass
	public static void launchApplication(){
		setChromeDriverProperty();
		webDriver = new ChromeDriver();
	}
 
	private static void setChromeDriverProperty(){
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
	}
}

package week2.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeafGround {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
//		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys(" Selenium Testing");
//        boolean enabled = driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled();
//        System.out.println(enabled);
        driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(0);
        driver.findElementByXPath("//button[@id='Click']").click();
        driver.switchTo().defaultContent();
        driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(1);
        driver.findElements(By.id("iframe2"));
        driver.switchTo().frame(0);
        driver.findElementByXPath("//button[@id='Click1']").click();
        driver.switchTo().defaultContent();
        List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
        int size = findElements.size();
        System.out.println(size);
      
	}
	

}

package projectExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("email").clear();
		driver.findElementById("email").sendKeys("mrnagasami@gmail.com");
		driver.findElementById("pass").sendKeys("652519N@g@");
		driver.findElementByXPath("//input[@value='Log In']").click();
		driver.findElementByXPath("(//input[@type='text'])[1]").sendKeys("testLeaf");
		driver.findElementByXPath("(//button[@type='submit'])[1]").click();
		Thread.sleep(3000);
//		driver.findElementByXPath("(//button[@type='submit' and contains(text(),'Like')])[1]//i").click();
		driver.findElementByLinkText("TestLeaf").click();
		String text = driver.findElementByXPath("//div[contains(text(),'people like this')]").getText();
		String text1 = text.replaceAll("[^0-9]", "");
		Integer likeNum = Integer.parseInt(text1);
		System.out.println("Total No of likes in Test Leaf ="+likeNum);
		
		
	}

}

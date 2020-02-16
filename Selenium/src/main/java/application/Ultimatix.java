package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ultimatix {
    
	@Test
	public static void ultiMatix() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("disable-notifications");
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.ultimatix.net");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("//input[@id='form1']").sendKeys("979929");
		driver.findElementByXPath("//button[@id='proceed-button']").click();
		driver.findElementByXPath("//button[@id='password-btn']").click();
		driver.findElementByXPath("//input[@id='password-login']").sendKeys("N@g@may2019");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//button[@id='form-submit']"))).click();
		driver.findElementByLinkText("Timesheet Entry").click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandle.get(1));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//table//td//div[@class='ng-binding selectedDate']/following-sibling::div)[1]")));
		boolean enabled = driver.findElementByXPath("//div[@class='showClass']//input").isEnabled();
		System.out.println(enabled);

	}

}

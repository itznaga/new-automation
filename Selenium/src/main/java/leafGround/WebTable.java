package leafGround;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://portaluat2.citidirect.com/portalservices/forms/login.pser?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("btnGo").click();
		driver.findElementById("VideoLink").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wdh = new ArrayList<String>(windowHandles);
		System.out.println(windowHandles);
		System.out.println(wdh.toString());
		driver.switchTo().window(wdh.get(0));
		driver.findElementByXPath("//a[contains(text(),'Terms & Conditions')]").click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> wdh1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(wdh1.get(2));
		driver.close();
		driver.switchTo().window(wdh1.get(1));
		driver.close();
		driver.switchTo().window(wdh1.get(0));
		driver.findElementById("imgLoginMethod").click();		
	}

}

package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Edit {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='Edit / Text Fields']").click();
		driver.findElementByXPath("(//input[@type='text'])[2]").sendKeys("asfasfd");
		String text = driver.findElementByXPath("(//input[@name='username'])[1]").getAttribute("value");
		System.out.println(text);
		boolean enabled = driver.findElementByXPath("(//input[@type='text'])[5]").isEnabled();
		System.out.println(enabled);
	}
}

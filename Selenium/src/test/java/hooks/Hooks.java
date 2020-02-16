package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import application.BasePage;
import cucumber.api.java.Before;

public class Hooks  {
	public static ChromeDriver driver = new ChromeDriver();
	@Before
	public void loginToEnv() throws InterruptedException
	{
		try {
			driver.get("https://portaluat.citidirect.com");
			driver.manage().window().maximize();
//			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.findElementByXPath("//a[@id='btnGo']").click();
		}catch(Exception e)
		{
			System.out.println("Navigating to Login Page failed because = "+e.getMessage());
		}
	}

}

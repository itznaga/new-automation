package leafGround;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='Radio Button']").click();
		List<WebElement> radioButtons = driver.findElementsByXPath("//input[@name='news']");
		for(WebElement radioButton : radioButtons)
		{
			boolean selected = radioButton.isSelected();
			if(selected)
			{
				System.out.println();
			}
		}

	}

}

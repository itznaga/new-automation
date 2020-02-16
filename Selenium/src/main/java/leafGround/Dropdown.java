package leafGround;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='ListBox']").click();
		WebElement dropDown1 = driver.findElementByXPath("//select[@id='dropdown1']");
		dropDown1.click();
		Select obj1 = new Select(dropDown1);
		obj1.selectByIndex(3);
		obj1.selectByVisibleText("Selenium");
		driver.findElementByXPath("//h1[@class='wp-heading']").click();
		WebElement dropdown2 = driver.findElementByXPath("//select[@class='dropdown']");
		dropDown1.click();
		Select obj2 = new Select(dropdown2);
		List<WebElement> options = obj2.getOptions();
		int size = options.size();
		System.out.println(size);
		WebElement dropDown3 = driver.findElementByXPath("(//div[@class='example'])[6]//select");
		Select obj3 = new Select(dropDown3);
		obj3.selectByValue("Selenium");
		

	}

}

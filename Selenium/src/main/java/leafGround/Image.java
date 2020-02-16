package leafGround;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='Images']").click();
		Dimension size = driver.findElementByXPath("(//label[@for='position']/following-sibling::img)[1]").getSize();
		System.out.println(size);
		
	}

}

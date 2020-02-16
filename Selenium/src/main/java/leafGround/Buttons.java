package leafGround;

import java.awt.Color;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Buttons {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='Buttons']").click();
		int x = driver.findElementById("position").getLocation().getX();
		System.out.println("X axis of Button is"+x);
		Point location = driver.findElementById("position").getLocation();
		System.out.println("Location of the element"+location);
		String cssValue = driver.findElementById("color").getCssValue("background-color");
////		int parseInt = Integer.parseInt(cssValue);
////		Color buttonColor = new Color(parseInt);
//		Color decode = Color.decode(cssValue);
//		System.out.println(decode);
		int size = driver.findElementById("size").getSize().width;
		System.out.println(size);

	}

}

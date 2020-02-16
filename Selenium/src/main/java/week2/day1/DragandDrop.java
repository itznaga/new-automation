package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(draggable, 168,168).perform();
		driver.switchTo().defaultContent();
		driver.findElementByLinkText("Sortable").click();
		driver.switchTo().frame(0);
		WebElement itemDrag = driver.findElementByXPath("((//li[@class='ui-state-default ui-sortable-handle']))[1]//span");
		WebElement target = driver.findElementByXPath("(//span[@class='ui-icon ui-icon-arrowthick-2-n-s'])[4]");
		int x = itemDrag.getLocation().getX();
		int y = target.getLocation().getY();
		builder.dragAndDropBy(itemDrag, x, y).perform();      
	}

}

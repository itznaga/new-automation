package week4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.findElementByXPath("(//span[@class='ng-star-inserted'])[1]").click();
		driver.findElementByLinkText("Contact Us").click();
		Set<String> openedWindows = driver.getWindowHandles();
		List<String> openWindows = new ArrayList<String>(openedWindows);
		System.out.println("Closed Window Title is "+ driver.getTitle());
		driver.switchTo().window(openWindows.get(0)).close();
		driver.switchTo().window(openWindows.get(1));
		driver.manage().window().maximize();
		System.out.println("Current Window Title is "+ driver.getTitle());
		File source1 = driver.getScreenshotAs(OutputType.FILE);
		File destiny1 = new File("./Snaps/irctc1.png");
		FileUtils.copyFile(source1, destiny1);
		
	}

}

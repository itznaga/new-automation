package week4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAndFrames {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElementByXPath("//iframe[@id='iframeResult']");
		driver.switchTo().frame(frame1);
		driver.findElementByXPath("//button[text()='Try it']").click();
		Alert alert1 = driver.switchTo().alert();
		alert1.sendKeys("Nagasamy");
		alert1.accept();
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		System.out.println(text);
	}

}

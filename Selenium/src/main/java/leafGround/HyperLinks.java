package leafGround;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLinks {

	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='Link']").click();
		String attribute = driver.findElementByLinkText("Find where am supposed to go without clicking me?").getAttribute("href");
		System.out.println(attribute);
		String brokenLink = driver.findElementByLinkText("Verify am I broken?").getAttribute("href");
		URL link = new URL(brokenLink);
		HttpURLConnection openConnection =(HttpURLConnection) link.openConnection();
		openConnection.connect();
		if(openConnection.getResponseCode()==200)
		{
			System.out.println("Link is working");
		}
		else
		{
			System.out.println("Link is broken");
		}

	}

}

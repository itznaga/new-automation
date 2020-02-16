package projectExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByLinkText("Start your wonderful journey").click();
		driver.findElementByXPath("//div[@class='items'  and contains(text(),'Thuraipakkam')]").click();
		driver.findElementByXPath("//button[@class='proceed']").click();
		driver.findElementByXPath("(//div[@class='text'])[2]").click();
		driver.findElementByXPath("//button[@class='proceed']").click();
		driver.findElementByXPath("//button[@class='proceed']").click();
		List<WebElement> priceList = driver.findElementsByXPath("//div[@class='price']");
		Set<Integer> priceListAsc = new TreeSet<Integer>();
		for(WebElement prices : priceList)
		{
			String price = prices.getText();
			String price1 = price.replaceAll("[^0-9]", "");
			priceListAsc.add(Integer.parseInt(price1));
		}
		int highPrice = priceListAsc.size();
		List<Integer> priceHigh = new ArrayList<Integer>(priceListAsc);
		Integer highValue = priceHigh.get(highPrice-1);
		String carName = driver.findElementByXPath("//div[@class='price' and contains(text(),'"+highValue+"')]/parent::div/parent::div/parent::div//h3").getText();
		System.out.println(carName +" is the Highest Priced Car with Rent =" +highValue);

	}

}

package hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("Egmore",Keys.TAB);
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("TPJ",Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		Set<Integer> trainNumbers = new TreeSet<Integer>();
		Set<Integer> sortedNumbers = new TreeSet<Integer>();
		List<WebElement> trainNumberList = driver.findElementsByXPath("//a[@title='Click on train number to View fare and schedule']");
		for(WebElement trainNums : trainNumberList)
		{
			int nums = Integer.parseInt(trainNums.getText());
			trainNumbers.add(nums);
		}
		driver.findElementByXPath("//a[@title='Click here to sort on Train Number']").click();
		List<WebElement> sortedNumList = driver.findElementsByXPath("//a[@title='Click on train number to View fare and schedule']");
		for(WebElement trainNums : sortedNumList)
		{
			int nums = Integer.parseInt(trainNums.getText());
			boolean add = sortedNumbers.add(nums);
			if(add==false)
			{
				System.out.println("Train numbers contains duplicate values");
				break;
			}
		}
		if(trainNumbers.equals(sortedNumbers))
		{
			System.out.println("Sorting is working in Train Column and has no Duplicate values");
		}		
	}

}

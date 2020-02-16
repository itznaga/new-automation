package week2.day1;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Nagasamy");
		driver.findElementById("createLeadForm_lastName").sendKeys("Manivannan");
//		driver.findElementByName("submitButton").click();
//		String title=driver.getTitle();
//		System.out.println(title);
//		driver.close();
		WebElement Source = driver.findElementById("createLeadForm_dataSourceId");
		Select dd1=new Select(Source);
		dd1.selectByVisibleText("Existing Customer");
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dd2=new Select(marketingCampaign);
		List<WebElement> marketingCampaignOptions = dd2.getOptions();
		dd2.selectByIndex(marketingCampaignOptions.size()-1);
		dd2.selectByValue("CATRQ_ROADNTRACK");
	}

}

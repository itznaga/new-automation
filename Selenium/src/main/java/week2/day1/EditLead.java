package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) {
		String company = "TCS";
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByXPath("//a[contains(text(),'Leads')]").click();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Nagasamy");
		driver.findElementByXPath("//button[@type='button' and contains(text(),'Find Leads')]").click();
		driver.findElementByXPath("((//table[contains(@id,'ext-gen')])[8]//a[@class='linktext'])[1]").click();
		driver.getTitle().equals("View Lead | opentaps CRM");
		driver.findElementByXPath("(//a[@class='subMenuButton'])[3]");
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").clear();
		driver.findElementByXPath("//input[@id='updateLeadForm_companyName']").sendKeys(company);
		driver.findElementByXPath("(//input[@name='submitButton'])[1]").click();
		String companyUpdated = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']").getText();
		if(companyUpdated.equals(company))
		{
			System.out.println("Company name updated");
		}
		else
		{
			System.out.println("Company name NOT updated");
		}

	}

}

package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatLead {

	public static void main(String[] args) throws InterruptedException {
//				    LoginMethod login = new LoginMethod();
//				    LoginMethod.loginSteps();   
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		String company = new String("TCS");
		String firstName = new String("Nagasamy");
		String lastName = new String("Manivannan");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys(company);
		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);
		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);
		WebElement source = driver.findElementByXPath("//select[@id='createLeadForm_dataSourceId']");
		Select selectSource = new Select(source);
		selectSource.selectByVisibleText("Word of Mouth");
		driver.findElementByXPath("//input[@id='createLeadForm_firstNameLocal']").sendKeys(firstName);
		driver.findElementByXPath("//input[@id='createLeadForm_lastNameLocal']").sendKeys(lastName);
		WebElement marketingCampaign = driver.findElementById("createLeadForm_marketingCampaignId");
		Select dd2=new Select(marketingCampaign);
		dd2.selectByValue("CATRQ_ROADNTRACK");
		driver.findElementByXPath("//input[@id='createLeadForm_personalTitle']").sendKeys("MR");
		driver.findElementByXPath("//input[@id='createLeadForm_generalProfTitle']").sendKeys("Test Engineer");
		driver.findElementByXPath("//input[@id='createLeadForm_annualRevenue']").sendKeys("5Lakhs");
		WebElement industry = driver.findElementByXPath("//select[@id='createLeadForm_industryEnumId']");
		Select industryOption = new Select(industry);
		industryOption.selectByVisibleText("Computer Software");
		driver.findElementByXPath("//input[@id='createLeadForm_departmentName']").sendKeys("IT");
		WebElement currency = driver.findElementByXPath("//select[@id='createLeadForm_currencyUomId']");
		Select currencyValue = new Select(currency);
		currencyValue.selectByVisibleText("INR - Indian Rupee");
		driver.findElementByXPath("//input[@id='createLeadForm_numberEmployees']").sendKeys("4 Lakhs");
		WebElement owner = driver.findElementByXPath("//select[@id='createLeadForm_ownershipEnumId']");
		Select ownerShip = new Select(owner);
		ownerShip.selectByVisibleText("Corporation");
		driver.findElementById("createLeadForm_sicCode").sendKeys("12345");
		driver.findElementByXPath("//textarea[@id='createLeadForm_description']").sendKeys("Lead Position text testing");
		driver.findElementByXPath("//textarea[@id='createLeadForm_importantNote']").sendKeys("Nothing Important");
		driver.findElementByXPath("//input[@id='createLeadForm_birthDate']").sendKeys("09/19/93");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAreaCode']").sendKeys("600036");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneExtension']").sendKeys("123");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneNumber']").sendKeys("9943133277");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryPhoneAskForName']").sendKeys("Kumar");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryWebUrl']").sendKeys("www.tcs.com");
		driver.findElementByXPath("//input[@id='createLeadForm_primaryEmail']").sendKeys("mrnagasami@gmail.com");
		driver.findElementByXPath("//input[@id='createLeadForm_generalToName']").sendKeys("Nagasamy");
		driver.findElementByXPath("//input[@name='generalAddress1']").sendKeys("Shollinganallur");
		driver.findElementByXPath("//input[@id='createLeadForm_generalCity']").sendKeys("Chennai");
		driver.findElementByXPath("//input[@id='createLeadForm_generalPostalCode']").sendKeys("600036");
		WebElement country = driver.findElementByXPath("//select[@id='createLeadForm_generalCountryGeoId']");
		Select countrySelect = new Select(country);
		countrySelect.selectByVisibleText("India");
		WebElement state = driver.findElementByXPath("//select[@id='createLeadForm_generalStateProvinceGeoId']");
		Select selectState = new Select(state);
		selectState.selectByVisibleText("TAMILNADU");
		driver.findElementByXPath("//input[@name='submitButton']").click();
		String firstName1 = driver.findElementByXPath("//span[@id='viewLead_firstName_sp']").getText();
		if(firstName1.equals(firstName))
		{
			System.out.println("Entered Firstname captured perfectly");
		}
		else
		{
			System.out.println("Entered Firstname NOT Captured");
		}
	}

}

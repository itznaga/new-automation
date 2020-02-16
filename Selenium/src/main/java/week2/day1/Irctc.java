package week2.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Irctc {

	public static void main(String[] args) {
		String userName = "Nagasamy123";
		String passWord= "pwd@Q1234";
		String securityAnswer = "Lions School";
		String firstName = "Nagasamy";
		String email = "mrnagasami@gmail.com";
		String mobileNo = "9943133277";
		String userNationality = "India";
		System.setProperty("webdriver.chrome.driver","./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementByXPath("(//a[@class='ng-star-inserted'])[3]").click();
		driver.findElementByXPath("//input[@id='userName']").sendKeys(userName);
		driver.findElementByXPath("//input[@id='usrPwd']").sendKeys(passWord);
		driver.findElementByXPath("//input[@id='cnfUsrPwd']").sendKeys(passWord);
		driver.findElementByXPath("//label[@class='ng-tns-c13-8 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']").click();
		driver.findElementByXPath("(//div[@class='ui-dropdown-items-wrapper']//span)[2]").click();;
		driver.findElementByXPath("(//input[@class='form-control ng-untouched ng-pristine ng-invalid'])[2]").sendKeys(securityAnswer);
		WebElement Lang = driver.findElementByXPath("//label[@class='ng-tns-c13-9 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']");
		Select Lang1 = new Select(Lang);
		Lang1.selectByVisibleText("English");
		driver.findElementByXPath("//input[@id='firstName']").sendKeys(firstName);
		driver.findElementByXPath("//input[@id='M']").click();
		driver.findElementByXPath("//input[@class='ng-tns-c14-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']").click();
		WebElement birthMonth = driver.findElementByXPath("//select[@class='ui-datepicker-month ng-tns-c14-10 ng-star-inserted']");
	    Select birthMonth1 = new Select(birthMonth);
	    birthMonth1.selectByVisibleText("September");
	    WebElement birthYear = driver.findElementByXPath("//select[@class='ui-datepicker-year ng-tns-c14-10 ng-star-inserted']");
	    Select birthYear1 = new Select(birthYear);
	    birthYear1.selectByVisibleText("1993");
	    driver.findElementByXPath("//a[@class='ui-state-default ng-tns-c14-10 ng-star-inserted' and contains(text(),'19')]").click();
	    WebElement occupation = driver.findElementByXPath("//label[@class='ng-tns-c13-11 ui-dropdown-label ui-inputtext ui-corner-all ui-placeholder ng-star-inserted']");
	    Select occupation1 = new Select(occupation);
	    occupation1.selectByVisibleText("PRIVATE");
	    driver.findElementByXPath("(//input[@class='ng-untouched ng-pristine ng-valid'])[2]").click();
	    driver.findElementByXPath("//input[@id='email']").sendKeys(email);
	    driver.findElementByXPath("//input[@id='mobile']").sendKeys(mobileNo);
	    WebElement nationality = driver.findElementByXPath("(//select[@class='form-control ng-untouched ng-pristine ng-invalid'])[1]");
	    Select nationality1 = new Select(nationality);
	    nationality1.selectByVisibleText(userNationality);
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

}

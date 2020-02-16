//package stepDefinition;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import application.BasePage;
//import application.CitidirectPP;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import testRunner.RunTest;
//
// public class StepDefinitions  {
//
////	public static ChromeDriver driver;
////
////	@Given("user launch chrome")
////	public void launchBrowser()
////	{
////		driver=new ChromeDriver();
////	}
////
////	@And("user maximize the browser")
////	public void maxBrowser()
////	{
////		driver.manage().window().maximize();
////	}
////
////	@And("user set the Time out")
////	public void implicitWait()
////	{
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////	}
////
////	@And("user launch UAT Application")
////	public void launchUAT()
////	{
////		driver.get("https://portaluat.citidirect.com");
////	}
////	
////	@When("user navigate to login page")
////	public void loginPage() throws InterruptedException
////	{ 
////		Thread.sleep(2000);
////		driver.findElementByXPath("//a[@id='btnGo']").click();
////	}
//	@When("user login as \"([^\\\"]*)\\\"$")
//	public void loginUser(String user) throws InterruptedException
//	{
////		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
////		driver.findElementByXPath("//img[@id='imgLoginMethod']").click();
////		driver.findElementByXPath("//a[@id='aLgnSecpwd']").click();
////		driver.findElementByXPath("//input[@id='DISPLAY_USER']").sendKeys(user);
////		driver.findElementByXPath("//input[@id='DISPLAY_PASSWORD']").sendKeys("citi1234");
////		driver.findElementByXPath("(//a[@class='btn'])[1]").click();
////		Thread.sleep(2000);
////		try
////		{
////		WebDriverWait wait = new WebDriverWait(driver, 20);
////		if(wait.until(ExpectedConditions.alertIsPresent())!= null)
////		{
////			driver.switchTo().alert().accept();
////			Thread.sleep(1000);
////		}
////		}catch(Exception e)
////		{
////			System.out.println(e.getMessage());
////		}
////		Thread.sleep(2000);
//		CitidirectPP obj = new CitidirectPP();
//		obj.loginMethod();
//	}
//	@Then("user navigate to \"([^\\\"]*)\\\" PP")
//	public void navigateToPP(String screen)
//	{
////		driver.findElementByLinkText("Self Service").click();;
////		driver.findElementByLinkText("Users & Entitlements").click();
////		driver.switchTo().frame("idashboard");
////		if(screen.contains("PP"))
//		{
////			driver.findElementByXPath("//a[@id='clientS']").click();
////			driver.findElementByXPath("//a[@id='AMA_NAV_ProdPkg']").click();
////			if(screen=="Create AMA PP")
////			{
////				driver.findElementByLinkText("Create").click();
////			}
////			else if(screen=="Authorize AMA PP")
////			{
////				driver.findElementByXPath("//a[@id='AMA_NAV_ProdPkg_Authorize']").click();
////			}
////			else if(screen=="Modify AMA PP")
////			{
////				driver.findElementByXPath("//a[@id='AMA_NAV_ProdPkg_Modify']").click();
////			}
////			else if(screen=="All AMA PP")
////			{
////				driver.findElementByLinkText("All Product Packages").click();
////			}
////		}
////		else if(screen.contains("DAP"))
////		{
////			driver.findElementByXPath("//a[@id='clientS']").click();
////		}
//	}
//
//	}
//}

package basePackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import interfaceDesign.Browser;
import interfaceDesign.Element;
import utils.DataLibrary;

public class BasePage extends DataLibrary implements Browser,Element {
	

	public void click(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			ele.click();
		} catch (Exception e) {
			System.out.println("Not able to Click Element"+e.getMessage());
		}

	}

	public void append(WebElement ele, String data) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			ele.sendKeys(data);
		} catch (Exception e) {
			System.out.println("Not able to Append"+e.getMessage());
		}

	}

	public void clear(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			ele.clear();
		} catch (Exception e) {
			System.out.println("Not able to Clear Text in the Element"+e.getMessage());
		}

	}

	public void clearAndType(WebElement ele, String data) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			ele.clear();
			ele.sendKeys(data);
		} catch (Exception e) {
			System.out.println("Not able to Clear and Type in the element"+e.getMessage());
		}

	}

	public String getElementText(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text="";
		try {
			text = ele.getText();			
		} catch (Exception e) {
			System.out.println("Not able to get Text from the Element"+e.getMessage());
		}
		return text;
	}

	public String getBackgroundColor(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String cssValue ="";
		try {
			cssValue = ele.getCssValue("color");
		} catch (Exception e) {
			System.out.println("Not able to get the Color of the Element"+e.getMessage());
		}
		return cssValue;
	}

	public String getTypedText(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String typedText ="";
		try {
			ele.getAttribute("value");
		} catch (Exception e) {
			System.out.println("Not able to get Typed text from the Element"+e.getMessage());
		}
		return typedText;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Select select = new Select(ele);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println("Not able to select value in dropdown"+e.getMessage());
		}

	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			String text = ele.getText();
			if(text.equalsIgnoreCase(expectedText))
			{
				return true;				
			}
		} catch (Exception e) {
			System.out.println("Not able to perform Verify Text"+e.getMessage());
		}
		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(ele.getText().contains(expectedText)) {
				System.out.println("The expected text contains the actual "+expectedText);
				return true;
			}else {
				System.out.println("The expected text doesn't contain the actual "+expectedText);
			}
		} catch (WebDriverException e) {
			System.out.println("Unknown exception occured while verifying the Text");
		} 

		return false;
	}

	public void verifyDisplayed(WebElement ele1) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(ele1.isDisplayed())
			{						
			reportLog("Confirmation Message displayed", "pass","CnfrmMsg");
			}
		} catch (WebDriverException e) {
			
				reportLog("Confirmation Message Not displayed", "fail","CnfrmMsg");
		}
		
	}

	public boolean verifyEnabled(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(ele.isEnabled()) {
				System.out.println("The element "+ele+" is Enabled");
				return true;
			} else {
				System.out.println("The element "+ele+" is not Enabled");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;
	}

	public boolean verifySelected(WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if(ele.isSelected()) {
				System.out.println("The element "+ele+" is selected");
				return true;
			} else {
				System.out.println("The element "+ele+" is not selected");
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException : "+e.getMessage());
		}
		return false;

	}

	public void startApp(String browser, String url) {
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",
						"./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
		} catch (Exception e) {
			System.out.println("Unable to launch"+browser+"and Exception="+e.getMessage());
		}
		driver.navigate().to(url);

	}

	public WebElement locateElement(String locatorType, String value) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			switch(locatorType.toLowerCase()) {
			case "id": return driver.findElementById(value);
			case "name": return driver.findElementByName(value);
			case "class": return driver.findElementByClassName(value);
			case "link": return driver.findElementByLinkText(value);
			case "xpath": return driver.findElementByXPath(value);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Not able to locate Element"+e.getMessage());
		}
		return null;
	}

	public void acceptAlert() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			if(wait.until(ExpectedConditions.alertIsPresent()) != null)
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				System.out.println("Alert handled");
			}
			else
			{
				System.out.println("There is no alert preset");
			}
		} catch (Exception e) {
			System.out.println("Not able to Accept Aler"+e.getMessage());
		}

	}

	public void dismissAlert() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			if(wait.until(ExpectedConditions.alertIsPresent()) != null)
			{
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
				System.out.println("Alert handled");
			}
			else
			{
				System.out.println("There is no alert preset");
			}
		} catch (Exception e) {
			System.out.println("Not able to Accept Aler"+e.getMessage());
		}

	}

	public void switchToWindow(int index) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windowHandles1 = new ArrayList<String>(windowHandles);
			String string = windowHandles1.get(index);
			driver.switchTo().window(string);
		} catch (Exception e) {
			System.out.println("Unable to Switch to Window"+e.getMessage());
		}

	}

	public void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			System.out.println("Unable to Switch to Frame"+e.getMessage());
		}

	}

	public void switchToFrame(WebElement ele) {
		try {
			driver.switchTo().frame(ele);
		} catch (Exception e) {
			System.out.println("Unable to Switch to Frame"+e.getMessage());
		}
	}

	public void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		} catch (Exception e) {
			System.out.println("Unable to Switch to Frame"+e.getMessage());
		}
	}

	public boolean verifyUrl(String url) {
		if (driver.getCurrentUrl().equals(url)) {
			System.out.println("The url: "+url+" matched successfully");
			return true;
		} else {
			System.out.println("The url: "+url+" not matched");
		}
		return false;
	}

	public boolean verifyTitle(String title) {
		if (driver.getTitle().equals(title)) {
			System.out.println("Page title: "+title+" matched successfully");
			return true;
		} else {
			System.out.println("Page url: "+title+" not matched");
		}
		return false;
	}
	public void scrollup(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public String location = "./data/ppName.xlsx";
	@DataProvider(name = "fetchData")
	public Object[][] dp() throws IOException
	{
		DataLibrary obj = new DataLibrary();
		Object[][] data = obj.readExcelDP(location);
		return data;
	}
	
	@Parameters({"browser","url"})
	
	@BeforeMethod	
	public void login(String browser,String url)
	{
		startApp(browser,url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement GoButton = locateElement("xpath", "//a[@id='btnGo']");
		click(GoButton);
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
}

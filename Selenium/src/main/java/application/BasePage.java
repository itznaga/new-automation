package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BasePage {
	public static ChromeDriver driver = new ChromeDriver();

//	@Parameters({"url"})

	@Before
	public  void loginToEnv() throws InterruptedException
	{
		try {
			driver.get("https://portaluat.citidirect.com");
			driver.manage().window().maximize();
//			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			click("//a[@id='btnGo']");
		}catch(Exception e)
		{
			System.out.println("Navigating to Login Page failed because = "+e.getMessage());
		}
	}

	@After
	public static void logout()
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.switchTo().defaultContent();
			driver.findElementByLinkText("Logout").click();
			driver.close();
		}catch(Exception e)
		{
			System.out.println("Not able to Logout of the Application and Exception="+e.getMessage());
		}
	}

	public static void loginAs(String user) throws InterruptedException
	{
		try
		{
			click("//img[@id='imgLoginMethod']");
			click("//a[@id='aLgnSecpwd']");
			driver.findElementByXPath("//input[@id='DISPLAY_USER']").sendKeys(user);
			driver.findElementByXPath("//input[@id='DISPLAY_PASSWORD']").sendKeys("citi1234");
			driver.findElementByXPath("(//a[@class='btn'])[1]").click();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			if(wait.until(ExpectedConditions.alertIsPresent())!=null)
			{
				driver.switchTo().alert().accept();
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
		}catch(Exception e)
		{
			System.out.println("Not able to login as Maker "+e.getMessage());
		}
	}

	public static void click(String xpath)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath)).click();
		}catch(Exception e)
		{
			System.out.println("Not able to Click the Element and Exception="+e.getMessage());
		}
	}
	public static void click(WebElement element)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			element.click();
		}catch(Exception e)
		{
			System.out.println("Not able to Click the Element and Exception="+e.getMessage());
		}
	}
	public static void type(String xpath, String Text)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath)).sendKeys(Text);
		}catch(Exception e)
		{
			System.out.println("Not able to type "+Text+" to the Element and Exception="+e.getMessage());
		}
	}
	public static void type(WebElement element,String Text)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			element.sendKeys(Text);		
		}catch(Exception e)
		{
			System.out.println("Not able to type "+Text+" to the Element and Exception="+e.getMessage());
		}
	}
	public static void exist(String xpath)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.xpath(xpath)).isDisplayed();
		}catch(Exception e)
		{
			System.out.println("Element not found in the Screen and Exception="+e.getMessage());
		}
	}
	public static void exist(WebElement element)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			element.isDisplayed();		
		}catch(Exception e)
		{
			System.out.println("Element not found in the Screen");
		}
	}

	public static void navigateToPP(String screen)
	{
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			click(driver.findElementByLinkText("Self Service"));
			click(driver.findElementByLinkText("Users & Entitlements"));
			driver.switchTo().frame("idashboard");
			if(screen.contains("PP"))
			{
			click("//a[@id='clientS']");
			click("//a[@id='AMA_NAV_ProdPkg']");
			if(screen=="Create AMA PP")
			{
				click(driver.findElementByLinkText("Create"));
			}
			else if(screen=="Authorize AMA PP")
			{
				click("//a[@id='AMA_NAV_ProdPkg_Authorize']");
			}
			else if(screen=="Modify AMA PP")
			{
				click("//a[@id='AMA_NAV_ProdPkg_Modify']");
			}
			else if(screen=="All AMA PP")
			{
				click(driver.findElementByLinkText("All Product Packages"));
			}
			}
			else if(screen.contains("DAP"))
			{
				click("//a[@id='clientS']");
			}

		}catch(Exception e)
		{
			System.out.println("Navigating to "+screen+" PP Screen failed and Exception="+e.getMessage());
		}		
	}
	public static void addServicesArray(String[] addServices) throws InterruptedException
	{
		try
		{
			List<String> addedServices = new ArrayList<String>();
			for(int i=0;i<addServices.length;i++)
			{
				addedServices.add(addServices[i]);
			}
			for(int i=0;i<addServices.length;i++)
			{
				String xpath = "//span[@title='"+addServices[i]+"']";
				driver.findElementByXPath(xpath).click();
				Thread.sleep(2000);
			}
			List<WebElement> rightSide = driver.findElementsByXPath("//span[contains(@id,'ServiceName_Right')]");
			List<String> allServices=new ArrayList<String>();
			for(WebElement services:rightSide)
			{
				allServices.add(services.getText());
				System.out.println("Services Added ="+services.getText());
			}
			if(addedServices.equals(allServices))
			{
				System.out.println("Services are added correctly");
			}
		}catch(Exception e)
		{
			System.out.println("Not able to Add Services or Clicked Services not added properly and Exception="+e.getMessage());
		}
	}
	public static void addServicesFromExcel(String location) throws InterruptedException, InvalidFormatException, IOException
	{
		try
		{
			List<String> addedServices1 = readExcel(location);
			for(int i=0;i<addedServices1.size();i++)
			{
				String xpath = "//span[@title='"+addedServices1.get(i)+"']";
				driver.findElementByXPath(xpath).click();
				Thread.sleep(2000);
			}
			List<WebElement> rightSide = driver.findElementsByXPath("//span[contains(@id,'ServiceName_Right')]");
			List<String> allServices=new ArrayList<String>();
			for(WebElement services:rightSide)
			{
				allServices.add(services.getText());
				System.out.println("Services Added ="+services.getText());
			}
			if(addedServices1.equals(allServices))
			{
				System.out.println("Services are added correctly");
			}
		}catch(Exception e)
		{
			System.out.println("Not able to Add Services or Clicked Services not added properly and Exception="+e.getMessage());
		}

	}

	public static List<String> readExcel(String location) throws InvalidFormatException, IOException
	{
		List<String> dataFromExcel = new ArrayList<String>();
		XSSFWorkbook workbook = new XSSFWorkbook(new File(location));
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String addServices = cell.getStringCellValue();
				dataFromExcel.add(addServices);
			}
		}
		workbook.close();
		return dataFromExcel;
	}
	public static void takeScreenshot(String fileName) throws Exception
	{
		try
		{
			Thread.sleep(3000);
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destiny = new File("./Snaps/"+fileName+".png");
			FileUtils.copyFile(source, destiny);
		}catch(Exception e)
		{
			System.out.println("Not able to take Screenshot"+ e.getMessage());
		}
	}
	public static void writeFile(String FileName, String text) throws IOException
	{
		try
		{
			File textfile = new File(System.getProperty("user.dir"),FileName);
			if(textfile.exists())
			{
				textfile.delete();
				textfile.createNewFile();
			}
			FileWriter writer = new FileWriter(textfile); 
			BufferedWriter buffer = new BufferedWriter(writer);  
			buffer.write(text);  
			buffer.close();  
		}catch(Exception e)
		{
			System.out.println("Not able to Write File"+ e.getMessage());
		}
	}
	public static String readfile(String FileName) throws Throwable
	{
		File textfile = new File(System.getProperty("user.dir"),FileName);
		FileReader in = new FileReader(textfile);
		BufferedReader br = new BufferedReader(in);
		String textfromfile;
		StringBuilder sb=  new StringBuilder();
        while ((textfromfile = br.readLine()) != null) 
        {
               sb.append(textfromfile);
        }
        textfromfile = sb.toString();
        br.close();
        return textfromfile;
	}
}

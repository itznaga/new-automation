package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class ReportCucmber extends AbstractTestNGCucumberTests {
	public static RemoteWebDriver driver;
	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public String testcaseName, author;
	
	
	
	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
//		reporter.setAppendExisting(false); 
		extent   = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
    @BeforeClass
	public void report() throws IOException {
		test = extent.createTest(testcaseName);
	    test.assignAuthor(author); 
	}
    public String takeScreenshot(String name)
    {
    	try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+name+".jpg"));
		} catch (WebDriverException e) {
			System.out.println("The browser has been closed.");
		} catch (IOException e) {
			System.out.println("The snapshot could not be taken");
		}
		return name;
    }
    
   
    public void reportLog(String dec, String status,boolean bSnap,String sName ) {
    	MediaEntityModelProvider img = null;
		if(bSnap && !status.equalsIgnoreCase("INFO")){
			String ssName = takeScreenshot(sName);

			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../reports/images/"+ssName+".jpg").build();
			} catch (IOException e) {
				
			}
		}
    	if(status.equalsIgnoreCase("pass")) {
    		test.pass(dec, img);
    	} else if(status.equalsIgnoreCase("fail")) {
    		test.fail(dec, img); 
    	}
    }
    public void reportLog(String desc, String status,String sName) {
		reportLog(desc, status, true, sName);
	}

    
    @AfterSuite
    public void stopReport() {
    	extent.flush();
    }
}

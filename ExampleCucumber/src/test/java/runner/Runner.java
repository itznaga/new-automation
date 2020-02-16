package runner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.ReportCucmber;


@CucumberOptions(features = {"./src/test/java/features/ProductPkg.feature"}, glue = {"stepDefinitions"},tags= {"@TestScenario1"}, monochrome = true)
//@Listeners(listeners.MyTransformer.class)
public class Runner extends ReportCucmber {
	@BeforeTest
	public void setData() {
		testcaseName = "Product Package Sanity";
		author = "Naga";
		test = extent.createTest(testcaseName);
	    test.assignAuthor(author);
	}
	
}



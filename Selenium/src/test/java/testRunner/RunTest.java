package testRunner;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/features/CreatePP.feature", glue = {"stepDefinition","./src/main/java/application"}, monochrome = true)
public class RunTest extends AbstractTestNGCucumberTests
{
	
}



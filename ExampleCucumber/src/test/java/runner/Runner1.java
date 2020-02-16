package runner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import utils.ReportCucmber;
	@CucumberOptions(features = {"./src/test/java/features/ProductPkg.feature"}, glue = {"stepDefinitions"},tags= {"@TestScenario2"}, monochrome = true)
	//@Listeners(listeners.MyTransformer.class)
	public class Runner1 extends ReportCucmber {
		@BeforeTest
		public void setData() {
			testcaseName = "Product Package Sanity";
			author = "Naga";
			test = extent.createTest(testcaseName);
		    test.assignAuthor(author);
		}
		
	}


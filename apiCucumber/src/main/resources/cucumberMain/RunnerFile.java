package cucumberMain;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"./src/main/resources/test/ApiTesting.feature"}, glue = {"src/main/resources/cucumberMain/StepDefinitions"},tags= {"@TestScenario1"}, monochrome = true)
public class RunnerFile extends AbstractTestNGCucumberTests {

}

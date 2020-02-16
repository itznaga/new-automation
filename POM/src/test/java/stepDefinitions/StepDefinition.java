package stepDefinitions;



import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testCases.TestCasesMethods;
import wrapper.BasePage;

public class StepDefinition {
    
	
	@Given("user launch \"([^\\\"]*)\\\" Application")
	public void launchMethod(String URL) throws InterruptedException
	{
		BasePage obj = new BasePage();
		obj.loginToEnv(URL);
	}
	
	@When("user login as \"([^\\\"]*)\\\"$")
	public void userLogin(String user) throws InterruptedException
	{
		BasePage obj = new BasePage();
		obj.loginAs(user);
	}
	
	@And("user navigate to \"([^\\\"]*)\\\" PP")
	public void ppNavigation(String screen)
	{
		BasePage obj = new BasePage();
		obj.navigateToPP(screen);
	}
	
	@Then("user submits new Product Package")
	public void submitPP() throws Throwable
	{
		TestCasesMethods obj = new TestCasesMethods();
		obj.submitPP1();
	}
	
	@And("user logsout of the Application")
	public void logOutMethod()
	{
		BasePage obj = new BasePage();
		obj.logout();
	}
	
	@Then("user Authorize submitted Product Package")
	public void authorizePP() throws Throwable
	{
		TestCasesMethods obj = new TestCasesMethods();
		obj.authorizePP1();
	}
}

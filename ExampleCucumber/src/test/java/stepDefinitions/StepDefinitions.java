package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import basePackage.BasePageCucumber;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.CreatePPCucumber;
import pages.LoginPageCucumber;
import pages.NavigationPageCucumber;
import utils.ReportCucmber;


public class StepDefinitions {
	
	@Given("user open \"([^\"]*)\" and launch \"([^\"]*)\"$")
	public void launchBrowser(String Browser,String url)
	{
		BasePageCucumber obj = new BasePageCucumber();
		try {			
			obj.login(Browser,url);
			obj.reportLog("Launch Browser Successfull", "pass", "Launch Application");
		} catch (Exception e) {
			obj.reportLog("Launch Browser UnSuccessfull", "fail", "Launch Application");
		}
	}
	@Given("user logs in as \"([^\"]*)\"$")
	public void userLogin(String user)
	{
		LoginPageCucumber obj = new LoginPageCucumber();
		try {
			obj.loginUser(user);
			obj.reportLog("Login User Successfull", "pass", "Login User");
		} catch (Exception e) {
			obj.reportLog("Launch User UnSuccessfull", "fail", "Login User");
		}
	}
	@When("user navigates to Product Package \"([^\"]*)\"$")
	public void navigate(String screen)
	{
		NavigationPageCucumber obj = new NavigationPageCucumber();
		try
		{
			obj.navigationPP(screen);
			obj.reportLog("Navigation to PP Successfull", "pass", "Navigation PP");
		} catch (Exception e) {
			obj.reportLog("Navigation to PP  UnSuccessfull", "fail", "Navigation PP");
		}
	}
	@And("user enters \"([^\"]*)\" and adds service from \"([^\"]*)\" and submit PP")
	public void ppName(String ppNameText, String location) throws InvalidFormatException, IOException, InterruptedException
	{
		CreatePPCucumber obj = new CreatePPCucumber();
			obj.submitPP(ppNameText, location);
		
	}
	@And("user logs out of application")
	public void logOut() {
		BasePageCucumber obj = new BasePageCucumber();		
			obj.afterMethod();		
	}

}

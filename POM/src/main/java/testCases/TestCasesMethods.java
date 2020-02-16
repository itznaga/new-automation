package testCases;


import org.testng.annotations.BeforeTest;

import pages.authorizePP;
import pages.createPP;
import wrapper.BasePage;

public class TestCasesMethods extends BasePage {

	public void submitPP1() throws Throwable
	{
		new createPP().submitPP();
	}

	public void authorizePP1() throws Throwable 
	{
		new authorizePP().authorizeProdPkg();

	}

}

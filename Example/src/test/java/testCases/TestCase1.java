package testCases;

import java.io.IOException;
import java.util.UUID;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basePackage.BasePage;
import cucumber.api.java.Before;
import pages.CreatePP;
import pages.LoginPage;
import pages.authProdPkg;

@Listeners(listeners.MyTransformer.class)
public class TestCase1 extends BasePage{
	
	@BeforeTest
	public void setData() {
		testcaseName = "Product Package Sanity";
		author = "Naga";
		test = extent.createTest(testcaseName);
	    test.assignAuthor(author);
	}


	
	@Test(dataProvider="fetchData")
	public void submitPP(String ppName) throws InterruptedException, InvalidFormatException, IOException
	{
		new LoginPage().loginUser("ama4002").navigationPP("create");
		new CreatePP().submitPP(ppName,"./data/services.xlsx");
	}
	
	@Test(dataProvider="fetchData")
	public void submitPP1(String ppNameAuth) throws InterruptedException, InvalidFormatException, IOException
	{
		new LoginPage().loginUser("ama4001").navigationPP("Authorize");
		new authProdPkg().authPP(ppNameAuth, "./data/services.xlsx");
		}
	@Test
	public void getCR()
	{
		
	}

}

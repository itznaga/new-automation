package testCases;

import java.io.IOException;
import java.util.UUID;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import basePackage.BasePageCucumber;
import pages.CreatePPCucumber;
import pages.LoginPageCucumber;

public class TestCase1 extends BasePageCucumber{
	
	@BeforeTest
	public void setData() {
		testcaseName = "Product Package Sanity";
		author = "Naga";
	}

	
//	@Test(dataProvider="fetchData")
	public void submitPP(String ppName) throws InterruptedException, InvalidFormatException, IOException
	{
		new LoginPageCucumber().loginUser("ama4002").navigationPP("create");
		new CreatePPCucumber().submitPP(ppName,"./data/services.xlsx");
	}

}

package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.WebElement;

import wrapper.BasePage;

public class authorizePP extends BasePage {
	
	static String maker = "va2626";
	static String checker = "va2727";
	static String ppName = UUID.randomUUID().toString();


	//XPath
	static String ppNameXpath="//input[@id='ProductPackageFields_Name']";
	static String submitButtonXpath="//input[@id='btnSubmit']";
	static String submitCnfrmMsg="//p[@id='notifications_msg' and contains(text(),'The Product Package has been created and sent for authorization.')]";
	static String showSearchCriteria = "//a[@title='Show Search Criteria']";
	static String authPPName = "//input[@id='Criteria_Criteria_ProductPackageName_FilterValue']";
	static String authSearch = "//input[@id='OuterPanel_go']";
	static String authFirstRecord = "//tr[@class='ui-widget-content jqgrow ui-row-ltr']//a";

	public authorizePP authorizeProdPkg() throws Throwable
	{
//		loginAs(checker);
//		navigateToPP("Authorize AMA PP");
		Thread.sleep(3000);
		click(showSearchCriteria);
		String ppNameAuth = readfile("ppName");
		type(authPPName,ppNameAuth);
		click(authSearch);
		Thread.sleep(2000);
		takeScreenshot("AuthRecord");
		click(authFirstRecord);
		Thread.sleep(3000);
		List<String> allServices = readExcel("./data/services.xlsx");
		List<WebElement> authServices = driver.findElementsByXPath("//h1[@class='c-data-summary-label c-margin-left']");		
		List<String> allServices1=new ArrayList<String>();
		for(WebElement services:authServices)
		{
			allServices1.add(services.getText());
		}
		if(allServices.equals(allServices1))
		{
			System.out.println("Added services reflected in Auth screen perfectly");
		}
		else
		{
			System.out.println("Added services not reflected perfectly");
		}
		return this;
	}
}

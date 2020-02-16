package pages;

import java.util.UUID;

import org.testng.annotations.Test;

import wrapper.BasePage;

public class createPP extends BasePage {
	static String maker = "va2626";
	static String checker = "va2727";
	static String ppName = UUID.randomUUID().toString();

	//XPath
	static String ppNameXpath="//input[@id='ProductPackageFields_Name']";
	static String submitButtonXpath="//input[@id='btnSubmit']";
	static String submitCnfrmMsg="//p[@id='notifications_msg' and contains(text(),'The Product Package has been created and sent for authorization.')]";
	
	public createPP submitPP() throws Exception
	{
//		loginAs(maker);
//		takeScreenshot("loginScreenshot");
//		navigateToPP("Create AMA PP");
		Thread.sleep(4000);
		type(ppNameXpath,ppName);
		writeFile("ppName",ppName);
		takeScreenshot("AMAPPScreenshot");
		addServicesFromExcel("./data/services.xlsx");		
		takeScreenshot("ServicesAddedScreenshot");
		click(submitButtonXpath);
		exist(submitCnfrmMsg);
		takeScreenshot("ConfrmMsgScreenshot");
		return this;

	}

}

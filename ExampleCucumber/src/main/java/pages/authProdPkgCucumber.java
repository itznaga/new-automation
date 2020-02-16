package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePageCucumber;

public class authProdPkgCucumber extends BasePageCucumber {
	public authProdPkgCucumber()
	{
		PageFactory.initElements(driver, this);
	}
//	@FindBy(how=How.XPATH, using="//input[@id='ProductPackageFields_Name']") WebElement authPPName;
	@FindBy(how=How.XPATH, using="//a[@title='Show Search Criteria']") WebElement showSearchCriteria;
	@FindBy(how=How.XPATH, using="//input[@id='Criteria_Criteria_ProductPackageName_FilterValue']") WebElement authPPName;
	@FindBy(how=How.XPATH, using="//input[@id='OuterPanel_go']") WebElement authSearch;
	@FindBy(how=How.XPATH, using="//tr[@class='ui-widget-content jqgrow ui-row-ltr']//a") WebElement authFirstRecord;
	@FindBy(how=How.XPATH, using="(//input[@value='Authorize'])[1]") WebElement authButton;
	@FindBy(how=How.XPATH, using="//p[@id='notifications_msg' and contains(text(),'The Product Package  has been authorized.')]") WebElement authMsg;
	@FindBy(how=How.LINK_TEXT, using="Self Service") WebElement selfService;
	
	public void authPP(String ppNameAuth,String location) throws InterruptedException, InvalidFormatException, IOException
	{
		try {
			Thread.sleep(3000);
			click(showSearchCriteria);
//		String ppNameAuth = readfile("ppName");
			clearAndType(authPPName,ppNameAuth);
			click(authSearch);
			Thread.sleep(2000);
			takeScreenshot("AuthRecord");
			click(authFirstRecord);
			Thread.sleep(3000);
			List<String> allServices = readExcel(location);
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
			click(authButton);
			verifyDisplayed(authMsg);
			scrollup(authMsg);
			reportLog("Product Package Successfully Authorized","pass","authPP");
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			scrollup(selfService);
			reportLog("Product Package NOT Authorized","fail","authPP");
			
		}
		
	}
	
}

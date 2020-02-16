package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import basePackage.BasePage;

public class CreatePP extends BasePage{
	
	public CreatePP() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(how=How.XPATH , using="//input[@id='ProductPackageFields_Name']") WebElement ppName;
	@FindBy(how=How.XPATH , using="//input[@id='btnSubmit']") WebElement submitButton;
	@FindBy(how=How.XPATH , using="//p[@id='notifications_msg' and contains(text(),'The Product Package has been created and sent for authorization.')]") WebElement cnfrmMsg;
	@FindBy(how=How.LINK_TEXT, using="Self Service") WebElement selfService;
	
	
	
	public void submitPP(String ppNameText, String location) throws IOException, InvalidFormatException, InterruptedException
	{
		try {
			clearAndType(ppName, ppNameText);
			writeFile("ppName",ppNameText);
			addServicesFromExcel(location);
			click(submitButton);
			Thread.sleep(2000);			
			verifyDisplayed(cnfrmMsg);
			scrollup(cnfrmMsg);
			reportLog("Product Package Successfully submitted", "pass", "submitPP");
//			Assert.assertTrue(false);
		} catch (Exception e) {
			driver.switchTo().defaultContent();
			scrollup(selfService);
			reportLog("Not able to Submit PP", "fail","submitPP");
		}
	}
	
	public void addServicesFromExcel(String location) throws InterruptedException, InvalidFormatException, IOException
	{
		try
		{
			List<String> addedServices1 = readExcel(location);
			for(int i=0;i<addedServices1.size();i++)
			{
				String xpath = "//span[@title='"+addedServices1.get(i)+"']";
				driver.findElementByXPath(xpath).click();
				Thread.sleep(3000);
			}
			List<WebElement> rightSide = driver.findElementsByXPath("//span[contains(@id,'ServiceName_Right')]");
			List<String> allServices=new ArrayList<String>();
			for(WebElement services:rightSide)
			{
				allServices.add(services.getText());
				System.out.println("Services Added ="+services.getText());
			}
			if(addedServices1.equals(allServices))
			{
				reportLog("Added services reflected properly", "pass","addServicesFromExcel");
			}
			
		}catch(Exception e)
		{
			reportLog("Not able to Add Services or Clicked Services not added properly", "fail","addServiceFromExcel");
			System.out.println("Not able to Add Services or Clicked Services not added properly and Exception="+e.getMessage());
		}

	}

}

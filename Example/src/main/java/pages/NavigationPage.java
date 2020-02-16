package pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePage;

public class NavigationPage extends BasePage {
	

	public NavigationPage() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(how=How.LINK_TEXT, using="Self Service") WebElement selfService;
	@FindBy(how=How.LINK_TEXT, using="Users & Entitlements") WebElement userEnt;
	@FindBy(how=How.XPATH , using="//a[@id='clientS']") WebElement clients;
	@FindBy(how=How.XPATH , using="//a[@id='AMA_NAV_ProdPkg']") WebElement amaPP;
	@FindBy(how=How.LINK_TEXT, using="Create") WebElement createPP;
	@FindBy(how=How.XPATH , using="//a[@id='AMA_NAV_ProdPkg_Authorize']") WebElement authorizePP;
	@FindBy(how=How.LINK_TEXT, using="All Product Packages") WebElement allPP;
	@FindBy(how=How.XPATH , using="//a[@id='AMA_NAV_ProdPkg_Modify']") WebElement modifyPP;
	
	public void navigationPP(String screen) throws InterruptedException, IOException
	{
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			click(selfService);	
			takeScreenshot("Click Self Service");
			click(userEnt);
			switchToFrame("idashboard");
			click(clients);
			takeScreenshot("Click Clients");
			click(amaPP);
			if(screen.equalsIgnoreCase("Create"))
			{
				click(createPP);
			}
			else if(screen.equalsIgnoreCase("Authorize"))
			{
				click(authorizePP);
			}
			else if(screen.equalsIgnoreCase("Modify"))
			{
				click(modifyPP);
			}
			else if(screen.equalsIgnoreCase("All"))
			{
				click(allPP);
			}
			reportLog("Able to Navigate to PP", "pass","navigatePP");
		} catch (Exception e) 
		{
			reportLog("Not able to Navigate to PP", "fail","navigatePP");
		}

	}

}

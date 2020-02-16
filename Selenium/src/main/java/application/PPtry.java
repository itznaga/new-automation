package application;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PPtry extends BasePage {
	
    @Test
	public void ppDupliacteandSearch() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String search = "MAR22 PP";
		driver.findElementByLinkText("Self Service").click();
		driver.findElementByLinkText("Users & Entitlements").click();
		driver.switchTo().frame("idashboard");
		driver.findElementByXPath("//a[@id='clientS']").click();
		driver.findElementByXPath("//a[@id='AMA_NAV_ProdPkg']").click();
		driver.findElementByXPath("//a[@id='AMA_NAV_ProdPkg_Authorize']").click();
		WebElement pagination = driver.findElementByXPath("((//td[@class='ui-pg-button ui-state-disabled'])[1]/following::td//span)[1]");
		int number = Integer.parseInt(pagination.getText());
		Set<String> page1names=new LinkedHashSet<String>();
		int i = 0;
		for(i=0;i<number-1;i++)
		{
			List<WebElement> page1elements = driver.findElementsByXPath("//a[contains(@id,'Results_gi_ProductPackageName_')]");
			for(WebElement services:page1elements)
			{
				boolean duplicate = page1names.add(services.getText());
				if(duplicate=false)
				{
					System.out.println("Contains Duplicate name at page "+ i);
					break;
				}
			}
			if(i<=number-2)
			{
				driver.findElementByXPath("//td[@id='next_t_Results_toppager']").click();
				Thread.sleep(3000);
			}
		}
		System.out.println("There is no Duplicate");
		System.out.println(page1names);
		System.out.println("Total records available = " +page1names.size());
		List<String> searchList = new ArrayList<String>();
		for(int j=number-1;j>0;j--)
		{
			List<WebElement> searchElements = driver.findElementsByXPath("//a[contains(@id,'Results_gi_ProductPackageName_')]");
			for(WebElement searchelement :searchElements )
			{
				searchList.add(searchelement.getText());
			}
			if(searchList.contains(search))
			{
				driver.findElementByXPath("//a[text()='"+search+"']").click();
				break;
			}
			driver.findElementByXPath("//td[@id='prev_t_Results_toppager']").click();
			Thread.sleep(3000);
		}
	}
	}


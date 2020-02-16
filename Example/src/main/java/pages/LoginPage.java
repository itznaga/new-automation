package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basePackage.BasePage;

public class LoginPage extends BasePage {
	public LoginPage() {
		PageFactory.initElements(driver, this); 
	}
	@FindBy(how=How.XPATH, using="//img[@id='imgLoginMethod']") WebElement logMethod;
	@FindBy(how=How.XPATH, using="//a[@id='aLgnSecpwd']") WebElement sPwd;
	@FindBy(how=How.XPATH, using="//input[@id='DISPLAY_USER']") WebElement uName;
	@FindBy(how=How.XPATH, using="//input[@id='DISPLAY_PASSWORD']") WebElement Pwd;
	@FindBy(how=How.XPATH, using="(//a[@class='btn'])[1]") WebElement loginButton;



	public NavigationPage loginUser(String user) throws InterruptedException, IOException
	{
		try
		{
		click(logMethod);
		click(sPwd);
		clearAndType(uName, user);
		clearAndType(Pwd, "citi1234");
		takeScreenshot("Entering UserName");
		click(loginButton);
		acceptAlert();
		Thread.sleep(2000);
		reportLog("User able to login","pass","loginUser");
		}catch(Exception e)
		{
			reportLog("User unable to login","fail","loginUser");
		}
		return new NavigationPage();
	}
}

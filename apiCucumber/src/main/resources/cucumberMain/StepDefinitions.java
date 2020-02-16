package cucumberMain;

import BasePackage.BaseClass;
import cucumber.api.java.en.Given;
import testClasses.ONPapiValidations;

public class StepDefinitions {
	
	public String apiToken1;
	
	@Given("user generates (*) Authentication code to access API")
	public void tokenGen(String env)
	{
		apiToken1 = BaseClass.apiToken(env);
	}
	public void apiTesting()
	{
		try
		{
		ONPapiValidations obj = new ONPapiValidations();
		obj.apiPositive(apiToken1);
		}
		catch(Exception e)
		{
			
		}
	}
	

}

package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {
	
	int counter = 0;
	int limit = 2;

	@Override
	public boolean retry(ITestResult result) {
		if(counter<limit)
		{
			counter++;
			return true;			
		}
		
		return false;
	}

}

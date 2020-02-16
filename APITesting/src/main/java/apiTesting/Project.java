package apiTesting;

import org.testng.annotations.DataProvider;

public class Project {
	
	@DataProvider(name="Json",parallel=false)
	public String[] getFileNames()
	{
	    String[] names = new String[2];
	    names[0] = "New ./data1.json";
	    names[1] = "New ./data.json";
	    return names;
	}

}

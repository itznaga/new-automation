package apiTesting;

import java.io.File;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
 
public class APITesting extends Project {
	
	@BeforeMethod
	public void testCase1()
	{
//	     RestAssured.baseURI ="https://dev64481.service-now.com/api/now/table/change_request";
//	     RestAssured.authentication = RestAssured.basic("admin","7QSEbbY9Hnqb");
//	     Response response = RestAssured.get();
//	     JsonPath jsonResp = response.jsonPath();
//	     List<String> list = jsonResp.getList("result.number");
//	     System.out.println("CR Details"+list);
//	     int size1 = list.size();
//	     System.out.println("Total CR"+ size1);
		System.out.println("First Method");
	     
	}
	
	@Test()
	public void testCase2()
	{
//		String desc = "Naga Created CR and Verified";
//		RestAssured.baseURI ="https://dev64481.service-now.com/api/now/table/change_request";
//	     RestAssured.authentication = RestAssured.basic("admin","7QSEbbY9Hnqb");
//	     Response post = RestAssured.given().contentType(ContentType.JSON).body("{\"short_description\" : \""+desc+"\"}").accept(ContentType.JSON).post();
//	     
////	    post.prettyPrint();
//	    JsonPath jsonPath = post.jsonPath();
//	    String object = jsonPath.get("result.short_description");
//	    if(desc.equals(object))
//	    {
//	    System.out.println("Description Verified = "+object);
//	    }
		System.out.println("Second Method");
	}
	Naga created "CR"
	//Using Dataprovider
	
//	@DataProvider(name="Json",parallel=true)
//	public String[] getFileNames()
//	{
//	    String[] names = new String[2];
//	    names[0] = "./data1.json";
//	    names[1] = "./data.json";
//	    return names;
//	}
	@Test(dataProvider="Json")
	public void testCase3(String filenames)
	{
//		File fileName = new File(filenames);
//		RestAssured.baseURI ="https://dev64481.service-now.com/api/now/table/change_request";
//	     RestAssured.authentication = RestAssured.basic("admin","7QSEbbY9Hnqb");
//	     Response post = RestAssured.given().contentType(ContentType.JSON).body(fileName).accept(ContentType.JSON).post();
//	     
////	    post.prettyPrint();
//	    JsonPath jsonPath = post.jsonPath();
//	    String object = jsonPath.get("result.short_description");
//	    
//	    System.out.println("Description Verified = "+object);
		
		System.out.println(filenames);
	    
	}

}

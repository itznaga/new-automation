package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DataLibraryCucumber extends ReportCucmber {
	
	
	public Object[][] readExcelDP(String location) throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook(location);
		XSSFSheet sheet = wb.getSheetAt(0);
		int RowNum = sheet.getLastRowNum();
		int CellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[RowNum][CellNum];
		for(int i=1;i<=RowNum;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<CellNum;j++)
			{
				XSSFCell cell = row.getCell(j);
				String stringCellValue = cell.getStringCellValue();
				obj[i-1][j] = stringCellValue;
			}
		}
		wb.close();
		return obj;
	}
	public List<String> readExcel(String location) throws InvalidFormatException, IOException
	{
		List<String> dataFromExcel = new ArrayList<String>();
		XSSFWorkbook workbook = new XSSFWorkbook(new File(location));
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String addServices = cell.getStringCellValue();
				dataFromExcel.add(addServices);
			}
		}
		workbook.close();
		return dataFromExcel;
	}
	public void writeFile(String FileName, String text) throws IOException
	{
		try
		{
			File textfile = new File(System.getProperty("user.dir"),FileName);
			if(textfile.exists())
			{
				textfile.delete();
				textfile.createNewFile();
			}
			FileWriter writer = new FileWriter(textfile); 
			BufferedWriter buffer = new BufferedWriter(writer);  
			buffer.write(text);  
			buffer.close();  
			reportLog("Able to Write "+FileName+" in File", "pass","writeFile");
		}catch(Exception e)
		{
			reportLog("Not able to Write "+FileName+" in File", "fail","writeFile");
		}
	}
	public String readfile(String FileName) throws Throwable
	{
		File textfile = new File(System.getProperty("user.dir"),FileName);
		FileReader in = new FileReader(textfile);
		BufferedReader br = new BufferedReader(in);
		String textfromfile;
		StringBuilder sb=  new StringBuilder();
		while ((textfromfile = br.readLine()) != null) 
		{
			sb.append(textfromfile);
		}
		textfromfile = sb.toString();
		br.close();
		return textfromfile;
	}
//	public String takeScreenshot(String name){
//		try {
//			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+name+".jpg"));
//		} catch (WebDriverException e) {
//			System.out.println("The browser has been closed.");
//		} catch (IOException e) {
//			System.out.println("The snapshot could not be taken");
//		}
//		return name;
//	}

}

package javaPrgrm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		//		List<String> readExcel1 = readExcel("./data/services.xlsx");
		//		System.out.println(readExcel1);
		driverData("./data/dataDriver.xlsx");
	}
	public static List<String> readExcel(String location) throws InvalidFormatException, IOException
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
	public static Object[][] readExcelDP(String location) throws IOException, InvalidFormatException
	{
		XSSFWorkbook wb = new XSSFWorkbook(new File(location));
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

	public static void driverData(String locaiton) throws InvalidFormatException, IOException
	{
		Object[][] object = readExcelDP(locaiton);
		int length = object.length;//Row count without 1st Row because in readExcel we start from row 1
		int length2 = object[0].length;//Column count
		List<String> str = new ArrayList<String>();
		List<String> str1 = new ArrayList<String>();
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<length2;j++)
			{
				if(object[i][j].toString().equalsIgnoreCase("Y"))
				{
					Object tags = object[i][length2-1];
					str.add(tags.toString());
					Object tags1 = object[i][length2-2];
					str1.add(tags1.toString());

				}
			}
		}
		System.out.println("Tags ="+str);
		System.out.println("Feature file="+str1);
	}


}

package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
	    readExcel obj = new readExcel();
	    Object[][] readExcel1 = readExcel1("./data/services.xlsx");

	}
	public static  Object[][] readExcel1(String location) throws InvalidFormatException, IOException
	{
		
		XSSFWorkbook workbook = new XSSFWorkbook(new File(location));
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] list = new Object[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<cellCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				String addServices = cell.getStringCellValue();
				list[i-1][j] = addServices;
			}
		}
		List<String> list1 = new ArrayList<String>();
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				 String string = list[i-1][j].toString();
				 list1.add(string);
			}
		}
		System.out.println(list1);
		workbook.close();
		return list;
		
	}

}

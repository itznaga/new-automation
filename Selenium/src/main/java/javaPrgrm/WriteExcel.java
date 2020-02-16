package javaPrgrm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws Exception {
		writeExcel();
		WriteExcel obj = new WriteExcel();
		obj.copyExcel("./data/WriteExcel1.xlsx");

	}
	public static void writeExcel() throws IOException, InvalidFormatException{		
		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( " Employee Info ");
		XSSFRow row;
		Map < String, String[] > empinfo = new TreeMap < String, String[] >();
		empinfo.put( "1", new String[] {
				"EMP ID", "EMP NAME", "DESIGNATION" });

		empinfo.put( "2", new String[] {
				"tp01", "Gopal", "Technical Manager" });

		empinfo.put( "3", new String[] {
				"tp02", "Manisha", "Proof Reader" });

		empinfo.put( "4", new String[] {
				"tp03", "Masthan", "Technical Writer" });

		empinfo.put( "5", new String[] {
				"tp04", "Satish", "Technical Writer" });

		empinfo.put( "6", new String[] {
				"tp05", "Krishna", "Technical Writer" });
		
		empinfo.put( "7", new String[] {
				"tp05", "Krishna", "Technical Writer" });
		int rowid = 0;
		for(Entry<String,String[]> value:empinfo.entrySet())
		{
			int cellid = 0;
			row = spreadsheet.createRow(rowid++);
			String[] value2 = value.getValue();
			for(String str:value2)
			{
				Cell cell = row.createCell(cellid++);
				cell.setCellValue(str);
			}
		}
		FileOutputStream out = new FileOutputStream(
				new File("./data/WriteExcel1.xlsx"));

		workbook.write(out);
		out.close();
		workbook.close();
		System.out.println("Excel written successfully");
	}
	public void copyExcel(String location) throws Exception
	{
		ReadExcel rd = new ReadExcel();
		Object[][] object = rd.readExcelDP(location);
		int length = object.length;
		int length2 = object[0].length;
		//Create blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		//Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet( " Employee Info 12");
		XSSFRow row;
		int cellid = 0;
		int rowid = 0;


		for(int i=0;i<length;i++)
		{
			row = spreadsheet.createRow(i);

			for(int j=0;j<length2;j++)
			{

				Cell cell = row.createCell(j);
				cell.setCellValue((object[i][j]).toString());
			}

		}
		FileOutputStream out = new FileOutputStream(
				new File("./data/WriteExcel2.xlsx"));

		workbook.write(out);
		out.close();
		workbook.close();
		System.out.println("Excel written successfully");
	}
	
}

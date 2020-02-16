package week1.day1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class summa {

	public static void main(String[] args) throws IOException {
		writeFile("testfile1","test123");

	}
	public static void writeFile(String FileName, String text) throws IOException
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
	}

}

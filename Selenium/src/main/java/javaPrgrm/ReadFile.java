package javaPrgrm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		 File file = new File("C:\\Users\\WELCOME\\Desktop\\selenium.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  List<String> words = new ArrayList<String>();
		  while ((st = br.readLine()) != null) 
		  {
			  words.add(st);
		    System.out.println(st); 
		  }
		  System.out.println(words);
		  String str ="";
		  for(int i=0; i<words.size();i++)
		  {
			  str=str+(words.get(i));
			
		  }
		  System.out.println(str);
		   

	}

}

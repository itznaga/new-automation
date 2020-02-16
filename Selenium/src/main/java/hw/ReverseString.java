package hw;

import java.util.ArrayList;
import java.util.List;

public class ReverseString {

	public static void main(String[] args) {
		String[] companies = {"HCL" , "Cognizant" , "TCS" , "Infosys" , "Accenture" };
		List<String> companiesreverse = new ArrayList<String>();
		for(int i=0;i<companies.length;i++)
		{
		companiesreverse.add(companies[i]);
		}
		int j =0;
		for(j=companiesreverse.size();j>0;j--)
		{
		String reverse = companiesreverse.get(j-1);
		System.out.print(reverse+" ");
		}
	}

}

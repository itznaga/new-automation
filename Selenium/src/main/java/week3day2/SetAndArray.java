package week3day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetAndArray {

	public static void main(String[] args) {
		String duplicate = "Infosys Limited";
		char[] duplicateCharArray = duplicate.toCharArray();
		Set<Character> duplicateSet = new LinkedHashSet<Character>();
		for(int i=0;i<duplicate.length();i++)
		{
		boolean add = duplicateSet.add(duplicateCharArray[i]);
		if(add==false)
		{
			System.out.print(duplicateCharArray[i]);
		}
		}
		System.out.println();
		
		String duplicate1 = "Amazon India Private Limited";
		char[] duplicateCharArray1 = duplicate1.toCharArray();
		Set<Character> duplicateSet1 = new LinkedHashSet<Character>();
		System.out.println();
		for(int i=0;i<duplicate1.length();i++)
		{
		boolean add = duplicateSet1.add(duplicateCharArray1[i]);
		if(add==true)
		{
			System.out.print(duplicateCharArray1[i]);
		}
		}
	}

}

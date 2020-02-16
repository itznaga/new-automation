package hw;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PrintUniqueCharacters {

	public static void main(String[] args) {
		String duplicate = "Infosys Limited";
		char[] duplicateCharArray = duplicate.toCharArray();
		List<Character> unique = new ArrayList<Character>();
		for(int i=0;i<duplicateCharArray.length;i++)
		{
			unique.add(duplicateCharArray[i]);
		}
		Set<Character> duplicateSet = new LinkedHashSet<Character>();
		List<Character> duplicatewords = new ArrayList<Character>();

		for(int i=0;i<duplicateCharArray.length;i++)
		{
			boolean add = duplicateSet.add(duplicateCharArray[i]);
			if(add==false)
			{
				duplicatewords.add(duplicateCharArray[i]);
			}
		}
		System.out.println("Given String ="+ duplicate);
		System.out.println("Duplicate Words in Given String ="+ duplicatewords);
		for(int i=0;i<unique.size();i++) 
		{
			for(int j=0;j<duplicatewords.size();j++)
			{
				unique.remove(duplicatewords.get(j));
				
			}			
		}
		
		for(int i=0;i<unique.size();i++)
		{
			Character character = unique.get(i);
			System.out.print(character);
		}
		
		}
 
	}

package hw;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SecondMostDuplicate {

	public static void main(String[] args) {
		String s="PayPal India";
		Set<Character> unique = new LinkedHashSet<Character>();
		List<Character> duplicateWords = new ArrayList<Character>();
		for(int i=0;i<s.length();i++)
		{
			boolean duplicateWord = unique.add(s.charAt(i));
			if(duplicateWord==false)
			{
				duplicateWords.add(s.charAt(i));
			}
		}
		System.out.println("Given String = "+s);
		System.out.println("Duplicate Words = "+duplicateWords);
		List<Character> Alphabet = new ArrayList<Character>();
		int count =0;
		for(char c='a';c<='z';c++)
		{
			Alphabet.add(c);
		}
		for(char c='A';c<='Z';c++)
		{
			Alphabet.add(c);
		}
		for(int i=0;i<Alphabet.size();i++)
		{
			for(int j=0;j<duplicateWords.size();j++)
			{
				if(duplicateWords.get(j)==Alphabet.get(i))
				{
					count++;
				}
			}
			if(count!=0)
			{
				System.out.println(Alphabet.get(i)+"="+count);
				if(count<duplicateWords.size()-1)
				{
					System.out.println(Alphabet.get(i));
				}
				count=0;
			}
		}
	}

}

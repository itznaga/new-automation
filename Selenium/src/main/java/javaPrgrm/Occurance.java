package javaPrgrm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Occurance {
	public static void main(String[] args)
	{
		Occurance obj = new Occurance();
		obj.occuranceOfChar();
	}
	public void occuranceOfChar()
	{
		String s ="Tata Mottorso";
		System.out.println("Given String = "+s);
		Map<Character,Integer> numChars = new LinkedHashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char charAt = s.charAt(i);
			if(!numChars.containsKey(charAt))
			{
				numChars.put(charAt, 1);
			}
			else
			{
				numChars.put(charAt, numChars.get(charAt)+1);
			}
		}
		System.out.println(numChars);
		Set<Integer> intg = new TreeSet<Integer>();		
		
		for(Entry<Character, Integer> entry: numChars.entrySet()) {
	        Integer value = entry.getValue();
	        intg.add(value);
		}
		List<Integer> li = new ArrayList<Integer>(intg);
		int size = li.size();
		Integer integer = li.get(size-1);
		System.out.println("Highest Repeating Count="+integer);
		
		for(Entry<Character, Integer> entry: numChars.entrySet()) {
			 if (entry.getValue().equals(integer)) {
				 System.out.println(entry.getKey());          
	                               
		}		
	}
	}
}

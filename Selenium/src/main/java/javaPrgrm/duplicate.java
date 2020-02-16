package javaPrgrm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class duplicate {
	public static void main(String[] args)
	{
		duplicate oj = new duplicate();
				oj.duplicate1();
		//		oj.duplicate2();
		oj.dupWithoutSet();
	}
	//Duplicate by character
	public void duplicate1()
	{
		String s = "1,3,3,5,8,8,8,9,0,0";
		System.out.println("Given String is = "+s);
		char[] charArray = s.toCharArray();
		Set<Character> set1 = new LinkedHashSet<Character>();
		Set<Character> set2 = new LinkedHashSet<Character>();
		for(int i=0;i<charArray.length;i++)
		{
			boolean add = set1.add(charArray[i]);
			if(add==false)
			{
				set2.add(charArray[i]);
			}
		}
		List<Character> l1 = new ArrayList<Character>(set2);
		System.out.println("Duplicate characters= "+l1);
		for(int i=0;i<l1.size();i++)
		{
			set1.remove(l1.get(i));
		}
		System.out.println("Only Unique Characters= "+set1);
	}

	//Duplicate by Words

	public void duplicate2()
	{
		String[] s = {"Yamaha", "Yamaha" , "Honda" , "Bajaj" , "Bajaj"};
		System.out.println("Given string is = "+s);
		Set<String> set3 = new LinkedHashSet<String>(); 
		List<String> onlyDup = new ArrayList<String>();
		for(int i=0;i<s.length;i++)
		{
			boolean add = set3.add(s[i]);
			if(add==false)
			{
				onlyDup.add(s[i]);
			}
		}
		System.out.println("Only Duplicates = "+onlyDup);
		for(int i=0;i<onlyDup.size();i++)
		{
			set3.remove(onlyDup.get(i));
		}
		System.out.println("Only unqiue = "+set3);

	}

	//Duplicate without set
	public void dupWithoutSet()
	{
		String str = "a,b,b,d,e,e,e,j,j,k,k,t,t,t,t,q";
		StringBuilder sb = new StringBuilder();
		String str1 = "";
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(str.charAt(i)==str.charAt(j) && str.charAt(i) != ',')
				{
					char charAt = str.charAt(i);
					sb.append(charAt);
					String s = charAt+"";
					str1=str1.concat(s);

				}

			}
		}
		System.out.println("Duplicate character = "+str1);
		System.out.println("Duplicate character = "+str1);

}
}

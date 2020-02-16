package javaPrgrm;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByLen {

	public static void main(String[] args)
	{
		String str = "My name is Nagasamy";
		String[] split = str.split(" ");
		List<String> li = new ArrayList<String>();
		for(int i=0;i<=split.length;i++)
		{
			for(int j=i+1;j<split.length;j++)
			{
				int length = split[i].length();
				System.out.println(length);
				int length2 = split[j].length();
				System.out.println(length2);
				if(split[i].length()<split[j].length())
				{
					li.add(split[i]);	
				}
			}
		}
		System.out.println(li);
	}

}

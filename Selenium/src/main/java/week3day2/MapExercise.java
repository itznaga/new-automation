package week3day2;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class MapExercise {

	public static void main(String[] args) {
		String words = "AmazonIndiaPrivateLimited";
		char[] charArray = words.toCharArray();
		int k=0;
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		for(char c : charArray)
		{
			if(map.containsKey(c)) {
				Integer value = map.get(c);
				map.put(c,value+1 );
			}else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
	}

}

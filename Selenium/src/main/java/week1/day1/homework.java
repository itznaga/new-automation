package week1.day1;

public class homework {

	public static void main(String[] args) {
		//HW1
		String words = new String("Welcome to Automation World.");
		for(int i=0;i<words.length();i++)
		{
			char c1=words.charAt(i);
			if(c1=='e')
			{

			}
			else
			{
				System.out.print(c1);
			}
		}
		//HW2
		String wordshw2= new String("Amazon India Private Limited");
		int sum =0;
		int k=1;
		for(int i=0;i<wordshw2.length();i++)
		{ 
			char c1=wordshw2.charAt(i);
			if(c1=='a' || c1=='e' || c1=='i' || c1=='o' || c1=='u' || c1=='A' || c1=='E' || c1=='I' || c1=='O' || c1=='U')
			{
				sum = k++;
			}
		}
		System.out.println();
		System.out.println(sum);
		//HW3
		String palindrome= new String("MalayalaM");
		int j=0;
		for(int i=palindrome.length()-1;i>=0;i--)
		{
			char c3=palindrome.charAt(i);
			char c4=palindrome.charAt(j);
			if(c3==c4)
			{
				j++;
			}
		}
		if(j==palindrome.length()) {
			System.out.println("The given String is Palindrome");
		}
		else {
			System.out.println("The given String is NOT Palindrome");
		}
		//HW4
		String test=new String("test");
		for(int i=0;i<test.length();i++)
		{
			char c5=test.charAt(i);
			if(i%2==0 || i==0)
			{
				String c6=c5+"";
				String c7=c6.toUpperCase();
				System.out.print(c7);
			}
			else {
				System.out.print(c5);
			}
		}
		String input = "Welcome Home";
		String replaceAll = input.toLowerCase().replaceAll("e", "");
		System.out.println();
		System.out.println(replaceAll);	
		//HW5
		String[] names= {"Shankar","Shakti","Ram"};
		for(int i=0;i<names.length;i++)
		{
			if(names[i].startsWith("S") && names[i].endsWith("i"))
			{
				System.out.println("Names Starts with S and Ends with I is " + names[i]);
			}
		}
		//HW6
		String str1="Welocme to the new world";
		String str2=str1.substring(0,18);
		String str4=str1.substring(19,str1.length());
		String str3=str2.concat(" Automation ").concat(str4);
		System.out.println(str3);

	}

}



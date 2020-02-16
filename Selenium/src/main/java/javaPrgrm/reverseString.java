package javaPrgrm;

public class reverseString {
	public static void main(String[] args)
	{
		reverseString oj = new reverseString();
		oj.reverse1();
		oj.reverse2();
		oj.reverse3();
	}
	//Reverse each character
	public void reverse1()
	{
	String s = "This is Selenium";
	for(int i=s.length()-1;i>=0;i--)
	{
		System.out.print(s.charAt(i));		
	}
	}
	
	//Reverse by Words
	public void reverse2()
	{
	String s = "This is Selenium";
	String[] split = s.split(" ");
	for(int i=split.length-1;i>=0;i--)
	{
		System.out.println();
		System.out.print(split[i]);
		System.out.println();
	}
	}
	
	//Reverse using String Builder Method
	public void reverse3()
	{
		StringBuilder s = new StringBuilder("This is Selenium");
		System.out.println(s.reverse());
	}
	
	

}

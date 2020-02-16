package hw;

public class StringExcersice {

	public static void main(String[] args) {
		StringExcersice obj = new StringExcersice();
		obj.immutable();
		obj.regExp();
		
		
	}
	public void regExp()
	{
	String s = "12#$aabbb%32AA";
	String onlyNum = s.replaceAll("[^0-9]", "");
	System.out.println("Numbers in the given String =" +onlyNum);
	int numLength = onlyNum.length();
	System.out.println("There are "+numLength+" numbers in the given string");
	String specialChars = s.replaceAll("[^#$%]", "");
	System.out.println("Special Characters in the given String =" +specialChars);
	int specialCharLen = specialChars.length();
	System.out.println("There are "+specialCharLen+" Special Characters in the given string");
	String onlyChar= s.replaceAll("[^a-z A-Z]", "");
	System.out.println("Characters in the given String =" +onlyChar);
	int charsLen = onlyChar.length();
	System.out.println("There are "+charsLen+" Characters in the given string");
	String s1 = "123";
	for(int i=0;i<s1.length();i++)
	{
		 Character.isAlphabetic(s1.charAt(i));

		System.out.println("Given String has only numbers ="+s1.charAt(i));
	}
	}
	public void immutable()
	{
	String str = "Naga";
	str.concat("samy");
	System.out.println(str);
	
	String str1 = "Naga";
	str1=str1.concat("samy");
	System.out.println(str1);
	
	StringBuilder sb = new StringBuilder("Mr ");
	sb.append("Manivannan ");
	sb.append("Gurusamy");
	System.out.println(sb);
	
			
	}

}

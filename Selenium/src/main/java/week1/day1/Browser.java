package week1.day1;

public class Browser {
	//Variables
	public String browserName = "Chrome";
	public int browserVer = 10;
	public boolean hasIncognitoWindow = true;
	//Method
	public void loadurl(String url) {
		System.out.println("Loading URL is"+ url);
	}
	public String browser(String name) {
		if(name.equals("Chrome"))
			return("launching"+ name);
		else
			return("launching browsers other than Chrome");
	}
	public void browserbuttons() {
		System.out.println("Forward");
		System.out.println("Backward");
		System.out.println("Reload");
	}
	public int browserVersion() {
		return 4;
	}
	public String calc(int num1, int num2) {
		int add=num1 + num2;
		int sub=num1 - num2;
		int multi=num1*num2;
		int div=num1/num2;
		return("Addition ="+add + "Sub Ans =" +sub + "multi Ans =" +multi + "div Ans=" +div);
	}
	public String latestmodel(String carbrand) {
		if(carbrand == "Toyota") {
			return("Latest Model for Toyaota = Fortuner , Innova, LandCruiser");
		}
		else if(carbrand == "Maruti") {
			return("Latest Model for Maruti = Ciaz , Swift , WagonR");
		}
		else {
			return("Only Maruti and Toyota model cars are availble");
		}
	}
	public void browsermodellast() 
	{
		String browser[]= {"Chrome","IE","Firefox","Opera","Safari"};
		for(int i=3;i<browser.length-1;i++)
		{
			System.out.println(browser[i]);
		}
	}
	public void sumofoddinarray() 
	{
		int num[]= {3,10,13,25,40};
		int sum = 0;
		int i=0;
		for(i=0;i<num.length;i++)
		{
			if(num[i]%2!=0) 
			{
				sum=num[i]+sum;
			}
		}
		System.out.println("Sum of odd num" +sum);
	}
	public void primenum() 
	{
		int num=125;
		int i=0;
		for(i=2;i<num;i++)
		{
			if(num%i==0)
			{
				System.out.println("Given num "+num+" is not Prime");
				break;
			}
		}
		if(i==num || num ==1)
			System.out.println("Given num"+num+" is Prime");
	}
	public void reversebychar()
	{
		String txt="I am a Self Motivator";
		char reverchar[]=txt.toCharArray();
		for(int i=reverchar.length-1;i>=0;i--)
		{
			System.out.print(reverchar[i]);
		}
	}
	public void  reversebywords()
	{
		String txt="I am a self Motivator";
		String allwords[]=txt.split(" ");
		System.out.println();
		for(int i=allwords.length-1;i>=0;i--)
		{
			System.out.print(allwords[i]);
		}
	}
	
}



package javaPrgrm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {

	public static void main(String[] args)
	{
		Numbers obj = new Numbers();
		obj.maxAndMin();
		obj.sumofeveninarray();
		obj.sumofoddinarray();
		obj.primenum();

	}
	public void maxAndMin()
	{
		int[] i= {123,678,124,45};
		Set<Integer> set1 = new HashSet<Integer>();
		for(int j=0;j<i.length;j++)
		{
			set1.add(i[j]);
		}
		List<Integer> li = new ArrayList<Integer>(set1);
		int size = li.size();
		System.out.println("Maximum number is ="+li.get(0));
		System.out.println("Minimum number is ="+li.get(size-1));


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
	public void sumofeveninarray() 
	{
		int num[]= {3,10,13,25,40};
		int sum = 0;
		int i=0;
		for(i=0;i<num.length;i++)
		{
			if(num[i]%2==0) 
			{
				sum=num[i]+sum;
			}
		}
		System.out.println("Sum of even num" +sum);
	}
	public void primenum() 
	{
		int num=127;
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
			System.out.println("Given num ="+num+" is Prime");
	}

}

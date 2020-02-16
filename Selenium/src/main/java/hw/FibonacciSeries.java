package hw;

public class FibonacciSeries {

	public static void main(String[] args) {
		int nextnum=1;
		int previousNum=0;
		int maxNum = 10;
		for(int j=1;j<maxNum;j++)
		{
			int num=nextnum + previousNum;
			previousNum = nextnum;
			nextnum = num;
			System.out.print(previousNum);
			
		}

	}

}

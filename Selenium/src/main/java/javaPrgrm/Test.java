package javaPrgrm;

public class Test {

	public static void main(String[] args) {
		int n = 279;
		String str = Integer.toString(n);
		int nr = 0;
	    for(int i=0;i<str.length();i++)
	    {
	    	char chr1 = str.charAt(i);
	    	int nr1 = chr1-'0';
	    	nr = nr + nr1;
	    }
	    System.out.print(n);
	    System.out.print(nr);

	}

}

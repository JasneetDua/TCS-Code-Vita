//	Codu And Sum Love 
//	Problem Description
//	```
//	
//	Scanner sc = new Scanner(System.in);
//	
//	long sum = 0;
//	
//	int N = sc.nextInt();
//	
//	for (int i = 0; i < N; i++) {
//	
//	final long x = sc.nextLong(); // read input
//	
//	String str = Long.toString((long) Math.pow(1 << 1, x));
//	
//	str = str.length() > 2 ? str.substring(str.length() - 2) : str;
//	
//	sum += Integer.parseInt(str);
//	
//	}
//	
//	System.out.println(sum%100);
//	
//	```
//	
//	Given N number of x’'s, perform logic equivalent of the above Java code and print the output
//	
//	Constraints
//	 1<=N<=10^7 0<=x<=10^18
//	
//	Input Format
//	 First line contains an integer N 
//	
//	Second line will contain N numbers delimited by space
//	
//	Output
//	 Number that is the output of the given code by taking inputs as specified above
//	
//	
//	Explanation
//	Example 1
//	
//	
//	Input
//	 4 8 6 7 4
//	 Output
//	 64
//	
//	Example 2
//	
//	Input
//	
//	3
//	
//	1 2 3
//	
//	Output
//	
//	14
//	


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoduAndSumLove {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		String[] num = br.readLine().trim().split("\\s+");		
		br.close();
		
		long sum = 0;
		
		for (int i = 0; i < n; i++) 
		{
			 sum += (long) (1 << Long.parseLong(num[i])) % 100;
		}

		System.out.println(sum%100);
	}
}

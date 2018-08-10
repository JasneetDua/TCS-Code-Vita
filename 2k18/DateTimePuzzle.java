//	Date Time
//	Problem Description
//	Arun and his sister Usha are challenging each other with some mathematical puzzles. Usha, the cleverer one, has come up with the idea of givingArun 12 distinct digits from 0 to 9, and have him form the largest date time in 2018 with them. Arun is a little nervous, and asks you to help him with a computer program.
//	
//	Usha will give Arun 12 distinct digits. He needs to create a date time combination in the year 2018: the date in the MM/DD form (all four digits must be present), and the time in the format HH:MM (all four digits must be present). The date may be from 01/01 to 12/31 and the time may be from 00:00 to 23:59 (in the 24 hour format). The digits provided may be used only once in the answer that Arun gives.
//	
//	If more than one date time combination may be formed, Arun needs to give the latest valid date time possible in the year 2018.
//	
//	Constraints
//	Single digits (any of 0-9)
//	
//	Input Format
//	A line consisting of a sequence of 12 (not necessarily distinct) single digits (any of 0-9) separated by commas. The sequence will be non-decreasing.
//	
//	Output
//	The maximum possible valid date time in the year 2018. The output must be in the format
//	
//	MM/DD HH:MM
//	
//	If no date time can be constructed, the output should be 0
//	
//	
//	Explanation
//	Example1 :
//	
//	Input
//	
//	0,0,1,2,2,2,3,5,9,9,9,9
//	
//	Output
//	
//	12/30 22:59
//	
//	Explanation
//	
//	The 12 digits to be used by Arun are given.
//	
//	The maximum valid date time using only the digits given, and with each digit used at most once is
//	
//	12/30 22:59
//	
//	This is the output.
//	
//	Example 2
//	
//	Input
//	
//	3,3,3,3,3,3,3,3,3,3,3,3
//	
//	Output
//	
//	0
//	
//	Explanation
//	
//	As no digit less than 3 is present in the input, a valid month cannot be formed. Hence no valid Date time can be formed with the input digits.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;


public class DateTimePuzzle {
	
	static int[] bucket = new int[10];	

	static String getAns(int max)
	{
		int n0 = max % 10;
		int n1 = max / 10;
		
		for(int j = n1; j >= 0; j--){

			if(bucket[j] > 0 )
			{				
				if(j==n1)
				{
					for(int i = n0 ; i >= 0;i--)
					{		
						if(bucket[i]>0)
						{
							bucket[j]--;
							bucket[i]--;
							return j==0?"0"+i : Integer.toString(j*10+i);
						}	
					}
				}
				else
				{
					for(int i = 9 ; i >= 0;i--)
					{
						if(bucket[i]>0)
						{
							bucket[j]--;
							bucket[i]--;
							return j==0?"0"+i : Integer.toString(j*10+i);
						}	
					}					
				}
			}	
		}
		return "00";
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().trim().split(",");
		br.close();
		
		for(int i=0; i < num.length ; i++ )
		{
			bucket[Integer.parseInt(num[i])]++;
		}
		


		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2018);
		
		
		String mm = getAns(12);
		if(Integer.parseInt(mm)==0){			
			System.out.println(0);
			System.exit(0);
		}
		c.set(Calendar.MONTH, Integer.parseInt(mm));
		String dd = getAns(c.getActualMaximum(c.DAY_OF_MONTH));

		if(Integer.parseInt(dd)==0){			
			System.out.println(0);
			System.exit(0);
		}
		
		String hh = getAns(23);
		String ss = getAns(59);		

		System.out.println(mm+"/"+dd+" "+hh+":"+ss);
	}
}

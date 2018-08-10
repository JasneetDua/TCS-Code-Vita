
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


public class Inverses {

	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> factor = new ArrayList<Integer>();
		int count = 1;
		
		for(int i=2 ; i < num ; i++){
			
			boolean flag = false;
			
			if(num%i==0)
			{
				factor.add(Integer.valueOf(i));
				flag = true;				
			}
			else
			{				
				Iterator<Integer> itr = factor.iterator();
				  
				while(itr.hasNext())
				{  
					   if(i % itr.next()== 0)
					   {
						  factor.add(num);
						  flag = true;
						  break;
					   }  
				}  
			}
			
			if(flag == false)
			{
				count++;
			}	
		}
		
		System.out.println(count);
	}
}

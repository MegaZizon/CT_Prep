package Day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SumOfReminder_10986 {
	public void solution() throws Exception{
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();
		int divider = sc.nextInt();

		long sum_arr[] = new long[size];
		long reminder_arr[] = new long[divider];
		long count=0;
		
		
		sum_arr[0]=sc.nextInt();
		for(int i=1; i<size; i++) {
			sum_arr[i] = sum_arr[i-1]+ sc.nextInt();
		}
		
		for(int i=0; i<size; i++) {
			int reminder=(int)(sum_arr[i]%divider);
			if(reminder==0) {
				count++;
			}
			
			reminder_arr[reminder]++;
		}
		
		for(int i=0; i<divider; i++) {
			if(reminder_arr[i]>1) {
				count += (reminder_arr[i]*(reminder_arr[i]-1))/2;
			}
		}
		System.out.println(count);
	}
}

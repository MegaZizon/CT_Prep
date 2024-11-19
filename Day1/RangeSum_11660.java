package Day1;

import java.util.Scanner;

public class RangeSum_11660 {
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int size =sc.nextInt();
		int input = sc.nextInt();
		int arr[][] = new int[size+1][size+1];
		int sum_arr[][] = new int[size+1][size+1];
		int answer[]= new int[input];
		
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for(int i=1; i<=size; i++) {
			for(int j=1; j<=size; j++) {
				sum_arr[i][j]=sum_arr[i-1][j]+sum_arr[i][j-1]-sum_arr[i-1][j-1]+arr[i][j];
			}
		}
		
		for(int i=0; i<input; i++) {
			int x1 =sc.nextInt();
			int y1 =sc.nextInt();
			int x2 =sc.nextInt();
			int y2 =sc.nextInt();
			
			int value=sum_arr[x2][y2]-sum_arr[x2][y1-1]-sum_arr[x1-1][y2]+sum_arr[x1-1][y1-1];
			
			System.out.println("value = "+value);
			
		}		
		
		
		
	}
}

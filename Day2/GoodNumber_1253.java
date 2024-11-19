package Day2;

import java.util.Arrays;

import java.util.Scanner;

public class GoodNumber_1253 {
	public void mySolution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int sum,start_index,end_index;
		int cnt = 0 ;
		
		for(int i=0; i<n; i++) {
			arr[i]= sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i=0; i<n; i++) {
			start_index=0;
			end_index=n-1;
			sum=0;
			while(start_index<end_index) {
				if(i==start_index) {
					start_index++;
					continue;
				}else if(i==end_index) {
					end_index--;
					continue;
				}
				
				sum=arr[start_index]+arr[end_index];
				if(sum>arr[i]) {
					end_index--;
				}else if(sum<arr[i]) {
					start_index++;
				}else {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}

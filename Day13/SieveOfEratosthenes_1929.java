package Day13;

import java.util.Scanner;

public class SieveOfEratosthenes_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int arr[] = new int[N+1];
		

		
		for(int i=2; i<=N; i++) {
			int sum = i;
			if(arr[i]==0) {
				for(int j=2; ; j++) {
					sum= i*j;
					if(sum>N) {
						break;
					}
					arr[sum]=1;
				}
			}
			
		}
		for(int i=M; i<=N; i++) {
			if(i==0 || i==1) {
				continue;
			}
			
			
			if(arr[i]==0)
				System.out.println(i);
		}
		
	}

}

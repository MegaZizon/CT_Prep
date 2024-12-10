package Day15;

import java.util.Scanner;

public class PrimeNotSqrt_1016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long MM = sc.nextLong();
		long NN = sc.nextLong();
		int N = (int)Math.sqrt(NN);
		int arr[]=new int[N+1];
		
		for(int i=0; i<=N; i++) {
			arr[i]=i;
		}
		
		for(int i=2; i<=N; i++) {
			if(arr[i]==i) {
				for(int j=i+i; j<=N; j+=i) {
					arr[j]=0;
				}
			}
		}
		long count = 0 ;
		for(int i=2; i<=N; i++) {
			long temp = i;
			if(i<=(double)NN/i && i>=(double)MM/i) {
				count++;
				System.out.print(i*i+" ");
			}
		}
		
		System.out.println(NN-count);
		
	}

}
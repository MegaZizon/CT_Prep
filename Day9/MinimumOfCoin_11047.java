package Day9;

import java.util.Scanner;

public class MinimumOfCoin_11047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int value = sc.nextInt();
		int cnt=0;
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=N-1; i>=0; i--) {
			if(value/arr[i]>0) {
				cnt += value/arr[i];
				value=value%arr[i];
			}
		}
		System.out.println(cnt);
	}

}

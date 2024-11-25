package Day9;

import java.util.Scanner;

public class FindKInArray_1300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int start = 1;
		int end = K;
		int answer = 0;
		while(start<=end) {
			int middle = (start+end)/2;
			int sum=0;
			for(int i=1; i<=N; i++) {
				sum += Math.min(middle/i, N);
			}
			
			if(sum<K) {
				start = middle+1;
			}else {
				answer = middle;
				end=middle-1;
			}
		}
		System.out.println(answer);
	}

}

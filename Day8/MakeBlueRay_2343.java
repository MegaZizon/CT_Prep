package Day8;

import java.util.Scanner;

public class MakeBlueRay_2343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int endIndex=0,startIndex=0;
		
		for(int i=0; i<N; i++) {
			arr[i]= sc.nextInt();
			endIndex+=arr[i];
			if(startIndex<arr[i]) {
				startIndex=arr[i];
			}
		}
		
		int max = endIndex;
		
		while(startIndex<=endIndex) {
			int middle = (startIndex+endIndex)/2;
			int sum = 0;
			int cnt = 0;
			for(int i=0; i<N; i++) {
				sum += arr[i];
				if(sum>middle) {
					cnt++;
					sum = arr[i];
				}
			}
			if(cnt>M-1) {
				startIndex=middle+1;
			}else {
				if(max>middle) {
					max=middle;
				}
				endIndex=middle-1;
			}
		}
		System.out.println(max);
		
		
		
		
//		int answer=0;
//		int cnt=0;
//		int sum=0;
//		boolean lastChance=false,find=false;
//		int minSum=0;
//		
//		for(int i=max; i<=hap; i++) {
//			sum=0;
//			cnt=0;
//			lastChance=false;
//			
//			for(int j=0; ; j++) {
//				sum += arr[j];
//				
//				if(lastChance && sum>i) {
//					break;
//				}else if(lastChance && j==N-1) {
//					find = true;
//					break;
//				}
//				
//				if(sum>i) {
//					cnt++;
//					sum=arr[j];
//					if(cnt==M-1) {
//						lastChance=true;
//					}
//				}
//				
//			}
//			if(find) {
//				answer=i;
//				break;
//			}
//		}
//		System.out.println(answer);
		
	}

}

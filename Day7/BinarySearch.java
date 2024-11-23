package Day7;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
	  	
		Scanner sc = new Scanner(System.in);
		long N =sc.nextLong();
		long arr[] = new long[(int)N];
		
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextLong();
		}
		
		Arrays.sort(arr);
		
		long M = sc.nextLong();
		long find[] = new long[(int)M];
		
		for(int i=0; i<M; i++) {
			find[i]=sc.nextLong();
		}
		
		for(int i=0; i<M; i++) {
			long start = 0;
			long end = N-1;
			while(true) {
				long middle=(start+end)/2;
				if(start>end && arr[(int)middle]!=find[i]) {
					System.out.println("0");
					break;
				}
				if(arr[(int)middle]==find[i]) {
					System.out.println("1");
					break;
				}else if(arr[(int)middle]<find[i]) {
					start = middle+1;
				}else {
					end = middle-1;
				}
			}
			
		}
		
	}

}

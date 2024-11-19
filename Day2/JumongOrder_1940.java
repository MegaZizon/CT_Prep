package Day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumongOrder_1940 {
	public void mySolution() throws Exception{ // 시간복잡도 ERROR
		boolean checkSum[] = new boolean[100000];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long sum = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		long arr[] = new long[(int)n];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		if(arr[0]==sum && n==1) {
			count++;
		}
		
		for(int i=0; i<n-1; i++) {
			
			
			for(int j=i+1; j<n; j++) {
				if(checkSum[j] == true || checkSum[i]==true) {
					continue;
				}
				
				if(arr[i]+arr[j]==sum) {
					count++;
					checkSum[j] = true;
					checkSum[i] = true;
					break;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	public void bookSolution() throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		long n = Long.parseLong(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		long sum = Long.parseLong(st.nextToken());
//		st = new StringTokenizer(br.readLine());
//		long arr[] = new long[(int)n];
//		int start_index = 0,end_index=0,count=0;
//		end_index=(int)n - 1;
//		for(int i=0; i<n; i++) {
//			arr[i]=Long.parseLong(st.nextToken());
//		}
//		
//		Arrays.sort(arr);
//		
//		
//		
//		while(start_index<end_index) {
//			if(sum==arr[0] && n==1) {
//				count++;
//				break;
//			}
//			if(arr[start_index]+arr[end_index]==sum) {
//				count++;
//				start_index++;
//				end_index--;
//			}else if(arr[start_index]+arr[end_index]<sum) {
//				start_index++;
//			}else if(arr[start_index]+arr[end_index]>sum) {
//				end_index--;
//			}
//		}
//
//		System.out.println(count);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(bf.readLine());
	    int M = Integer.parseInt(bf.readLine());
	    int[] A = new int[N];
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    for (int i = 0; i < N; i++) {
	      A[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(A);
	    int count = 0;
	    int i = 0;
	    int j = N - 1;
	    while (i < j) {
	      if (A[i] + A[j] < M) {
	        i++;
	      } else if (A[i] + A[j] > M) {
	        j--;
	      } else {
	        count++;
	        i++;
	        j--;
	      }
	    }
	    System.out.println(count);
	    bf.close();
	}
}

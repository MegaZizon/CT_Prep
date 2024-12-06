package Day14;

import java.util.Scanner;

public class AlmostPrimeNum_1456 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long MM = sc.nextInt();
		long NN = sc.nextInt();
		int M = (int)Math.sqrt(MM);
		int N = (int)Math.sqrt(NN);
		
		int arr[] = new int[(int)(N+1)];
		
		for(int i=M; i<=N; i++) {
			arr[i]=i;
		}
		int count = 0;
		for(int i=2; i<=N; i++) {
			int sum = i;
			if(arr[i]==i) {
				for(int j=2; ; j++) {
					sum= i*j;
					if(sum>Math.sqrt(N)) {
						break;
					}
					arr[sum]=-1;
				}
				if(i*i<=NN && i*i>=MM) {
					System.out.print(i*i+" ");
					count++;
				}
			}
			
		}
		
		System.out.println(count);
	}

}

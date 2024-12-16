package Day15;

import java.util.Scanner;

public class PrimeNotSqrt_1016 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long MM = sc.nextLong();
		long NN = sc.nextLong();
		boolean arr[]=new boolean[(int)(NN-MM+1)];
		
		for(long i=2; i*i<=NN; i++) {
			
			long pow = i*i;
			long start;
			if(MM%pow==0) {
				start = MM;
			}else {
				start = MM+pow-(MM%pow);
			}
			for(long j=start; j<=NN; j+=pow) {
				arr[(int)(j-MM)] = true;
			}
			
		}
		
		long count=0;
		for(long i=0; i<=NN-MM; i++) {
			if(!arr[(int)i]) {
				count++;
			}
		}
		System.out.println(count);
		
	}

}

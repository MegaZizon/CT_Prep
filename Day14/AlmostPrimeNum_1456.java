package Day14;
import java.util.Scanner;

public class AlmostPrimeNum_1456{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long MM = sc.nextLong();
		long NN = sc.nextLong();
		int M = (int)Math.sqrt(MM);
		int N = (int)Math.sqrt(NN);
		
		long arr[];
		
		arr = new long[(int)(N+1)];
		
		
		
		for(int i=0; i<=N; i++) {
			if(i==0||i==1) {
				arr[i]=-1;
			}
			arr[i]=i;
		}
		
		for(int i=2; i<=N; i++) {
			long sum = i;
			if(arr[i]==i) {
				for(int j=2; ; j++) {
					sum= i*j;
					if(sum>Math.sqrt(NN)) {
						break;
					}
					arr[(int)sum]=-1;
				}
			}
		}

		int count = 0;
		
		for(int i=2; i<=N; i++) {
			if(arr[i]!=-1) {
				long sum = i;
				
				while((double)i<=(double)NN/sum) {
					if((double)i>=(double)MM/sum) {
						count++;
					}
					
					sum*=i;
					
				}
			}
		}
		
		System.out.println(count);
	}

}

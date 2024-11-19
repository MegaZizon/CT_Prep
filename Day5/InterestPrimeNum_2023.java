package Day5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class InterestPrimeNum_2023 {

	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->{
		return o1-o2;
	});
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		recall(0,2);
		recall(0,3);
		recall(0,5);
		recall(0,7);
		
		for(int i : pq) {
			System.out.println(i);
		}
		
	}
	
	static boolean isPrimeNum(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}
	
	static void recall(int dept, int num) {
		if(num%2==0 && dept!=0) {
			return ;
		}
		if(!isPrimeNum(num)) {
			return ;
		}
		if(dept == N-1) {
			pq.add(num);
			return ;
		}
		
		for(int i=1; i<10; i+=2) {
			recall(dept+1,num*10+i);
		}
		
	}

}

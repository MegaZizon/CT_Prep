package Day9;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CardSorting_1715 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++) {
			pq.add(sc.nextInt());
		}
		int data1=0,data2=0;
		int sum=0;
		int tempPoll=0;
		
		while(pq.size()!=1) {
			data1 =pq.remove();
			data2 =pq.remove();
			sum += data1+data2;
			pq.add(data1+data2);
		}
		System.out.println(sum);
	}

}

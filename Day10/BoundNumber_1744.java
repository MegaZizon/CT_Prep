package Day10;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BoundNumber_1744 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> arr = new PriorityQueue<>((a,b)->{
			int x=Math.abs(a);
			int y=Math.abs(b);
			
			return y-x;
		});
		ArrayList<Integer> minus = new ArrayList<>();
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Long> bound = new ArrayList<>();

		
		int N = sc.nextInt();

		for(int i=0; i<N; i++) {
			int c = sc.nextInt();
			arr.add(c);
		}
		
		int count = 0 ;
		while(count!=2 && !arr.isEmpty()) {
			int value = arr.poll();
			if(value>0) {
				if(value==1) {
					bound.add(1L);
					continue;
				}
				
				if(!plus.isEmpty()) {
					int value2 = plus.remove(0);
					long l =(long)value2*value;
					bound.add(l);
					count++;
				}else {
					plus.add(value);
				}
			}else if(value<0) {
				if(!minus.isEmpty()) {
					int value2 = minus.remove(0);
					long l =(long)value2*value;
					bound.add(l);
					count++;
				}else {
					minus.add(value);
				}
			}else {
				if(!minus.isEmpty()) {
					int value2 = minus.remove(0);
					long l =(long)value2*value;
					bound.add(l);
				}
				break;
			}
		}
		
		for(int i : minus) {
			arr.add(i);
		}
		for(int i : plus) {
			arr.add(i);
		}
		long sum = 0;
		for(int i : arr) {
			sum+=i;
		}
		for(long i : bound) {
			sum+=i;
		}
		
		System.out.println(sum);
		
	}

}

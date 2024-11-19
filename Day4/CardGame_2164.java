package Day4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CardGame_2164 {
	public void mySolution() {
		Queue<Integer> queue = new LinkedList<>();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		while(true) {
			int value = queue.poll();
			int change;
			if(!queue.isEmpty()) {
				change = queue.poll();
				queue.add(change);
			}
			else{
				System.out.println(value);
				break;
			}
			
		}
		
	}
}

package Day5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AbsoluteHeap_11286 {
	public void mySolution() throws Exception{
		PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
			int fir = Math.abs(o1);
			int sec = Math.abs(o2);
			if(fir == sec) {
				return o1>o2 ? 1:-1;
			}else {
				return fir-sec;
			}
		});
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = bf.readLine();
		int N =Integer.parseInt(s);
		

		
		for(int i=0; i<N; i++) {
			s = bf.readLine();
			int value =Integer.parseInt(s);
			if(value!=0) {
				queue.add(value);
			}else {
				if(queue.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(queue.poll());
				}
			}
		}
		
	}
}

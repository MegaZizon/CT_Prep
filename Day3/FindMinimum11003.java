package Day3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FindMinimum11003 {

	static int check_arr[] = new int[219];
	
	public void mySolution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[]= new int[N];
		int min;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		min = arr[0]+109;
		
		for(int i=0; i<N; i++) {
			boolean check =false;
			check_arr[arr[i]+109]++;
			if(arr[i]+109<=min) {
				min=arr[i]+109;
				check = true;
			}
			
			if(i>=L) {
				check_arr[arr[i-L]+109]--;
				if(arr[i-L]+109==min && check==false) {
					min = whatIsMin(min);
				}
				
			}
			System.out.print((min-109)+" ");
		}
		
		
	}
	public static int whatIsMin(int num) {
		if(check_arr[num]>0) {
			check_arr[num]--;
			return num;
		}
		
		for(int i=num; i<219; i++) {
			if(check_arr[i]>0) {
				return i;
			}
		}
		return 0;
	}
	public void bookSolution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int now;
		Deque<Node> dq = new LinkedList<>();
		String s = "";
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			now = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty() && dq.getLast().value>=now) {
				dq.removeLast();
			}
			
			dq.addLast(new Node(i,now));
			
			if(dq.getFirst().index <= i-L) {
				dq.removeFirst();
			}
			bw.write(dq.getFirst().value+" ");
		}
		bw.flush();
		bw.close();
		
	}
	static class Node{
		public int index;
		public int value;
		Node(int index, int value){
			this.index=index;
			this.value=value;
		}
	}
	
}
















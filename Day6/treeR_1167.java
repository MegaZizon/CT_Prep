package Day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treeR_1167 {
	
	static ArrayList<Integer> ar[] ;
	static boolean visited[] ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int cnt = 0;
		
		ar = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			int j = 0;
			int flag = 0;
			ar[i] = new ArrayList<>();
			i = sc.nextInt();
			while(true) {
				j = sc.nextInt();
				if(flag%2==0) {
					if(j==-1) {
						break;
					}
					cnt++;
				}
				ar[i].add(j);
				
				flag++;
			}
		}
		
		System.out.println(cnt/2+1);

		int start_index;
		int start_value;
		int start_node;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
//		for(int i=1; i<=N; i++) {
//			if(ar[i].size()>=3) {
//				q.add(ar[i].get(1));
//				q.add(ar[i].get(2));
//				break;
//			}
//		}
		
		q.add(3);
		
		while(!q.isEmpty()) {
			int max[] = new int[N+1];
			int index =q.poll();
			int count=1;
			
			visited[index] = true;
			for(int i : ar[index]) {
				int depth;
				count++;
				if(i==-1) {
					break;
				}

				System.out.println(i);
				if(count%2==0) {
					if(!visited[i]) {
						visited[i]=true;
						q.add(i);
					}
				}
				else {
					max[i-1] += i;
				}
				
				
			}
			System.out.println(max[index]);
			
		}

		
		
		
	}

}

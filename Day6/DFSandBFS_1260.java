package Day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFSandBFS_1260 {

	static ArrayList<Integer> []arr;
	static boolean visited[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int edge = sc.nextInt();
		int start = sc.nextInt();
		
		arr = new ArrayList[N+1];
		
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			arr[i] = new ArrayList<>();
			
		}
		
		for(int i=0; i<edge; i++) {
			int in1 = sc.nextInt();
			int in2 = sc.nextInt();

			arr[in1].add(in2);
			arr[in2].add(in1);
		}
		
		DFS(start);
		visited = new boolean[N+1];
		System.out.println();
		BFS(start);
		
	}
	public static void DFS(int visit) {
		if(visited[visit]) {
			return ;
		}
		visited[visit]=true;
		System.out.print(visit+" ");
		arr[visit].sort((o1,o2)->{
			return o1-o2;
		});
		for(int i : arr[visit]) {
			DFS(i);
		}
	}
	
	public static void BFS(int visit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(visit);
		visited[visit]=true;
		
		while(!queue.isEmpty()) {
			int v =queue.poll();
			System.out.print(v+" ");
			for(int i : arr[v]) {
				if(!visited[i]) {
					visited[i]=true;
					queue.add(i);
				}
			}
		}
		
	}

}

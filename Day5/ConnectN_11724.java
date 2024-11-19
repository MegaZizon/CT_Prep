package Day5;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectN_11724 {
	static ArrayList<Integer>[] A;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int edge = sc.nextInt();
		A = new ArrayList[N+1];
		visited = new boolean[N+1];
		int cnt = 0 ;
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i=0; i<edge; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			A[start].add(end);
			A[end].add(start);
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	public static void DFS(int v ) {
		if(visited[v]) {
			return ;
		}
		visited[v]=true;
		for(int i : A[v]) {
			if(!visited[i])
				DFS(i);
		}
	}
	

}

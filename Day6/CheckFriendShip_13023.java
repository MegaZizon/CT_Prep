package Day6;

import java.util.ArrayList;
import java.util.Scanner;


public class CheckFriendShip_13023 {

	static ArrayList<Integer>[] v;
	static boolean visited[];
	static int depth=1;
	static boolean solve = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		

        visited = new boolean[N+1];
		v = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			v[i]=new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			
			v[a].add(b);
			v[b].add(a);
		}
		for(int i=1; i<=N; i++) {
			depth = 1;
			
			DFS(i);
			
			if(solve) {
				System.out.print(1);
				break;
			}
		}
		if(!solve) {
			System.out.print(0);
		}
		
	}
	
	public static void DFS(int index) {
        if(solve || depth==5) {
			solve = true;
			return ;
		}
		
		
		visited[index]=true;
		
		for(int i: v[index]) {
			if(!visited[i]) {
				depth++;
				DFS(i);
				depth--;
			}
		}
		visited[index]=false;
		
	}

}

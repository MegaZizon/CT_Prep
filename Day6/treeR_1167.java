package Day6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class treeR_1167 {
	
	static ArrayList<Node> ar[] ;
	static int visited[] ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int cnt = 0;
		
		ar = new ArrayList[N+1];
		visited = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			
			ar[i] = new ArrayList<>();
			i = sc.nextInt();
			while(true) {
				int j = sc.nextInt();
				if(j==-1){
					break;
				}
				int w = sc.nextInt();
				ar[i].add(new Node(j,w));
				
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		int distance[] = new int[N+1];
		if(ar[1]!=null)
			q.add(1);
	
		while(!q.isEmpty()) {
			int index =q.poll();
			visited[index]=1;
			for(Node i : ar[index]) { 
				if(visited[i.index]==0 && i.index!=index) {
					distance[i.index]=i.weight + distance[index];
					q.add(i.index);
					
				}
			}
		}
		int max=0;
		int max_i=0;
		for(int i=1; i<=N; i++) {
			if(distance[i]>max) {
				max_i = i;
				max=distance[i];
			}
		}
		
		visited = new int[N+1];

		distance = new int[N+1];
		q = new LinkedList<>();
		q.add(max_i);
		while(!q.isEmpty()) {
			int index =q.poll();
			visited[index]=1;
			for(Node i : ar[index]) { 
				if(visited[i.index]==0 && i.index!=index) {
					distance[i.index]=i.weight + distance[index];
					q.add(i.index);
					
				}
			}
		}
		

		max=0;
		max_i=0;
		for(int i=1; i<=N; i++) {
			if(distance[i]>max) {
				max_i = i;
				max=distance[i];
			}
			
		}
		System.out.println(max);

	}
	static class Node{
		int weight;
		int index;
		Node(int i,int w){
			this.index=i;
			this.weight=w;
		}
	}

}

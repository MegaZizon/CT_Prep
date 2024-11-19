package Day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindExit_2178 {
	public static int N;
	public static int M;
	public static boolean visited[][];
	public static boolean [][]road ;
	public static int [][]count ;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		road= new boolean[N+1][M+1];
		visited = new boolean[N+1][M+1];
		count = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String s =  st.nextToken();
			char ss[] = s.toCharArray();
			for(int j=1; j<=M; j++) {
				road[i][j] = ss[j-1]-'0' == 0 ? false : true;
			}
		}
		
		BFS();
		
		System.out.print(count[N][M]);
				
	}
	
	
	public static void BFS() {
		Queue<XY> q = new LinkedList<XY>();
		XY value = new XY(1,1);
		q.add(value);
		count[1][1]=1;
		while(!q.isEmpty()) {
			XY xy=q.poll();
			visited[xy.x][xy.y]=true;
			for(int i=0; i<4; i++) {
				if(i==0) {
					if(xy.x+1>=1 && xy.x+1<=N && xy.y>=1 && xy.y<=M) {
						if(!visited[xy.x+1][xy.y] && road[xy.x+1][xy.y]) {
							visited[xy.x+1][xy.y]=true;
							count[xy.x+1][xy.y]+=count[xy.x][xy.y]+1;
							q.add(new XY(xy.x+1,xy.y));
						}
					}
				}
				if(i==1) {
					if(xy.x-1>=1 && xy.x-1<=N && xy.y>=1 && xy.y<=M) {
						if(!visited[xy.x-1][xy.y] && road[xy.x-1][xy.y]) {
							visited[xy.x-1][xy.y]=true;
							count[xy.x-1][xy.y]+=count[xy.x][xy.y]+1;
							q.add(new XY(xy.x-1,xy.y));
						}
					}
				}
				if(i==2) {
					if(xy.x>=1 && xy.x<=N && xy.y+1>=1 && xy.y+1<=M) {
						if(!visited[xy.x][xy.y+1] && road[xy.x][xy.y+1]) {
							visited[xy.x][xy.y+1]=true;
							count[xy.x][xy.y+1]+=count[xy.x][xy.y]+1;
							q.add(new XY(xy.x,xy.y+1));
						}
					}
				}
				if(i==3) {
					if(xy.x>=1 && xy.x<=N && xy.y-1>=1 && xy.y-1<=M) {
						if(!visited[xy.x][xy.y-1] && road[xy.x][xy.y-1]) {
							visited[xy.x][xy.y-1]=true;
							count[xy.x][xy.y-1]+=count[xy.x][xy.y]+1;
							q.add(new XY(xy.x,xy.y-1));
						}
					}
				}
			}
		}
		
	}
	
	static class XY {
		int x;
		int y;
		public XY(int xx,int yy){
			x = xx;
			y = yy;
		}
	}

}

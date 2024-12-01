package Day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AssignRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> arr = new ArrayList<Point>();
		long max = 0;
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			long s = sc.nextLong();
			long e = sc.nextLong();
			arr.add(new Point(s,e));
			if(e>max) {
				max=e;
			}
		}
		Collections.sort(arr);
		
		long start=0,end=0;
		
//		for(int i=0; i<N; i++) {
//			System.out.print(arr.get(i).end+" ");
//		}
		int count=0;
		for(Point i : arr) {
//			System.out.print(i.start+" "+i.end+" \n");
			if(i.start>=end) {
				end=i.end;
				count++;
			}
		}
		
		
		System.out.println(count);
		
	}
	
	static class Point implements Comparable<Point>{
		long start;
		long end;
		Point(long s,long e){
			start = s;
			end = e;
		}

		public int compareTo(Point p) {
			if(p.end==end) {
				return (int)(this.start-p.start);
			}
			
			return (int)(this.end-p.end);
		}
	}

}

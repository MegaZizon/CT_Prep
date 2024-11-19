package Day2;

import java.util.Scanner;

public class SequenceNatureNumber_2018 {
	public void mySolution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count=0,sum=0,sequence=0,level=1;
				
		for(int i=0; i<n; i++) {
			for(int j=level; ; j++) {
				sum+=j;
				if(sum>=n) {
					if(sum==n) {
						count++;
					}
					sum=0;
					level++;
					break;
				}
			}
		}
		System.out.println(count);
	}
	public void bookSolution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start_index=0,end_index=1,sum=1,count=1;
		while(end_index!=n) {
			
			if(sum<n) {
				end_index++;
				sum+=end_index;
			}else if(sum>n) {
				start_index++;
				sum-=start_index;
			}else{
				end_index++;
				sum+=end_index;
				count++;
			}
		}
		System.out.println(count);
		
	}
}







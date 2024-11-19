package Day4;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class AscStack_1874 {
	public void bookSolution() {
		int pop=0;
		int count=1;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> st = new Stack<Integer>();
		StringBuffer s = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		String S = "";
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int i=0;
		boolean isNo = false;
		while(i<n) {
			if(st.isEmpty() || st.peek()<arr[i]) {
				s.append("+\n");
				st.add(count++);
			}else if(st.peek()==arr[i]) {
				s.append("-\n");
				st.pop();
				i++;
			}else {
				isNo = true;
				break;
			}
		}
		
		if(isNo) {

			System.out.print("NO");
			
		}else {
			System.out.print(s.toString());
		}
		
	}
}

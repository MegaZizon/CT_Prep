package Day4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBigNum_17298 {
	public void mySolution() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		int arr2[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0);
		for(int i=1; i<N; i++) {
			while( (!stack.isEmpty()) && (arr[stack.peek()] < arr[i])) {
				int peek = arr[i];
				int pop = stack.pop();
				arr2[pop]=peek;
			}
			stack.push(i);
		}
		while(!stack.isEmpty()) {
			arr2[stack.pop()] = -1;
		}
		
		for(int i=0; i<N; i++) {
			bw.write(arr2[i]+" ");
		}
		bw.flush();
		bw.close();
		
	}
}

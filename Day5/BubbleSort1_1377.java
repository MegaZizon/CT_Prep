package Day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort1_1377 {
	public void mySolution() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Sdata arr[] = new Sdata[N];
		Sdata s_arr[] = new Sdata[N];
		int max_i = 0;
		int max_v = 0;
		
		for(int i=0; i<N; i++) {
			int a =Integer.parseInt(br.readLine());
			arr[i] = new Sdata(a,i);
			s_arr[i] = new Sdata(a,i);
		}
		
		Arrays.sort(s_arr);
		
		for(int i=0; i<N; i++) {
			if((s_arr[i].index - i >= max_i)) {
				max_i = s_arr[i].index - i;
			}
		}
		System.out.print(max_i+1);
		
	}
	class Sdata implements Comparable<Sdata>{
		int value;
		int index;
		
		Sdata(int v,int i){
			value=v;
			index=i;
		}
		
		public int compareTo(Sdata o){
			return this.value-o.value;
		}
		
	}
}

package Day3;

import java.util.Scanner;

public class DNAPassword_12891 {
	public void mySolution() {
		Scanner sc = new Scanner(System.in);
		int dna_len =sc.nextInt();
		int subString_len = sc.nextInt();
		String s = sc.next();
		int A = sc.nextInt();
		int C = sc.nextInt();
		int G = sc.nextInt();
		int T = sc.nextInt();
		char arr[] = s.toCharArray();
		int ACGT[] = new int[4];
		int count=0;
		
		for(int i=0; i<subString_len; i++) {
			switch(arr[i]) {
			case 'A':
				ACGT[0]++;
				break;
			case 'C':
				ACGT[1]++;
				break;
			case 'G':
				ACGT[2]++;
				break;
			case 'T':
				ACGT[3]++;
				break;
			}
		}
		
		int start_i=0,end_i=subString_len;
		for(int i=0; i<dna_len-subString_len+1; i++) {
			
			if(ACGT[0]>=A && ACGT[1]>=C && ACGT[2]>=G && ACGT[3]>= T) {
				count++;
			}
			if(dna_len-subString_len==i) {
				break;
			}
			
			switch(arr[start_i]) {
			case 'A':
				ACGT[0]--;
				break;
			case 'C':
				ACGT[1]--;
				break;
			case 'G':
				ACGT[2]--;
				break;
			case 'T':
				ACGT[3]--;
				break;
			}
			
			switch(arr[end_i]) {
			case 'A':
				ACGT[0]++;
				break;
			case 'C':
				ACGT[1]++;
				break;
			case 'G':
				ACGT[2]++;
				break;
			case 'T':
				ACGT[3]++;
				break;
			}
			
			
			
			start_i++;
			end_i++;
		}
		
		System.out.print(count);
		
	}
}

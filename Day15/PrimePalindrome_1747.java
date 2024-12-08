package Day15;

import java.util.Scanner;

public class PrimePalindrome_1747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Number= 10000000;
		int arr[]= new int[Number+1];
		
		for(int i=0; i<=Number; i++) {
			arr[i]=i;
		}
		for(int i=2; i<=Number; i++) {
			if(arr[i]==i) {
				for(int j=i+i; j<=Number; j=j+i) {
					arr[j]=0;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=2; i<=100000001; i++) {
			if(arr[i]==i && N<=i) {
				int digit[] = new int[100];
				int num = i;
				int digit_count = Palindrome(i);
				int center = digit_count/2;
				boolean isPass=true;
				
				for(int j=0; j<center; j++) {
					digit[j]=num%10;
					num/=10;
				}
				
				if(digit_count%2!=0) {
					num/=10;
				}
				
				for(int j=center-1; j>=0; j--) {
					if(digit[j]!=num%10) {
						isPass=false;
						break;
					}
					num/=10;
				}
				
				if(isPass) {
					System.out.println(i);
					break;
				}
				
			}
		}
		
	}
	
	public static int Palindrome(int num) {
		int count=0;
		while(num!=0) {
			num/=10;
			count++;
		}
		
		return count;
		
	}

}

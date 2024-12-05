package Day12;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FindMinimumBracket { //괄호를 한번만 쓰는 경우로 잘못 이해함

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String pl = "\\+";
		
		char[] arr =input.toCharArray();
		ArrayList<String> str = new ArrayList<String>();
		String n = "";
		for(int i=0; i<=arr.length; i++) {
			if(i==arr.length) {
				str.add(n);
				break;
			}
			
			if(arr[i]>='0' && arr[i]<='9') {
				n+=arr[i];
			}
			
			if(arr[i]=='+') {
				if(n!="") {
					str.add(n);
					n="";
				}
				str.add("+");
			}else if(arr[i]=='-') {
				if(n!="") {
					str.add(n);
					n="";
				}
				str.add("-");
			}
		}
		
		if(str.get(0)!="-") {
			str.add(0, "+");
		}
		int index=0;
		int sum = 0;

		int nomal = 0;
		int nomal2 = 0;
		for(int i = 0; i<str.size(); i+=2) {
			if(str.get(i)=="+") {
				nomal+=Integer.parseInt(str.get(i+1));
			}else if(str.get(i)=="-"){
				nomal-=Integer.parseInt(str.get(i+1));
			}
		}
		
		
		for(int i=0; i<str.size(); i++) {
			if(str.get(i)=="-") {
				int max = -999999;
				int maxIndex = i;
				int value = 0;
				value+=Integer.parseInt(str.get(i+1));
				for(int j = i+2; j<str.size(); j++) {
					if(str.get(j)=="+") {
						value+=Integer.parseInt(str.get(j+1));
					}else if(str.get(j)=="-"){
						value-=Integer.parseInt(str.get(j+1));
					}
					if(value>max) {
						max=value;
						maxIndex = j+1;
					}
				}
				int hap=0;
				for(int j = maxIndex+1; j<str.size(); j++) {
					if(str.get(j)=="+") {
						hap+=Integer.parseInt(str.get(j+1));
					}else if(str.get(j)=="-"){
						hap-=Integer.parseInt(str.get(j+1));
					}
				}
				int real=hap-max+nomal2;
				
				if(real<nomal) {
					nomal = real;
				}else {
					nomal2-=Integer.parseInt(str.get(i+1));
				}
			}
			else if(str.get(i)=="+") {
				nomal2+=Integer.parseInt(str.get(i+1));
			}
		}
		
		
		System.out.println(nomal);*/
		int answer = 0;
		Scanner sc = new Scanner(System.in);
		String ex = sc.nextLine();
		String[] str = ex.split("-");
		for(int i=0; i<str.length; i++) {
			int temp = mySum(str[i]);
			if(i==0) {
				answer = answer + temp;
			}else {
				answer = answer - temp;
			}
		}
		System.out.println(answer);
		
	}
	static int mySum(String a) {
		int sum=0;
		String temp[] = a.split("[+]");
		for(int i=0; i<temp.length; i++) {
			sum+= Integer.parseInt(temp[i]);
		}
		return sum;
	}

}

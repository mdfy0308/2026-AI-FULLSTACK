package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
		
		// 1. for/while/di while > 3 2 1 
		
		for(int i=3;i>=1;i--) { System.out.print(i + "\t");}
		System.out.println();
		int i=3;
		while(i>=1) { System.out.print(i + "\t"); i--; }
		
		System.out.println();
		i=3;
		do {System.out.print(i + "\t"); i--; } while(i>=1);
		
		// 2. 이중 for
		// ★★★
		// ★★
		// ★
		
		System.out.println();
		
		for(int j=1;j<=3;j++) {
			for(int k=3;k>=j;k--) { System.out.print("★");
			} System.out.println();
		}
		
		// 3.배열명 arr / 값 넣기 > ABC
		// for+length 이용해서 대입, 출력
		
		char[] arr = new char[3];
		
		for(int j=0;j<arr.length;j++) {
			arr[j] += (char)('A'+j);
		}

		for(int j=0;j<arr.length;j++) {
			System.out.print(arr[j]);
		}
		

	} //

} //

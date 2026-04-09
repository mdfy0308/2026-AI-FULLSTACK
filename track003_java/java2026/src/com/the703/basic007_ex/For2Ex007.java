package com.the703.basic007_ex;

public class For2Ex007 {

	public static void main(String[] args) {
//		4444
//		333
//		22
//		1
		
		// 1) 보이는 그대로
		System.out.print(4); System.out.print(4); System.out.print(4); System.out.print(4); System.out.println();
		System.out.print(3); System.out.print(3); System.out.print(3); System.out.println();
		System.out.print(2); System.out.print(2); System.out.println();
		System.out.print(1); System.out.println();
		
		
		// 2) 정리
		for(int i=4; i>=1; i--) {  System.out.print(4); } System.out.println();
		for(int i=3; i>=1; i--) {  System.out.print(3); } System.out.println();
		for(int i=2; i>=1; i--) {  System.out.print(2); } System.out.println();
		for(int i=1; i>=1; i--) {  System.out.print(1); } System.out.println();
						
		
		// 3) 총정리
		for(int j=4; j>=1; j--) {
			for(int i=j; i>=1; i--) { System.out.print(j); } 
			System.out.println();
		}
		
	} //

} //

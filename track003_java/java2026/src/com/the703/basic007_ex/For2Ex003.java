package com.the703.basic007_ex;

public class For2Ex003 {

	public static void main(String[] args) {
//		#
//		##
//		###
//		####
		
		// 1) 보이는대로
		System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println();
		System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.print("#"); System.out.println(); 
		
		// 2) 정리
		for(int i=1; i<=1; i++) {  System.out.print("#"); } System.out.println();
		for(int i=1; i<=2; i++) {  System.out.print("#"); } System.out.println();
		for(int i=1; i<=3; i++) {  System.out.print("#"); } System.out.println();
		for(int i=1; i<=4; i++) {  System.out.print("#"); } System.out.println();
		
		// 3) 총정리
		for(int j=1; j<=4; j++) {
			for(int i=1; i<=j; i++) { System.out.print("#"); } 
			System.out.println();
		}
		

	} //

} //

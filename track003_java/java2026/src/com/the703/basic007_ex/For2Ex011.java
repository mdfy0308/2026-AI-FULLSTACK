package com.the703.basic007_ex;

public class For2Ex011 {

	public static void main(String[] args) {


		// 보이는대로 작성+정리
		// 1+2+3+4+5+6+7+8+9+10=55
		// 11+12+13+...+20=155
		
		int sum = 0;
//		for(int i=1;i<=10;i++) { System.out.print(i + (i<10? "+":"=")); sum+=i; } System.out.print(sum); System.out.println();
//		sum = 0;
//		for(int i=11;i<=20;i++) { System.out.print(i + (i<20? "+":"=")); sum+=i; } System.out.print(sum); System.out.println();
//		sum = 0;
//		for(int i=21;i<=30;i++) { System.out.print(i + (i<30? "+":"=")); sum+=i; } System.out.print(sum); System.out.println();
		
		// 총정리
		System.out.println("ver 1) for");
		for(int j=10;j<=100;j+=10) {
			sum = 0;
			for(int i=(j-10)+1;i<=j;i++) { System.out.print(i + (i<j? "+":"=")); sum+=i; }
			System.out.print(sum + "\n"); }
		
		
		int j=10, i=1;
		
		System.out.println("ver 2) while");
		while(j<=100) { 
			sum = 0;
			while(i<=j) { System.out.print(i + (i<j? "+":"=")); sum+=i; i++; }
			j+=10; System.out.print(sum + "\n");
		}
		
		j=10; i=1;
		
		System.out.println("ver 3) do while");
		do { sum = 0;
			do { System.out.print(i + (i<j? "+":"=")); sum+=i; i++; } while(i<=j);
			j+=10; System.out.print(sum + "\n");
		} while(j<=100);
		
	} //

} //

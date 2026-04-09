package com.the703.basic007_ex;

public class For2Ex009 {

	public static void main(String[] args) {
		
		// 이중 for/while/do while 세가지 버전으로 작성하시오.
		// A부터 Z까지
		// A
		// A B
		// A B C ... Z
		
		// 보이는대로 ) 
//		System.out.print("A"); System.out.println();
//		System.out.print("A"); System.out.print("B"); System.out.println();
//		System.out.print("A"); System.out.print("B"); System.out.print("C"); System.out.println();
//		
//		System.out.println();
//		
//		// 1차 정리)
//		for(int i='A';i<='Z';i++) { System.out.print((char)i); }
//		System.out.println();
		
		// for )
		System.out.println("ver 1) for");
		for(int j='A';j<='Z';j++) {
			for(int i='A';i<=j;i++) {System.out.print((char)i); }
			System.out.println();			
		}
		
		
		// while 
		System.out.println("ver 2) while");
		int j='A', i='A';
		
		while(j<='Z'){
			i='A';
			while(i<=j) { System.out.print((char)i); i++; }
			j++;
			System.out.println();
		}
		

		// do while
		
		System.out.println("ver 3) do while");
		j='A'; i='A';
		
		do{ i='A';
			do { System.out.print((char)i); i++; } while(i<=j);
			j++; System.out.println();
		} while(j<='Z');
	
		
		
		
	} //

} //

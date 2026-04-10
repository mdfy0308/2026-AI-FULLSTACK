package com.the703.basic007_ex;

public class For2Ex010 {

	public static void main(String[] args) {
		
		
				// 이중 for/while/do while 세가지 버전으로 작성하시오.
				// 보이는대로 ) 
//				System.out.print("A"); System.out.print("B"); System.out.print("C"); System.out.println();
//				System.out.print("A"); System.out.print("B"); System.out.println();
//				System.out.print("A"); System.out.println();
//				System.out.println();
//				
		
//				// 1차 정리)
				// A~Z순으로 나열/문자열이 하나씩 감소
//				for(int i='A'; i <='Z';i++) { System.out.print((char)i); } System.out.println(); // A부터 Z까지 출력
//				for(int i='A'; i <='Y';i++) { System.out.print((char)i); } System.out.println(); // A~Y
//				for(int i='A'; i <='X';i++) { System.out.print((char)i); } System.out.println(); // A~X...
				

//				// for )
				System.out.println("ver 1) for");
				for(int j='Z';j>='A';j--) {
					for(int i='A'; i<=j; i++) { System.out.print((char)i); }
					System.out.println();
				}
				

				
//				// while )
				System.out.println("ver 2) while");
				int j='Z', i='A';
				
				while(j>='A') {
					i='A';
					while(i<=j) { System.out.print((char)i); i++; }
					j--;
					System.out.println();
				}


//				// do while )
				System.out.println("ver 3) do while");
				j='Z'; i='A';
				
				do {
					i='A';
					do { System.out.print((char)i); i++; } while(i<=j);
					j--;
					System.out.println();
				} while(j>='A');

				


	} //

} //

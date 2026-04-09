package com.the703.basic007_ex;

public class For2Ex008 {

	public static void main(String[] args) {
	// 두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.
	// 이중 for/while/do while 세가지 버전으로 작성하시오.
	
	// 각각 주사위 눈 1~5
	// System.out.printf("%d+%d=%d", 1, 5, (1+5));

	// 1부터 5까지의 모든 경우의 수에서 ~ 합이 6일 때만 출력함
	System.out.println("ver-1: for");
	for(int i=1; i<=5; i++) {
		for(int j=5; j>=1; j--) {
			switch (i+j) {
			case 6: System.out.printf("%d+%d=%d", i, j, i+j); break;
			default: break;
			}
		} System.out.println();
	}
	
	System.out.println();
	System.out.println("ver-2: while");
	int i=1, j=5;
	
	while(i<=5) {
		while(j>=1) { 
			if(i+j==6) { System.out.printf("%d+%d=%d", i, j, i+j); 
			} else {break;}  j--;
		} i++; System.out.println();
	}
	
	System.out.println();
	System.out.println("ver-3: do while");
	
	i=1; j=5;
	
	do { 
		do{ if(i+j==6) { 
			System.out.printf("%d+%d=%d", i, j, i+j); 
			} else {break;}  j--; 
		} while(j<=1); i++; System.out.println(); } while(i<=5);
	
		
	} //

} //

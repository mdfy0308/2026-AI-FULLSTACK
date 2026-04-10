package com.the703.basic007_ex;

public class For2Ex013 {

	public static void main(String[] args) {
		// 이중 for, while, do while 3가지 버전으로 구구단 2~4단을 출력하시오
		
		// 2단
		// 2*1=2
		// 2*2=4
		// ...중간 생략

		// 3단
		// 3*1=3
		// 3*2=6
		// ...중간 생략
		
		// 4단
		// 4*1=4
		// 4*2=8
		// ...중간 생략
		
		// i단
		// i*j = (i*j)
		// i는 2~4까지, j는 1~9까지
				
		// for
		System.out.println("ver 1) for");
		for(int i=2;i<=4;i++) {
			System.out.println(i + "단");
			for(int j=1;j<=9;j++) { System.out.printf("%d * %d = %d\n", i, j, (i*j));}
		}
		
		
		// while
		System.out.println();
		System.out.println("ver 2) while");
		
		int i=2, j=1;
		
		while(i<=4) {
			j=1;
			System.out.println(i + "단");
			while(j<=9) { System.out.printf("%d * %d = %d\n", i, j, (i*j)); j++; }
			i++;
		}
		
		// do while		
		System.out.println();
		System.out.println("ver 3) do while");
		
		i=2;
		do { j=1;
			System.out.println(i + "단");
			do { System.out.printf("%d * %d = %d\n", i, j, (i*j)); j++; } while(j<=9);
			i++;
		} while(i<=4);
		
		
		

	} //

} //

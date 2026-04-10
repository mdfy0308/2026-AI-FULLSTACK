package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		
		int avg = -1;
		Scanner sc = new Scanner(System.in);
		
		//1. if버전
		System.out.print("평균 점수 입력 > ");
		avg = sc.nextInt();
		
		if(avg>=90){ System.out.println("A학점");}
		else if(avg>=80){ System.out.println("B학점");}
		else if(avg>=70){ System.out.println("C학점");}
		else { System.out.println("F학점");}
		
		
		//2. switch 버전
		
		System.out.print("평균 점수 입력 > ");
		avg = sc.nextInt();
		switch(avg/10) {
		case 9:case 10: System.out.println("A학점"); break;
		case 8: System.out.println("B학점"); break;
		case 7: System.out.println("C학점"); break;
		default: System.out.println("F학점"); break;
		}

		
		// for, while, do while 3가지 버전으로 1 2 3
		
		for(int i=1; i<=3; i++) { System.out.print(i+"\t"); }
		System.out.println();
		
		int i=1;
		while (i<=3) { System.out.print(i+"\t"); i++; }
		System.out.println();
		
		i=1;
		do { System.out.print(i+"\t"); i++; } while(i<=3);
		System.out.println();

		
		// 이중 for를 이용하여 다음을 출력
		// ★★★★
		// ★★★★
		// ★★★★
		// ★★★★
		
		for(int j=1;j<=4;j++){
			for(int k=1; k<=4; k++) { System.out.print("★");}
			System.out.println();
		}
		
		// 14:30 - 14:37;

	} //

} //

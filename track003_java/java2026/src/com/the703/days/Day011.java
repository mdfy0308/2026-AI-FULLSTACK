package com.the703.days;

import java.util.Scanner;

public class Day011 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		char ch = '\u0000';
		
		System.out.print("문자 입력 > ");
		ch = sc.next().charAt(0);
		
		// 1) if 버전
		
		if(ch=='a') { System.out.println("APPLE"); }
		else if(ch=='b') { System.out.println("BANANA"); }
		else if(ch=='c') { System.out.println("COCONUT"); }

		
		// 2) switch 버전
		
		switch(ch) {
		case 'a': System.out.println("APPLE"); break;
		case 'b': System.out.println("BANANA"); break;
		case 'c': System.out.println("COCONUT"); break;
		}
		
		// for
		for(int i=1;i<=5;i++) { System.out.print(i + "\t"); }
		
		// while
		
		int i=1;
		System.out.println();
		while(i<=5) { System.out.print(i + "\t"); i++; }
		
		// do while
		
		i=1;
		System.out.println();
		do { System.out.print(i + "\t"); i++;} while(i<=5);
		
		

	} //

} //

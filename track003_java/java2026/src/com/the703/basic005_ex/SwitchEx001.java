package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx001 {

	public static void main(String[] args) {
//		switch 이용
//	     숫자한개 입력받아
//	     3이면 봄
//	     6이면 여름
//	     9이면 가을
//	     12이면 겨울
		
		Scanner sc = new Scanner(System.in);
		
		int a = 1;
		String result = "";
		
		System.out.print("숫자 입력 > ");
		a = sc.nextInt();
		
		switch(a) {
		case 3: result = "봄"; break;
		case 6: result = "여름"; break;
		case 9: result = "가을"; break;
		case 12: result = "겨울"; break;
		}

		System.out.println(result);
	}

}

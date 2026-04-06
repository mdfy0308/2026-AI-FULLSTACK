package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx002 {

	public static void main(String[] args) {
//		 switch 이용
//	     숫자한개 입력받아
//	     3,4,5이면 봄
//	     6,7,8이면 여름
//	     9,10,11이면 가을
//	     12,1,2이면 겨울
		
		Scanner sc = new Scanner(System.in);
		
		int a = 1;
		String result = "";
		
		System.out.print("숫자 입력(1~12) > ");
		a = sc.nextInt();
				
		switch(a/3) {
		case 1: result = "봄"; break;
		case 2: result = "여름"; break;
		case 3: result = "가을"; break;
		case 4: case 0: result = "겨울"; break;
		}

		System.out.println(result);

	}

}

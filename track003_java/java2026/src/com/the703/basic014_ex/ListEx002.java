package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {

	public static void main(String[] args) {

//		1.  numbers ArrayList 만들기
//		2.  one, two, three 데이터 추가
//		3.  사용자에게 1,2,3 입력받기
//		4.  1을 입력받으면 one 출력
//		    2를입력받으면 two 출력
//		    3을입력받으면 three 출력

		List<String> numbers = new ArrayList<>();
		
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 1~3중 하나 입력하기 > ");
		int num = sc.nextInt();
		
		if(num>0 && num<4) {
			System.out.println(numbers.get(num-1));
		} else { System.out.println("숫자 1, 2, 3이 아닙니다."); }
		
		
	}

}

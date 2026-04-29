package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;

public class ListEx001 {

	public static void main(String[] args) {
//		 1. ArrayList이용해서 colors 만들기
//		 2. red, green, blue 데이터 추가
//		 3. 출력
//
//		red
//		green
//		blue

		List<String> colors = new ArrayList<>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");

		System.out.println(colors);
		for(String c : colors) { System.out.println(c); }
		

	}
}

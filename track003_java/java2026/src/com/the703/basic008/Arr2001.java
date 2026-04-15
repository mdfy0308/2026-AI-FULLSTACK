package com.the703.basic008;

import java.util.Arrays;

public class Arr2001 {

	public static void main(String[] args) {
		// 1. 다차원배열

		int[][] arr = { { 1, 2, 3 }, // 00 01 02
				{ 4, 5, 6 } // 10 11 12
		};

		System.out.println(arr); // [[I@372f7a8d
		System.out.println(Arrays.toString(arr));

		// ver-1 눈에 보이는대로
		System.out.println("ver-1)");
		System.out.print(arr[0][0]);
		System.out.print(arr[0][1]);
		System.out.print(arr[0][2]);
		System.out.println();
		System.out.print(arr[1][0]);
		System.out.print(arr[1][1]);
		System.out.print(arr[1][2]);
		System.out.println();

		// ver-2 칸 정리
		System.out.println("ver-2)");
		for (int kan = 0; kan <= 2; kan++) {
			System.out.print(arr[0][kan]);
		}
		System.out.println();
		for (int kan = 0; kan <= 2; kan++) {
			System.out.print(arr[1][kan]);
		}
		System.out.println();

		// ver-3 층 정리
		System.out.println("ver-3)");
		for (int fl = 0; fl <= 1; fl++) {
			for (int kan = 0; kan <= 2; kan++) {
				System.out.print(arr[fl][kan]);
			}
			System.out.println();
		}

		// ver-4 length 이용
		System.out.println("ver-4)");
		for (int fl = 0; fl < arr.length; fl++) { // 아파트의 층수
			for (int kan = 0; kan < arr[fl].length; kan++) {
				System.out.print(arr[fl][kan]);
			} // 층의 칸수
			System.out.println();
		}

	} //

} //

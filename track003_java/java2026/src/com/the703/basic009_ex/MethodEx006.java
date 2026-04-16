package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx006 {

	public static int max(int num1, int num2, int num3) {
		int[] arr = { num1, num2, num3 };
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j && max < arr[j]) {
					max = arr[i] > arr[j] ? arr[i] : arr[j];
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

		// 3개의 숫자를 입력받아 최대값을 출력하는 메서드를 작성하시오
		int a = 0, b = 0, c = 0;
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자 1 > ");
		a = sc.nextInt();
		System.out.print("숫자 2 > ");
		b = sc.nextInt();
		System.out.print("숫자 3 > ");
		c = sc.nextInt();

		int res3 = max(a, b, c);
		System.out.println("최대값 : " + res3);

	} //

} //

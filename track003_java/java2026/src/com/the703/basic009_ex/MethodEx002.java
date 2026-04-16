package com.the703.basic009_ex;

public class MethodEx002 {

	public static void test1(int num) {
		System.out.println(num);
	}

	public static void test2(double num) {
		System.out.printf("%.1f\n", num);
	}

	public static void hap(int a, int b) {
		int total = 0;
		for (int i = a; i <= b; i++) {
			total += i;
		}
		System.out.printf("%d부터 %d까지의 합 : %d\n", a, b, total);
	}

	public static void disp(int num, char star) {
		for (int i = 1; i <= num; i++) {
			System.out.print(star);
		}
	}

	public static void main(String[] args) {

		test1(10); // 10 출력
		test2(1.2222222); // 1.2 출력
		hap(1, 10); // 3+4+5한값 12 출력
		disp(7, '*'); // *******출력

	}

}

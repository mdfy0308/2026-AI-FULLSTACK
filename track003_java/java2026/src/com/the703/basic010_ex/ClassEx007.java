package com.the703.basic010_ex;

import java.util.Scanner;

class Calc {

	int num1, num2;
	char op;
	double result;

	void input() { // 입력받기
		Scanner scanner = new Scanner(System.in);

		System.out.print("1. 숫자1 입력 > ");
		num1 = scanner.nextInt();
		System.out.print("2. 숫자2 입력 > ");
		num2 = scanner.nextInt();
		System.out.print("3. 산술 연산자 입력 > ");
		op = scanner.next().charAt(0);
	}

	public Calc() {
		super();
	}

	public Calc(int num1, int num2, char op) {
		super();
		this.num1 = num1;
		this.num2 = num2;
		this.op = op;
	}

	void opcalc() {

		switch (op) { 
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = (double) num1 / num2; break;
		}
	}

	void show() {
		System.out.printf("%d %c %d = " + (op=='/'? "%.2f\n":"%.0f\n"), 
				num1, op, num2, result);
	}
}

public class ClassEx007 {

	public static void main(String[] args) {

		Calc c1 = new Calc(10, 3, '+');
		c1.opcalc();
		c1.show();

		Calc c2 = new Calc();
		c2.input();
		c2.opcalc();
		c2.show();

	} //

} //

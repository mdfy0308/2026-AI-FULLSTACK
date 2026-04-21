package com.the703.basic010_ex;

import java.util.Scanner;

class MyPrice001 {

	String name;
	int price;

	// 1) 모든 클래스는 생성자 - 컴파일러가 기본샐성자를 자동생성 
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품이름 입력 > ");
		name = sc.next();
		System.out.print("상품가격 입력 > ");
		price = sc.nextInt();
	};

	void show() {
		System.out.println("상품 정보입니다.");
		System.out.printf("상품이름: %s / 상품가격: %d", name, price);
	};
}

public class ClassEx002 {

	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		p1.input();
		p1.show();

	} //

} //

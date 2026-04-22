package com.the703.basic010;

// 1. 클래스는 부품객체
// 2. 클래스 상태(멤버변수)와 행위(멤버함수)
/*  Object						2) Object(){ 				} 3)객체틀 마무리
	  ↑  Product가 Object를 사용한다.
	Product { name, price }	 	1) Product(){ super(); > 오브젝트 호출 name=null, price=0 } 4)


 */

class Product extends Object { // 상속을 받는다,  Object(클래스의 기본틀), extends Object 생략 가능
	// 인스턴스 변수
	String name; int price;
	
	// alt + shift + s
	public Product() { super(); } // super(부모) - Object()
	
	public Product(String name, int price) { super(); this.name = name; this.price = price; }
	// this - 각각의 인스턴스가 가지고 있는 값
	
	@Override 
	public String toString() { return "Product [name=" + name + ", price=" + price + "]"; }

}

public class Class004 {

	public static void main(String[] args) {

		Product p1 = new Product(); // 1) new 객체생성, 2) 생성자-초기화, 3) p1 - 주소(1번지)갖기
		System.out.println(p1); // 상태 정보 출력, Product {name=null, price=0}
		// p1(1번지) → 1번지 : Product [name=null, price=0]
		
		Product p2 = new Product("아이폰17", 100); // 1) new 객체생성, 2) 생성자-초기화, 3) p1 - 주소(1번지)갖기
		System.out.println(p2); // 상태 정보 출력, Product {name=null, price=0}
		// p2(2번지) → 2번지 : Product [name=null, price=0]

	} //

//////////////////////////////////////////////////////


/*
 * [RUNTIME DATA AREA] 
 * --------------------------------------------------
 * [METHOD:정보]
 * Product.class(설계도), Class004.class#1) 
 * --------------------------------------------------
 * [HEAP:동적] 							| 		[STACK:지역]
 * 
 * 1번지: Product {name=null, price=0}   ← p1(1번지)
 * 										| 		main#2)
 * --------------------------------------------------
 * (인스턴스)
 */
	
//////////////////////////////////////////////////////

} //

/**************
 * 
 * ■ OOP 1. 생성자 - new 연산자에 의해 호출 [ 초기화 ] 담당
 * 
 * 2. 기본생성자( 디폴트생성자 ) - 모든클래스에 생성자가 반드시 존재 - 생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가 -
 * 개발자가 선언시 컴파일러가 자동생성 ( 취소 )
 * 
 * 3. 생성자형식 class A{ public A( ){} //기본생성자(디폴트생성자) public A(String name){}
 * //파라미터, 알규먼트가 있는 생성자. } 1) 리턴값 ( 없음 ) 2) 클래스명과 ( 동일 )
 * 
 * 
 */
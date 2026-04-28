package com.the703.basic013_ex;

/*

1. 인터페이스를 활용한 점심 주문 시뮬레이션
다음은 점심 메뉴 주문을 인터페이스로 추상화한 프로그램이다. 
Launch 인터페이스는 모든 메뉴가 공통적으로 가져야 할 기능을 정의하며, 
Burger, KimchiStew 클래스는 이를 구현하여 각각의 메뉴 정보를 제공한다. 
User 클래스는 메뉴를 주문하고, 주문 내역을 출력하는 기능을 담당한다.

*/

interface Drink {
	public void serve();
}

class Coffee implements Drink {
	@Override
	public void serve() {
		System.out.println("커피가 준비되었습니다.");
	}

	public void addSugar() {
		System.out.println("커피에 설탕을 넣습니다.");
	}
}

class Tea implements Drink {
	@Override
	public void serve() {
		System.out.println("차가 준비되었습니다.");
	}

	public void addLemon() {
		System.out.println("차에 레몬을 넣습니다.");
	}
}

class Juice implements Drink {
	@Override
	public void serve() {
		System.out.println("주스가 준비되었습니다.");
	}

	public void addIce() {
		System.out.println("주스에 얼음을 넣습니다.");
	}
}

class Barista {
	
	void make(Drink drink) {
		drink.serve();
		if(drink instanceof Coffee) 	{ ((Coffee) drink).addSugar();  }
		else if(drink instanceof Tea)	{ ((Tea) drink).addLemon(); 	}
		else if(drink instanceof Juice) { ((Juice) drink).addIce(); 	}
	}
	
}

public class InterfaceEx004 {

	public static void main(String[] args) {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		Barista barista = new Barista();

		// 배열에 객체들을 담아둠
		Drink[] menu = { new Coffee(), new Tea(), new Juice() };

		while (true) {
			System.out.println("=== 카페 메뉴판 ===");
			System.out.println("1. 커피");
			System.out.println("2. 차");
			System.out.println("3. 주스");
			System.out.println("0. 종료");
			System.out.print("선택: ");
			int choice = sc.nextInt();

			if (choice == 0) {
				System.out.println("카페 주문을 종료합니다.");
				break;
			}

			if (choice >= 1 && choice <= menu.length) {
				Drink drink = menu[choice - 1]; // 배열에서 꺼내오기
				barista.make(drink);
			} else {
				System.out.println("잘못된 선택입니다.");
			}
			System.out.println();
		}
		sc.close();
	}
}

/*
4. 실행화면
=== 카페 메뉴판 ===
1. 커피
2. 차
3. 주스
0. 종료
선택: 1
커피가 준비되었습니다.
커피에 설탕을 넣습니다.

선택: 2
차가 준비되었습니다.
차에 레몬을 넣습니다.

선택: 3
주스가 준비되었습니다.
주스에 얼음을 넣습니다.

선택: 0
카페 주문을 종료합니다.
*/
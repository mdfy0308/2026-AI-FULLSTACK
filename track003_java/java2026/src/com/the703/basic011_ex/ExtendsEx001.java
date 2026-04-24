package com.the703.basic011_ex;

/***
1) Color와 Green 클래스의 상속 관계를 활용할 것
2) main() 메서드에서 직접 name과 num에 값을 할당할 수 있도록 접근 제어자를 고려할 것
3) show() 메서드를 통해 출력 형식을 맞출 것

	Object	#3{					  	}#4
	  ↑
	Color	#2{   name=null, num=0  }#5
	  ↑
	Green	#1{			show()		}#6
	--------------------------------
	Green mygreen = new Green(); 
	--------------------------------
	1. Green은 Object(부품객체)
	   Color는 Object(부품객체)
	2. 생성자 호출 : Green() → Color() → Object() 	1 2 3
	3. 객체 생성  : Object → Color → Green 		4 5 6
*/

class Color extends Object { 
	public String name;
	private int num;

	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
	
	public Color() { super();  }
	public Color(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
}

class Green extends Color {
	
	public Green() { super(); }
	public Green(String name, int num) { super(name, num); }

	void show() {
		System.out.println("GREEN");
		System.out.println("NAME : " + super.name);
		System.out.println("NUM : " + super.getNum());
	}
}

public class ExtendsEx001 {

	public static void main(String[] args) {

		Green mygreen = new Green();
		mygreen.name = "LIGHT_GREEN";
		mygreen.setNum(5);
		mygreen.show();

	}
}

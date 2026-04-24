package com.the703.basic011_ex;

/****
 * MobileNote 클래스를 기반으로 상속 구조를 설계할 것 (MobileNote7, MobileNote8, MobileNote9 모두
 * 상속) -각 클래스에서 setter 메서드를 통해 멤버변수 값을 설정할 수 있도록 구현할 것 -newShow() 메서드를 오버라이딩하여
 * 출력 형식을 문제에서 제시한 형태로 맞출 것 -출력 순서와 내용이 정확히 일치하도록 main() 메서드를 구성할 것
 */

class MobileNote {
	void Show() {}

}

class MobileNote7 extends MobileNote {
	private String iris, face;

	// 생성자 오버로딩(이름이 같음 - 파라미터의 자료형과 갯수로 구분)
	public MobileNote7() { super(); }
	public MobileNote7(String iris, String face) {
		super();
		this.iris = iris;
		this.face = face;
	}

	public String getIris() { return iris; } 
	public void setIris(String iris) { this.iris = iris; }
	
	public String getFace() { return face; } 
	public void setFace(String face) { this.face = face; }

	
	void newShow() {
		System.out.println("NOTE7 객체 기능(Overriding)");
		System.out.println("iris = " + this.iris );
		System.out.println("face = " + this.face );
	}
}


class MobileNote8 extends MobileNote7 {
	private String face;
	
	public MobileNote8() { super(); }
	public MobileNote8(String iris, String face) {
		super();
		this.setIris(iris);
		this.setFace(face);
		this.face = face;
	}
		
	public String getFace() { return face; } 
	public void setFace(String face) { this.face = face; }

	/// 오버라이딩 (상속시 부모의 메서드를 수정해 자식클래스에 맞게 수정해서 사용)
	@Override void newShow() {
		super.newShow();
		System.out.println("NOTE8 객체 기능(Overriding) 추가");
		System.out.println("face = " + this.face);
	}
}


class MobileNote9 extends MobileNote8 {
	private int battery;
	
	public MobileNote9() { super(); }
	public MobileNote9(String iris, String face, int battery) {
		super();
		this.setIris(iris);
		this.setFace(face);
		this.battery = battery;
	}
	
	public int getBattery() { return battery; } 
	public void setBattery(int battery) { this.battery = battery; }
	
	@Override void newShow() {
		super.newShow();
		System.out.println("NOTE9 객체 기능(Overriding) 추가");
		System.out.println("battery 예쁘게 사용하기!");
		System.out.println("battery = " + this.battery);
	}
}

public class ExtendsEx002 {

	public static void main(String[] args) {
//		MobileNote7 my7 = new MobileNote7();
//		my7.setIris("brown");
//		my7.setFace("pretty");
//		my7.newShow();
//
//		MobileNote8 my8 = new MobileNote8();
//		my8.setFace("pretty");
//		my8.newShow();
//
//		MobileNote9 my9 = new MobileNote9();
//		my9.setBattery(24);
//		my9.newShow();
		
		MobileNote9 my9 = new MobileNote9("brown", "pretty", 24*7);
		my9.newShow();
		
	}

}

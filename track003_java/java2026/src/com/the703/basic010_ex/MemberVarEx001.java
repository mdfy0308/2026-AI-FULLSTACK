package com.the703.basic010_ex;

/*

1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
2. 인스턴스메서드, 클래스메서드 구분하시오.
3. 오류나는 이유는?


[RUNTIME DATA AREA] 
------------------------------------------------------------------------
[METHOD:정보, static, final] Sawon3.class, MemberVarEx001.class#1)
Sawon3.su=10; Sawon3.basicpay2; Sawon3.basicpay; Sawon3.showSu() Sawon3.showAll002()
------------------------------------------------------------------------
[HEAP:동적]					 |					[STACK:지역] 

1번지 {pay=10000; showAll001()}		←			sola[1번지]
												main #2)
------------------------------------------------------------------------
*/



class Sawon3{
	
    int pay      =10000; // 인스턴스 변수
    
    static int su=10;     // 클래스 변수
    // static int basicpay = pay; 
    static int basicpay2;    
    
    
    public static void showSu() {   System.out.println(su);  } // 클래스 메서드      
    // public static void showPay() {   System.out.println(this.pay);  }
      
    
    public void showAll001() {   // 인스턴스 메서드
       System.out.println(su);
       System.out.println(this.pay);  
    }
    
    //public static void showAll002() {   // 클래스 메서드
    // showAll001();
    // System.out.println(this.pay); 
    //} 
 
    // 오류 : static 안에서 this나 인스턴스 메서드를 사용할 수 없는 이유
    // static은 인스턴스 생성 전에 먼저 메모리에 할당됨
    // static이 아닌 메서드는 static에서 참조할 수 없음, 사용 불가
} 

public class MemberVarEx001 {

	public static void main(String[] args) {

		Sawon3 sola = new Sawon3();  
		sola.showAll001();

	}

}

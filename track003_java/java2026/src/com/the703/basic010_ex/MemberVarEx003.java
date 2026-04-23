package com.the703.basic010_ex;

//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기

/*


[RUNTIME DATA AREA] 
------------------------------------------------------------------------
[METHOD:정보, static, final] LunchTray.class, MemberVarEx003.class#1)
LunchTray.trayCount = 0; LunchTray.maxRice = 100; showTrayCount()
------------------------------------------------------------------------
[HEAP:동적]					 |					[STACK:지역] 
2번지 {owner="std-2"; rice = 90; soup = 85; 
getFoodAmount() showTray()}				←			s2
1번지 {owner="std-1"; rice = 90; soup = 85; 
getFoodAmount() showTray()}				←			s1
													main #2)
------------------------------------------------------------------------

*/

class LunchTray {
	
	// 인스턴스 변수
    String owner;        
    int rice = 90;               
    int soup = 85;               
    
    // 클래스 변수
    static int trayCount = 0;      

    // static int totalFood = rice + soup; > 클래스 변수에서 인스턴스 변수를 참조할 수 없음

    static int maxRice = 100;       

    // 인스턴스 메서드
	public int getFoodAmount() {
        return rice + soup;         
    }
	
	// 클래스 메서드
    public static void showTrayCount() {
    	trayCount++;
        System.out.println("전체 급식판 수: " + trayCount);   
    }

	// public static void showOwner() { 
	//   System.out.println(owner);
	// } > 클래스 메서드에서 인스턴스 변수를 참조할 수 없음

    public void showTray(String owner) {
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());    
 
    }
}


public class MemberVarEx003 {

	public static void main(String[] args) {
		
		LunchTray lt1 = new LunchTray();
		LunchTray lt2 = new LunchTray();
		
		lt1.showTray("std-1");
		LunchTray.showTrayCount();
		lt2.showTray("std-2");
		LunchTray.showTrayCount();
		
		//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
		//:: 주인 이름: std-1
		//총 음식량: 175
		//전체 급식판 수: 1
		//:: 주인 이름: std-2
		//총 음식량: 175
		//전체 급식판 수: 2

	} //

} //

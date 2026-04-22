package com.the703.basic010_ex;

//- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
//- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
//- 문제 3. 오류가 발생하는 이유를 설명하시오.
//- 문제 4. runtime data area 위치영역 그림그리기

/*


[RUNTIME DATA AREA] 
------------------------------------------------------------------------
[METHOD:정보, static, final] Student.class, MemberVarEx002.class#1)
Student.studentCount = 0; Student.maxScore = 100; showStudentCount()
------------------------------------------------------------------------
[HEAP:동적]					 |					[STACK:지역] 
2번지 {name="홍길동"; kor=90; eng=85; 
Student() getTotalScore()}				←			s2
1번지 {name="홍길동"; kor=90; eng=85; 
Student() getTotalScore()}				←			s1
													main #2)
------------------------------------------------------------------------

*/

//- 문제 5. 다음과 같이 출력되도록 코드를 작성하시오.
//:: 주인 이름: std-1
//총 음식량: 175
//전체 급식판 수: 1
//:: 주인 이름: std-2
//총 음식량: 175
//전체 급식판 수: 2




class LunchTray {
    String owner;        
    int rice = 90;               
    int soup = 85;               

    static int trayCount = 0;      

    // static int totalFood = rice + soup;

    static int maxRice = 100;       

    public int getFoodAmount() {
        return rice + soup;         
    }

    public static void showTrayCount() {
        System.out.println("전체 급식판 수: " + trayCount);   
    }

	// public static void showOwner() { 
	//   System.out.println(owner);
	// } 

    public void showTray() {
        System.out.println("\n\n:: 주인 이름: " + owner);                
        System.out.println("총 음식량: " + getFoodAmount());     
    }
}


public class MemberVarEx003 {

	public static void main(String[] args) {

		

	} //

} //

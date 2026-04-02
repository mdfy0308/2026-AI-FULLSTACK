package com.the703.basic005;

public class If001 {

	public static void main(String[] args) {
		
//		- 조건문 : if, switch
//		- 반복문 : for, while, do while
//		- 제어 키워드 : break, continue
		
		
		//1형식 axe가 1이라면 금도끼, 2라면 은도끼, 3이라면 낡은 도끼
		// if(조건) { 참일 경우 실행 };
		System.out.println("■ 1형식 - 조건을 무조건 읽음");
		int axe = 1;
		
		if(axe == 1) {System.out.println("금도끼");}
		if(axe == 2) {System.out.println("은도끼");}
		if(axe == 3) {System.out.println("낡은 도끼");}
		
		//2형식 if(axe가 1이라면) { 금도끼 } else { 아니라면 다른 것 }
	
		System.out.println("■ 2형식 - 맞다/틀리다 둘중에 하나");
		axe = 2;
		if(axe == 1) {System.out.println("금도끼");		 } // 맞다
		else 		 {System.out.println("내 도끼가 아니다.");} // 틀리다
		
		//다형식 
		//      if(axe가 1이라면) { 금도끼 }
		// else if(axe가 2이라면) { 은도끼 }
		// else if(axe가 3이라면) { 낡은 도끼 }
		// else				   { 내 도끼가 아니다. }
		
		System.out.println("■ 다형식 - 여러 조건 ");
		
		     if(axe == 1) { System.out.println("금도끼");    		}
		else if(axe == 2) { System.out.println("은도끼");  	 	}
		else if(axe == 3) { System.out.println("낡은 도끼"); 		}
		else 			  { System.out.println("내 도끼가 아니다."); }

		
		
		
	}

}

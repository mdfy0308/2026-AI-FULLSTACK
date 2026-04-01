package com.the703.basic004_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		
		// 결과값은? 연산되는 순서는?
		int a=3, b=10;
	    System.out.println(  b+=10 - a-- );
	    // +=보다 +(비교조건)의 우선순위가 높다
	    // 10 - a = 10-3 = 7
	    // b = 10 + 7 (17)
	    // ; 이후 a에서 -1, a == 2
	    	    
	    System.out.println(  a+=5 );
	    // 1 감소한 a(2)값에 5를 +더해서 =할당
	    // a == 7
	    
	    System.out.println(  a>=10 || a<0 && a>3);
	    // ||보다 &&의 우선순위가 높다
	    // 1) a>=10 → 7>=10 (false)
	    // 2) a<0 && a>3 > 7<0 (false)
	    // && 위 조건을 모두 만족하지 못해서 false

	}

}

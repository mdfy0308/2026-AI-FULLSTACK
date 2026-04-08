package com.the703.basic006;

public class WhileBasic {

	public static void main(String[] args) {
		
		
		//ver-0
		System.out.println("ver-0");
		System.out.print("1\t");
		System.out.print("2\t");
		System.out.print("3\t");
		System.out.println();
		
		//ver.1 : for 1 2 3 출력
		// {반복} {변수} for(시작;조건;변화)
		System.out.println("ver-1 for");
		for(int i=1;i<=3;i++) {System.out.print(i +"\t");}
		System.out.println();
		
		
		//ver.2 : while 조건만 있고 반복횟수가 정해지지 않았을 때
		//게시글 수가 정해지지 않은 게시판 등에 사용
		
		System.out.println("ver-2 while");
		int i=1; // 초기값을 while 밖에
		while (i<=3) { // 조건문
			System.out.print(i + "\t"); // 처리내용
			i++; // 증감문은 처리내용 다음에
		}
		System.out.println();
		
		
		//ver.3 : do while
		System.out.println("ver-3 do while");
		i=1; 
		do { System.out.print(i + "\t"); // 무조건 한번은 실행
			i++; // 증감문은 처리내용 다음에
		} while (i<=3); // 조건문
		System.out.println();
		
		
		
	} //

} //

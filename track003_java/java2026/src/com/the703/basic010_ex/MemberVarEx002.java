package com.the703.basic010_ex;

/*
- 문제 1. 다음 코드에서 인스턴스변수, 클래스변수, 지역변수를 구분하시오.  ( 보관되는 영역도 추가 )
- 문제 2. 인스턴스메서드와 클래스메서드를 구분하시오.  
- 문제 3. 오류가 발생하는 이유를 설명하시오.
- 문제 4. runtime data area 위치영역 그림그리기


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

class Student {

	// 인스턴스 변수
	String name = "홍길동";
	int kor = 90;
	int eng = 85;

	// 클래스 변수
	static int studentCount = 0;

	// static int total = kor + eng; 클래스 변수에서 인스턴스 변수를 참조할 수 없음

	static int maxScore = 100;

	public Student() {
		studentCount++;
	}
	
	public int getTotalScore() {
		return kor + eng;
	}

	// 클래스 메서드
	public static void showStudentCount() {
		System.out.println("전체 학생 수: " + studentCount);
	}

	// public static void showName() {
	// System.out.println(name);
	// } // 클래스 메서드에서 인스턴스 변수를 참조할 수 없음/구동 시점이 다르다

	// 인스턴스 메서드
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("총점: " + getTotalScore());
	}
}

public class MemberVarEx002 {

	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student();

		s1.showInfo();
		Student.showStudentCount();

	} //
	
} //



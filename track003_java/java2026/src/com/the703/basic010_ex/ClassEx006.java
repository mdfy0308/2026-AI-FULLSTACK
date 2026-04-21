package com.the703.basic010_ex;

class Score {
	// 상태-멤버변수 : 채널/볼륨
	String stdid;
	int kor, eng, math, total; double avg;

	// 행위-멤버함수 : 채널, 볼륨 입력:
	void input() {
	}

	public Score() {
		super();
	}

	public Score(String stdid, int kor, int eng, int math) {
		super();
		this.stdid = stdid;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.avg = total / 3.0;
	}

	void info() {
		System.out.println("학번\t kor\t eng\t math\t total\t avg");
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.2f", stdid, kor, eng, math, total, avg);
	}

}

public class ClassEx006 {

	public static void main(String[] args) {

		Score s1 = new Score("std1234", 100, 100, 99);
		s1.info();

	}

}

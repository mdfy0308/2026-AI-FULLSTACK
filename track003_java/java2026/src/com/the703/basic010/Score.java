package com.the703.basic010;

public class Score {

	private String name;
	private int kor, eng, math, total;
	private double aver;
	private String p, s, rank;

	public Score() {
		super();
	}

	public Score(String name, int kor, int eng, int math) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.aver = total / 3.0;
		this.p = aver<60? "불합격":"합격";
		this.s = aver<95? "":"장학생";
		this.rank = "";
		for(int i=0;i<(int)(aver/10);i++) { this.rank += "*"; }
	}

	@Override
	public String toString() {
		return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", aver=" + aver + ", p=" + p + ", s=" + s + ", rank=" + rank + "]";
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public int getKor() { return kor; }
	public void setKor(int kor) { this.kor = kor; }

	public int getEng() { return eng; }
	public void setEng(int eng) { this.eng = eng; }

	public int getMath() { return math; }
	public void setMath(int math) { this.math = math; }

	public int getTotal() { return total; }
	public void setTotal(int total) { this.total = total; }

	public double getAver() { return aver; }
	public void setAver(double aver) { this.aver = aver; }

	public String getP() { return p; }
	public void setP(String p) { this.p = p; }

	public String getS() { return s; }
	public void setS(String s) { this.s = s; }

	public String getRank() { return rank; }
	public void setRank(String rank) { this.rank = rank; }

	public static void info() {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	public void show() {
		System.out.printf("%s\t %d\t %d\t %d\t %d\t %.2f\t %s\t %s\t %s\n", 
				name, kor, eng, math, total, aver, p, s, rank);
	}

}

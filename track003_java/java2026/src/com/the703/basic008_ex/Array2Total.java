package com.the703.basic008_ex;

public class Array2Total {

	public static void main(String[] args) {
		
		   String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
		   int[] kor={100,20,90,70,35};   
		   int[] eng={100,50,95,80,100};
		   int[] mat={100,30,90,60,100};
		   int[] aver = new int[5];
		    
		   int[] num = new int[5];
		   String[] pass = new String[5];
		   String[] sch = new String[5];
		   String[] rank = new String[5];
		   
//		   1. 평균
		   for(int i=0;i<name.length;i++) { aver[i] = (kor[i]+eng[i]+mat[i]) / 3; }

//		   2-1. 평균이 60점이상이면 합격 아니면 불합격 / 40점 미만의 과목이 있으면 재시험
		   for(int i=0;i<aver.length;i++) { 
			   if(aver[i] < 60) { pass[i] = "불합격"; }
			   else if(kor[i]<40 || eng[i]<40 || mat[i]<40){ pass[i] = "재시험"; }
			   else { pass[i] = "합격"; }
		   }
		   
//		   3-1. 평균 95점이상 장학생
		   for(int i=0;i<aver.length;i++) {
			   if(aver[i] >= 95) { sch[i] = "장학생";}
			   else { sch[i] = " "; }
		   }
		   
//		   4-1. 등수 구하기  
		   for(int i=0;i<name.length;i++) {
			   for(int j=0;j<name.length;j++) {
				   if(!(aver[i]==aver[j]) && aver[i]<aver[j]) { num[i] += 1; }
			   } num[i] += 1;
		   }
		   
		   
//		   5. 랭킹(*) 넣기 - 평균 100점이면 * 10개
		   for(int i=0;i<name.length;i++) {
			   rank[i] = "";
			   for(int j=0;j<(aver[i]/10);j++) { rank[i] += "*"; }
		   }
		   
		   
//   	   출력:     
//		  	 
//		   이름      국어   영어   수학   평균   합격여부   장학생   
//		   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//		   아이언맨   100   100   100   100   합격    장학생   
//		   헐크      20    50    30    33    불합격   ----   
//		   캡틴      90    95    90    91    합격    ----   
//		   토르      70    80    60    70    합격    ----   
//		   호크아이   35    100   100   78    합격   ----   
//		   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

		   
		   System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
		   System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		 
		   for(int i=0;i<name.length;i++) {
			   System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", 
			   name[i], kor[i], eng[i], mat[i], aver[i], num[i], pass[i], sch[i], rank[i]); }

		   
		   
	} //

} //

package com.the703.basic008_ex;

import java.util.Arrays;

public class Array1Total {

	public static void main(String[] args) {

	  String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    
//	     1. 평균구하시오.
//	     2. 합격,불합격   -  평균이 60점이상이면 합격, 아니면 불합격으로 처리하시오.
//	     3. 장학생   - 평균 95점이상이면 장학생으로 처리하시오. 
	    
	   for(int i=0;i<name.length;i++) { aver[i] = (kor[i]+eng[i]+mat[i]) / 3; }
	   
	   String[] pass = new String[5];
	   String[] sch = new String[5];
	   
//	   /////// 처리2 : 합격,불합격 
//	   2-1. 평균이 60점이상이면 합격    아니면 불합격
	   
	   for(int i=0;i<aver.length;i++) { 
		   if(aver[i] >= 60){ pass[i] = "합격"; }
		   else { pass[i] = "불합격"; }
	   }
	   
//	   /////// 처리3 : 장학생
//	   3-1. 평균 95점이상 장학생
	   
	   for(int i=0;i<aver.length;i++) {
		   if(aver[i] >= 95) { sch[i] = "장학생";}
		   else { sch[i] = "----"; }
		 }
	    
	   
//	3.출력:     
//   
//   이름      국어   영어   수학   평균   합격여부   장학생   
//   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//   아이언맨   100   100   100   100      합격   장학생   
//   헐크      20   50   30   33   불합격   ----   
//   캡틴      90   95   90   91   합격   ----   
//   토르      70   80   60   70   합격   ----   
//   호크아이   35   100   100   78      합격   ----   
//   :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

	   
	   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	   System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부\t장학생");
	   System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	 
	   for(int i=0;i<name.length;i++) {
		   System.out.printf("%s\t %d\t %d\t %d\t %d\t %s\t %s\n", 
		   name[i], kor[i], eng[i], mat[i], aver[i], pass[i], sch[i]); }
		   

	
	} //

} //

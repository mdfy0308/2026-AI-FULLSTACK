package com.the703.basic008_ex;

import java.util.Arrays;

public class Array3Total {

	public static void main(String[] args) {
		
		   String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
		   int[] kor={100,100,100,70,35};   
		   int[] eng={100,100,100,80,35};
		   int[] mat={100,100,100,60,35};
		   int[] aver = new int[5];
		   int[] rank = {1, 1, 1, 1, 1};
		   boolean chk = false;
		    
		   String[] num = new String[5];
		   String[] pass = new String[5];
		   String[] sch = new String[5];
		   
//		   1. 평균
		   for(int i=0;i<name.length;i++) { aver[i] = (kor[i]+eng[i]+mat[i]) / 3; }

//		   2. 평균이 60점 이상이면 합격 아니면 불합격
		   for(int i=0;i<aver.length;i++) { 
			   if(aver[i] < 60)  { pass[i] = "불합격"; }
			   else { pass[i] = "합격"; }
		   }
		   
//		   3. 평균 95점 이상이면 장학생
		   for(int i=0;i<aver.length;i++) {
			   if(aver[i] >= 95) { sch[i] = "장학생";}
			   else { sch[i] = "----"; }
		   }
		   
//		   4. 등수 구하기  
		   // 만점자 3명을 모두 1등으로 표기 > [동일한 점수를 가진 인원수]를 카운트에서 제외하려면..
		   // 동일한 점수가 무엇인지 확인하고 제외하고싶음(숫자를 바꾸어도 적용되게)
		   
		 		   
//		   for(int i=0; i<name.length;i++) {
//	            for(int j=0;j<name.length;j++) {
//	                if(aver[j] > aver[i]) {
//	                    chk = false;
//	                    for(int k = 0; k < j; k++) {
//	                        if(aver[k] == aver[j]) { chk = true; break; }
//	                    }
//	                    if(!chk) rank[i]++;
//	                }
//	            }
//	        }

		   
//		   5. 랭킹(*) 넣기 - 평균 100점이면 * 10개
		   for(int i=0;i<name.length;i++) {
			   num[i] = "";
			   for(int j=0;j<(aver[i]/10);j++) { num[i] += "★"; }
		   }
		   

//         6. 출력

		   System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹");
		   System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		 
		   for(int i=0;i<name.length;i++) {
			   System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n", 
			   name[i], kor[i], eng[i], mat[i], aver[i], rank[i], pass[i], sch[i], num[i]); }
		   
	} //

} //

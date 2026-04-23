package com.the703.basic010_ex;

import com.the703.basic010.Score;

public class ModifierEx2 {

	public static void main(String[] args) {
		
		Score iron = new Score();
		Score hulk = new Score("hulk", 20, 50, 30);

		// Score.info()위에 메서드작성해주세요!
		// setter를 이용해주세요!
		iron.setName("iron");
		iron.setKor(100);
		iron.setEng(100);
		iron.setMath(100);
		iron.setTotal(300);
		iron.setAver(100.00);
		iron.setP("합격");
		iron.setS("장학생");
		iron.setRank("**********");
		
		Score.info(); // 클래스메서드
		iron.show();
		hulk.show();
	}

}

/*

:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름   국어   영어   수학   총점   평균   합격여부   장학생   랭킹
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
iron   100   100   100   300   100.00   합격   장학생   **********
hulk   20    50    30    100   33.33   불합격      	 ***

*/
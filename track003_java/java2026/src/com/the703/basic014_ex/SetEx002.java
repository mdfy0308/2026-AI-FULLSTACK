package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/* ### 문제 요구사항
1. HashSet<Integer> 를 이용해서 로또 번호를 생성한다.  
2. 1~45 사이의 난수 6개를 넣는다. (중복 제거)        
int num = rand.nextInt(45) + 1; // 1~45

3. 향상된 for문을 이용해서 로또 번호 6개를 출력한다.  
4. 사용자로부터 번호를 입력받아, 해당 번호가 로또 번호에 포함되어 있는지 확인한다.  

### 🖥️ 실행 결과 예시
=== 이번주 로또 번호 ===
7
12
23
34
41
45
> 확인할 번호 입력 : 
23
포함됨 → 23 */

public class SetEx002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> draw = new HashSet<>();
		Random random = new Random();
		int num, a; 
		
		for(;;) {
			if(draw.size()<=5) {
				num = random.nextInt(45) + 1;
				draw.add(num);
			} else { break; }
		}
				
		System.out.println("=== 이번주 로또 번호 ===");
		for(Integer i:draw) { System.out.println(i); }
		
		System.out.println("> 확인할 번호 입력 : ");
		a = sc.nextInt();
		
		for(Integer i:draw) { 
			if(i == a) { System.out.println("포함됨 → " + a); break; }
		}
		
	} //
} //

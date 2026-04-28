package com.the703.basic013_ex;

/*

1) 상속도 구조 
            Object
              ↑
        Astronaut { name, stamina / abstract explore(), report(), rest() }
   ↑            ↑               ↑ 
Engineer     Biologist       Pilot
{ @explore(), @explore(),    @explore(),
  @report(),  @report(),     @report(),
  @rest() }   @rest() }      @rest() }
  
- Astronaut는 추상 클래스이며, 모든 대원이 공통적으로 수행해야 할 기능을 설계함
- 각 대원 클래스는 Astronaut를 상속받아 기능을 구체적으로 구현함
- rest() 메서드는 각 대원의 고유한 휴식 방식 출력
  
*/

abstract class Astronaut {
	
	protected String name;
	protected int stamina;

	public void setName(String name) {
		this.name = name;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getStamina() {
		return stamina;
	}

	abstract void explore();

	abstract void report();

	abstract void rest();
}

class Engineer extends Astronaut {
	
	@Override
	void explore() {
		System.out.println(name + " 엔지니어 탐사: 기계 장치 점검 완료!");
	}

	@Override
	void report() {
		System.out.println(name + " 보고서: 에너지 시스템 안정적");
	}

	@Override
	void rest() {
		System.out.println(name + " 휴식: 공구 정리하며 재충전 중...");
	}
}


class Biologist extends Astronaut {
	
	@Override
	void explore() {
		System.out.println(name + " 생물학자 탐사: 외계 식물 샘플 채취!");
	}

	@Override
	void report() {
		System.out.println(name + " 보고서: 생명체 흔적 발견");
	}

	@Override
	void rest() {
		System.out.println(name + " 휴식: 생체 리듬 조절 중...");
	}
}


class Pilot extends Astronaut {
	
	@Override
	void explore() {
		System.out.println(name + " 파일럿 탐사: 항로 재설정 및 우주선 조종!");
	}

	@Override
	void report() {
		System.out.println(name + " 보고서: 궤도 진입 성공");
	}

	@Override
	void rest() {
		System.out.println(name + " 휴식: 조종석에서 짧은 명상...");
	}
}


public class AbstractEx002 {

	public static void main(String[] args) {

		// Astronaut astro = new Astronaut(); 
		// Q1. 왜 객체 생성이 불가능한가?
		// abstract 메서드는 구현부가 없어 실체화되지 않음

		System.out.println("\n--- 우주 탐사 대원 시뮬레이션 ---");
		Astronaut[] crew = { new Engineer(), new Biologist(), new Pilot() };
		String[] names = { "Nova", "Flora", "Jet" };
		int[] stamina = { 75, 60, 85 };

		// Q2. 체력이 낮은 대원만 휴식 70미만이 휴식을 취하게 만들기
		int cnt = 0;
		for(Astronaut a : crew) {
			a.name = names[cnt];
			a.stamina = stamina[cnt]; cnt++;
			
			a.explore();
			a.report();
			if(a.stamina < 70) {
				a.rest();
				System.out.println();
			} else { 
				System.out.println(a.name + "는 충분한 체력을 유지 중입니다.\n"); 
			}
			
		}
		

	} //

} //

/*

출력화면
--- 우주 탐사 대원 시뮬레이션 ---
Nova 엔지니어 탐사: 기계 장치 점검 완료!
Nova 보고서: 에너지 시스템 안정적
Nova는 충분한 체력을 유지 중입니다.

Flora 생물학자 탐사: 외계 식물 샘플 채취!
Flora 보고서: 생명체 흔적 발견
Flora 휴식: 생체 리듬 조절 중...

Jet 파일럿 탐사: 항로 재설정 및 우주선 조종!
Jet 보고서: 궤도 진입 성공
Jet는 충분한 체력을 유지 중입니다.

*/
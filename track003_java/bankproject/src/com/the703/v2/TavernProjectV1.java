package com.the703.v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class TavernDto {
	
	private String guest;
	private int res_num, res_date;
	
	private double total;
	
	public TavernDto() {
		super();
	}
	
	public TavernDto(String guest, int res_num) {
		super();
		this.guest = guest;
		this.res_num = res_num;
	}
	
	public TavernDto(String guest, int res_num, int res_date, double total) {
		super();
		this.guest = guest;
		this.res_num = res_num;
		this.res_date = res_date;
		this.total = total;
	}

	public String getGuest() { return guest; }  
	public void setGuest(String guest) { this.guest = guest; }  
	public int getRes_num() { return res_num; }  
	public void setRes_num(int res_num) { this.res_num = res_num; }  
	public int getRes_date() { return res_date; }  
	public void setRes_date(int res_date) { this.res_date = res_date; }  
	public double getTotal() { return total; }  
	public void setTotal(double total) { this.total = total; }

	@Override
	public int hashCode() {
		return Objects.hash(guest, res_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TavernDto other = (TavernDto) obj;
		return Objects.equals(guest, other.guest) && res_num == other.res_num;
	}
}


class Tavern {
	
	List<TavernDto> guests;
	Map<String, Integer> room = new HashMap<>();
	Map<String, Integer> service = new HashMap<>();
	

	public Tavern() { super(); }


	public Tavern(List<TavernDto> guests) {
		super(); this.guests = guests;
	}


	void reserve() {
		int choice = -1;
		Scanner sc = new Scanner(System.in);
		
		while(choice != 0) {
			
			/*
			 메뉴에는 뭘 넣지?
			 1. 예약하기(메뉴 고르기/계산하고 최종 예약 금액 확인)
			 	- 방 고르기(방(이름:가격) 정하기) → 추가 서비스(서비스(이름:가격) 정하기) → 예약 내용 확인 (게스트, 날짜, 방, 최종 금액)
			 	- 이미 정해진 메뉴 안에서 고르게 하고싶음
			 2. 예약 확인하기
			 	- 게스트 이름으로 예약 내용 조회하기 (게스트, 날짜, 방, 최종 금액)
			 3. 예약 취소
			 	- 게스트 이름과 예약 번호를 확인하고 취소하기
			 4. 서비스 추가
			 	- 이용중 추가 결제 항목(서비스(이름:가격) 정하기)
			 
			 */
			
		}
		
		
	}//
}//


public class TavernProjectV1 {
	public static void main(String[] args) {
		
		List<TavernDto>  guests = new ArrayList<>();
		Tavern      controller = new Tavern(guests);
		controller.reserve();

	}// 
}//

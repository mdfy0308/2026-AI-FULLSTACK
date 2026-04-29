package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1. 아이스크림 정보 클래스

class IceCreamDTO {

	private String name;
	private int price;

	// 생성자, 필요하다면 추가, toString, getters/setters, hashCode/equals
	public IceCreamDTO() { super(); }
	public IceCreamDTO(String name) { super(); this.name = name; }
	public IceCreamDTO(String name, int price) { super(); this.name = name; this.price = price; }
	
	@Override
	public String toString() { return "IceCreamDTO [name=" + name + ", price=" + price + "]"; }
	public String getName() { return name; }  public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }  public void setPrice(int price) { this.price = price; }

	//1. IceCreamDTO 확인 ##
	@Override public int hashCode() { return Objects.hash(name); }

	//2. 값 확인
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		IceCreamDTO other = (IceCreamDTO) obj;
		return Objects.equals(name, other.name);
	}

}

//2.List 사용 클래스
public class ListEx003 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String name = "";
		int price = 0, choice = -1;
		List<IceCreamDTO> list = new ArrayList<>();

		System.out.println("❄️🍦 Welcome to the Magical IceCream Land 🍦❄️");
		System.out.println("✨ 오늘도 달콤한 하루가 시작됩니다! ✨");
		System.out.println("🛎️ 손님~ 어떤 아이스크림을 원하시나요?");

		while (choice != 0) {
			System.out.println();
			System.out.print("📋 메뉴판\n" + "🍧 IceCream Menu 🍧\n" + "1️ 아이스크림 추가\n" + 
					"2️ 아이스크림 목록 보기\n" + "3️ 아이스크림 제거\n" + "4️ 아이스크림 존재 확인\n" + 
					"5️ 총 아이스크림 개수\n" + "6 총 아이스크림 정렬\n" + "0️ 종료\n" + "👉 선택: ");

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("🍓 아이스크림 이름: ");
				name = sc.next();
				System.out.print("💰 가격: ");
				price = sc.nextInt();
				list.add(new IceCreamDTO(name, price));
				System.out.print("✅" + name + " 추가 완료!");
				break;

			case 2:
				if (list.size() == 0) {
					System.out.println("❌ 등록된 아이스크림이 없습니다!");  continue;
				} else {
					System.out.println("🍨 현재 아이스크림 목록: ");
					for (IceCreamDTO ice : list) {
						System.out.printf("-%s(%d)\n", ice.getName(), ice.getPrice());
					}
				}
				break;

			case 3:
				System.out.println("🗑️ 제거할 아이스크림 이름: ");
				name = sc.next();
				System.out.println(list.remove(new IceCreamDTO(name))? "🧹 제거 완료!":"제거 실패.");
				
//				int cnt = 0;
//				for (IceCreamDTO ice : list) {
//					if (name.equals(ice.getName())) {
//						list.remove(cnt);
//						System.out.println("🧹 제거 완료!");
//						break;
//					}
//					cnt++;
//				}
				
				break;

			case 4:
				System.out.println("🔍 확인할 아이스크림 이름: ");
				name = sc.next();
				
				//if (list.contains(new IceCreamDTO(name))) {
				//		System.out.println("✅ 존재합니다!");
				//} else {
				//		System.out.println("❌ 없습니다!");
				//}
								
				System.out.println(list.contains(new IceCreamDTO(name))? "✅ 존재합니다!" : "❌ 없습니다!");
				break;

			case 5:
				System.out.println("📦 총 아이스크림 개수: " + list.size());
				break;

			case 6:
				System.out.println("📏 정렬 기준 선택: 1) 이름순  2) 가격순 ");
				choice = sc.nextInt();
				
				switch (choice) {
				case 1:
					Collections.sort(list, Comparator.comparing(IceCreamDTO::getName));
					System.out.println("🍦 이름 내림차순으로 정렬 완료!");
					break;
				case 2:
					Collections.sort(list, Comparator.comparing(IceCreamDTO::getPrice));
					System.out.println("🍦 가격순으로 정렬 완료!");
					break;
				default:
					System.out.println("다시 선택하세요.");
					break;
				}
				break;

			case 0:
				System.out.print("👋 아이스크림 가게를 닫습니다. 다음에 또 만나요!");
				break;

			} // switch

		} // while

	}// main

}// class


/*

1. Collections.sort()는 List 정렬을 위한 메서드
2. 기본은 오름차순. Collections.reverseOrder()로 내림차순도 가능
3. Comparator 를 이용해 사용자 정의 객체도 정렬할 수 있음
4. Array.sort()와는 정렬 대상이 다르다






*/
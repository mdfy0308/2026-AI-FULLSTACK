package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class MilkDto {
	
	// 1. Milk Dto 클래스 만들기  
	// - 속성 : private String mname; private int mprice  
	
	private String mname; 
	private int mprice, cnt;
	
	public MilkDto() { super(); }
	public MilkDto(String mname, int mprice) {
		super();
		this.mname = mname;
		this.mprice = mprice;
	}
	
	@Override
	public String toString() { return ++cnt + "\t" + mname + "\t" + mprice; }
	
	public String getMname() { return mname; } 
	public void setMname(String mname) { this.mname = mname; } 
	public int getMprice() { return mprice; } 
	public void setMprice(int mprice) { this.mprice = mprice; }
	
	@Override
	public int hashCode() { return Objects.hash(mname, mprice); }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MilkDto other = (MilkDto) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;
	}
}

/*
Q1. 빈칸 채우기
1. List는 순서가 [ 있는 ] 구조로 데이터를 관리하며, 중복을 [ 허용 ]
    - 주요 메서드: add, get, size, remove, contains
2. Set은 순서가 [ 없는 ] 구조로 데이터를 관리하며,  중복을 [ 불가 ]
    - 주요 메서드: add, 향상된 for/Iterator, size, remove, contains
3. Map은 [key]와 [value]의 쌍으로 데이터를 관리한다.
    - 주요 메서드: put, get(key), size, remove, contains
*/

public class Day028 {
	public static void main(String[] args) {
		
		//Q2. ArrayList, HashSet, HashMap을 작성하시오.
		//2. milks 이름으로 ArrayList 만들기  
		List<MilkDto> milks = new ArrayList();
		
		//3. 다음의 데이터 넣기
		milks.add(new MilkDto("커피우유", 1500));
		milks.add(new MilkDto("메론맛우유", 1800));
		milks.add(new MilkDto("커피우유", 1500));
		milks.add(new MilkDto("바나나우유", 1300));
		
		// 4. for + size 이용해서 데이터 출력  
		for(int i=0;i<milks.size();i++) {
			System.out.printf("%d\t%s\t%d\n", i+1, milks.get(i).getMname(), milks.get(i).getMprice());
		}
		
		//오름차순
		System.out.println("\n가격순으로 오름차순");
		// milks.sort( (m1, m2) -> Integer.compare(m1.getMprice(), m2.getMprice()) );
		// void java.util.List.sort( Comparator<? super MilkDto> c )
		// 리턴값 void (안에서 알아서 처리)
		// Comparator<? super MilkDto> c - 부품 객체를 비교해주는 부품 객체
		
		// 1. 익명적 개체
//		milks.sort(new Comparator<MilkDto>() {
//			@Override
//			public int compare(MilkDto o1, MilkDto o2) {
//				return Integer.compare(o1.getMprice(), o2.getMprice());
//			}
//		});
		
		// 2. 람다식
		// milks.sort( (m1, m2) -> Integer.compare(m1.getMprice(), m2.getMprice()) );
		
		// 3. 참조형
		// error : milks.sort( Integer::compare ); 오류 > 부품이 아닌 부품 안에 있는 값을 비교해야함(MilkDto-getMprice)
		milks.sort(Comparator.comparingInt( MilkDto::getMprice) );
		
		int i = 0;
		for(MilkDto m : milks) { System.out.printf("%d\t%s\t%d\n", ++i, m.getMname(), m.getMprice()); }
		
		// 5. sets 이름으로 HashSet 만들기
		Set<MilkDto> sets = new HashSet<>();
		
		// 6. 다음의 데이터 넣기
		sets.add(new MilkDto("바나나우유", 1300));
		sets.add(new MilkDto("메론맛우유", 1800));
		sets.add(new MilkDto("커피우유", 1500));
		sets.add(new MilkDto("커피우유", 1500));
		
				
		// 7. Iterator 이용해서 데이터 출력
//		sets.iterator();
//		Iterator<MilkDto> ster = sets.iterator(); //줄세우기
//		int cnt = 0;
//		
//		while(ster.hasNext()) {
//			MilkDto m = ster.next();
//			System.out.println(++cnt +"\t"+ m.getMname() +"\t"+ m.getMprice());
//		}
		
//		cnt = 0;
//		for(MilkDto m:sets) {
//			System.out.println(++cnt +"\t"+ m.getMname() +"\t"+ m.getMprice());
//		}
		
		// 8. maps 이름으로 HashMap 만들기  
		Map<String, MilkDto>maps = new HashMap<>();
		
		// 9. 다음의 데이터 넣기 (Key-Value 구조) 
		maps.put("banana", new MilkDto("바나나우유", 1300));  
		maps.put("melon", new MilkDto("메론맛우유", 1800));  
		maps.put("coffee", new MilkDto("커피우유", 1500));  
		maps.put("coffee2", new MilkDto("커피우유", 1500));  
		
		// 10. for-each + keySet 이용해서 데이터 출력
		
//		for(String key : maps.keySet()) {
//			System.out.println(key +"\t"+ maps.get(key) +"\t"+ maps.get(key).getMprice());
//		}
		
//		Iterator<Entry<String, MilkDto>> iter = maps.entrySet().iterator();
//
//		for(Entry<String, MilkDto> m : maps.entrySet()) {
//			String key = m.getKey();
//			MilkDto value = m.getValue();
//			System.out.println(key +"\t"+ value.getMname() +"\t"+ value.getMprice() );
//		}
		
		
	}//
}//
package com.the703.basic014;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// List - 순서/중복O
// Set - 순서/중복X
// Map - key:value	put, get(key), size, remove, contains

public class Map001 {
	public static void main(String[] args) {
		
		Map<String, Integer> maps = new HashMap();
		maps.put("one"	, 1); // 키, 값
		maps.put("two"	, 2); // 앤트리
		maps.put("three", 3); //
		
		System.out.println("1 : " + maps);
		System.out.println("2 : " + maps.get("two"));
		System.out.println("3 : " + maps.size());
				
		System.out.println("4-1 : " + maps.remove("two"));
		System.out.println("4-2 : " + maps);
		System.out.println("5-1 : " + maps.containsKey("three"));
		System.out.println("5-2 : " + maps.containsValue(2)); // 없는 값
		
		System.out.println("6-1 : " + maps.entrySet()); // 키:밸류 한쌍의 묶음
		System.out.println("6-2 : " + maps.keySet()); // key 객체들로만 구성된 묶음
		
		for(Entry<String, Integer> m : maps.entrySet()) {
			System.out.println(m.getKey() +"-"+ m.getValue() );
		}
		
		for(String key : maps.keySet()) {
			System.out.println(key +"-"+ maps.get(key));
		}
		
		Iterator<Entry<String, Integer>> iter = maps.entrySet().iterator();
		// #1. 반복자 - 알아서 처리 → maps.entrySet() key/value의 한쌍으로 . iterator 줄을 세우는 것
		// iter → [one=1, three=3]
		
		while(iter.hasNext()) {
			// #2. hasNext() 처리대상 확인 iter → [one=1, three=3]
			Entry<String, Integer> m = iter.next(); // #3. next() 한개씩 꺼내오기
			System.out.println(m.getKey() +"-"+ m.getValue());
		}
		
		
		Iterator<String> kiter = maps.keySet().iterator();
		//#1. 키를 모아서 [one, three] .iterator() 줄 세우기
		
		//	 kiter → [one, three]
		while(kiter.hasNext()) {// #2. hasNext() 처리대상 확인 kiter [one, three]
			String key = kiter.next(); // #3. next() 한개씩 꺼내오기
			System.out.println(key +"="+ maps.get(key));
		}
		
		
	} //	
} //

package com.the703.basic015;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream003 {
	public static void main(String[] args) {

		Integer[] ages = { 17, 21, 26, 45, 18 };
		Stream<Integer> sages = Arrays.stream(ages);

		// Ex1. 짝수만 출력
		sages.filter(t -> t % 2 == 0).forEach(System.out::print);
		
		System.out.println();
		// Ex2. 평균값 출력
		// (t) -> {return}
		// int java.util.function.ToIntFunction.applyAsInt( T value )
		sages = Arrays.stream(ages);
		double aver = sages.mapToInt(age -> age) // IntStream으로 변환
						   .average()			   // 평균 계산
						   .orElse(0.0);		   // 값 없으면 0.0
		System.out.println(aver);
	    

		// Ex3. 제일 나이가 많은 사람
		sages = Arrays.stream(ages);
		int max = sages.mapToInt(age -> age) // IntStream으로 변환
				   .max()
				   .orElse(0);
		System.out.println(max);
		
		// Ex4. 나이 정렬해서 리스트로
		List<Integer> list = Arrays.stream(ages) // stream
								   .sorted() // 정렬
								   .collect(Collectors.toList()); 
		System.out.println("정렬된 리스트: " + list);
		
		//Ex5. 20살 이상만 필터링해서 리스트로 수집
		List<Integer> alist = Arrays.stream(ages)
									.sorted(Comparator.reverseOrder())
									.filter( t -> t>=20 )
									.collect(Collectors.toList());
		System.out.println("20살 이상: " + alist);

		
		
	} //
} //

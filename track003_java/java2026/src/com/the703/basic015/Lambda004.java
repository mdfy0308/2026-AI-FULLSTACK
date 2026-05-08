package com.the703.basic015;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Lambda004 {

	public static void main(String[] args) {

		// ( t ) -> {}	accept
		// void java.util.function.Consumer.accept( T t )
		// 1. Consumer 받는용도
		Consumer<String> consumer = (t) -> { System.out.println("Hello :)" + t); };
		
		// ver-1 람다식 정리
		Consumer<String> consumer1 = t -> System.out.println("Hello :)" + t);
		
		// ver-2 참조형 가능? →
		Consumer<String> consumer2 = System.out::println; // Hello가 빠짐...
		
		consumer.accept(" java");
		consumer1.accept(" lambda~");
		consumer2.accept("Hello :) weekend!!");

		//////////////////////////////////////////////////////////////
		
		// () -> { return }
		// T java.util.function.Supplier.get()
		// 2. Supplier get 주는용도
		Supplier<String> supplier = () -> { return "Bye"; };
		
		// ver-1 람다식 정리
		Supplier<String> supplier1 = () -> "Bye";
		System.out.println( supplier1.get() );
		
		//////////////////////////////////////////////////////////////

		// ( t ) -> {	return true;	} test 판단용도
		// boolean java.util.function.Predicate.test( T t )
		// 3. Predicate 판단용도
		Predicate<Integer> predicate = (t) -> { return t < 0; };
		
		//ver-1 람다식 정리
		Predicate<Integer> predicate1 = t -> t < 0;
		System.out.println( predicate.test(10) ); // 양수 false
		System.out.println( predicate1.test(-10) ); // 음수 true
		
		//////////////////////////////////////////////////////////////

		// (t) -> { return } 처리
		// java.util.function.Function.apply( T t )
		// 4. Function 처리용도
		Function<String, Integer> function = (t) -> { return Integer.parseInt(t); };
		
		//ver-1 람다식 정리
		Function<String, Integer> function1 = t -> Integer.parseInt(t);
		
		//ver-2 참조형 정리
		Function<String, Integer> function2 = Integer::parseInt;

		System.out.println( function.apply("10") + 3);
		System.out.println( function1.apply("5") + 3);
		System.out.println( function2.apply("2") + 1); 
		
		//////////////////////////////////////////////////////////////
		
		// (int left, int right) -> { return };
		// java.util.function.IntBinaryOperator.applyAsInt( int left, int right )
		// 5. Operator 연산용도
		IntBinaryOperator operator = (a, b) -> { return a>b? a:b; };
		
		//ver-1 람다식 정리
		IntBinaryOperator operator1 = (a, b) -> a>b? a:b;
		
		System.out.println(operator.applyAsInt(3, 5));
		System.out.println(operator1.applyAsInt(8, 0));
		
	}//
}//

/**********

자바의 api 함수형인터페이스

1.   Consumer  받는용도 


2.   Supplier  제공용도   


3.   Predicate 판단용도


4.   Function  처리용도


5.   Operator  연산용도



*/
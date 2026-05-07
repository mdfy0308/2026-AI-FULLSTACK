package com.the703.basic015;

class RefClass{       void method(String str) {  System.out.println(str);}  }
interface InterUsing{ void inter( RefClass c  , String str); }  


public class Lambda003 {
	public static void main(String[] args) {
		
		//#1. 익명클래스
		InterUsing a1 = new InterUsing() {
			@Override public void inter(RefClass c, String str) { c.method(str); }
		};
		
		a1.inter(new RefClass(), "Hello~"); // 부품객체[Ref 클래스]의 기능박스[method]를 사용
		
		//#2. 람다식 [Ref 클래스]의 [method]를 사용
		InterUsing a2 = (c, str)-> c.method(str); // 직접구현
		a2.inter(new RefClass(), "Bye~");
		
		//#3. :: 표현식(참조)
		InterUsing a3 = RefClass::method; // 자동연결 1) RefClass 2)method
		a3.inter(new RefClass(), "ciao!");
		
		
		/////////////////////////////////////////////////////////////////
		
		
		// Math.max
		// interface  InterBasic {  int method(int a, int b);         }  
		InterBasic basic1 = (a, b) -> { return Math.max(a, b); }; // max static(바로 사용가능)
		System.out.println( basic1.method(10, 3));
		
		InterBasic basic2 = (a, b) -> Math.max(a, b); // Math 부품, max 사용(바로 사용가능)
		System.out.println( basic2.method(5, 83));
		
		InterBasic basic3 = Math::max; // Math 부품, max 기능 사용(바로 사용가능)
		System.out.println( basic3.method(30, 23));
		
		
		
		// Math.min
		InterBasic basic4 = (a, b) -> Math.min(a, b); // Math 부품, min 기능 사용(바로 사용가능)
		System.out.println( basic4.method(8, 3));
		
		InterBasic basic5 = Math::min; // Math 부품, min 기능 사용(바로 사용가능)
		System.out.println( basic4.method(8, 3));
		
		
		
		//String.compareTo
		InterString basic6 = (a, b) -> a.compareTo(b);
		//int java.lang.String.compareTo( String anotherString )
		System.out.println( basic6.compare("apple", "banana") );
		// (음수) a<b, a가 b보다 앞에 와요, (양수) a>b a가 b보다 뒤에 와요
		
		InterString basic7 = String::compareTo; // String 부품객체의 compareTo 기능
		System.out.println( basic7.compare("coconut", "banana"));
		
		
		
		//interface  InterParse	{ int parse(String s);              }
		InterParse basic8 = s -> Integer.parseInt(s);
		System.out.println( basic8.parse("10") + 3); // 문자열을 숫자로
		
		//참조형으로 바꾸기
		InterParse basic9 = Integer::parseInt;
		System.out.println( basic9.parse("25") + 25 );
		
		
		
		//Math.abs
		//interface  InterAbs  	{ int apply(int a);                 } 
		InterAbs basic10 = a -> Math.abs(a); // Math 부품의 abs 사용
		System.out.println( basic10.apply(-10) ); // abs : 절대값으로 변경하는 기능박스
		// → 참조형으로 바꾸기
		InterAbs basic11 = Math::abs;
		System.out.println( basic11.apply(-99) );
		
		
		
		//System.out::println
	    //interface  InterPrint{  void print(String s);             }  
	    InterPrint basic12  = s-> System.out.println(s);  // System.out  부품의   println 기능사용
	    basic12.print("Hello");   
	    // → 참조형으로 바꾸기
	    InterPrint basic13 = System.out::println;
	    basic13.print("Lambda");
		
	    
	    
	    // interface  Ex1{  int getLength(String s);  }  
	    Ex1 basic14 = s -> s.length();
	    System.out.println( basic14.getLength("hello") );
	    // → 참조형으로 바꾸기
	    Ex1 basic15 = String::length;
	    System.out.println( basic15.getLength("hi") );
	    
	    
	    
	    // interface  Ex2{  void print(String s);     }  
	    Ex2 basic16 = s -> System.out.print(s);
	    basic16.print("Hello");
	    // 참조형으로
	    InterPrint basic17 = System.out::print;
	    basic17.print("\nLambda :)");
	  
	} //
} //

interface  InterBasic	{ int method(int a, int b);         }  
interface  InterString	{ int compare(String a, String b);  }  
interface  InterParse	{ int parse(String s);              }  
interface  InterAbs  	{ int apply(int a);                 }  
interface  InterPrint	{ void print(String s);             }  

interface  Ex1{  int getLength(String s);  }   
interface  Ex2{  void print(String s);     }  
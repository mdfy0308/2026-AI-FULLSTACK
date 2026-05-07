package com.the703.basic015;

////////////////////////////////////////////////////////////

interface InterA2 { void hi(); }

interface InterB2 { void hi(String name); }

interface InterC2 { String hi(); }

interface InterD2 { String hi(int num, String name); }

////////////////////////////////////////////////////////////

public class Lambda002 {
	public static void main(String[] args) {

		// interface InterA2{ void hi(); }
		System.out.println("\n[STEP1] 매개변수X 리턴값X");
		// 1-1. 익명 객체
		InterA2 a1 = new InterA2() {
			@Override
			public void hi() {
				System.out.println("Hi");
			};
		};
		a1.hi();

		// 1-2 람다식 (받아서) -> {처리해줄게}
		InterA2 a2 = () -> { System.out.println("Hello!"); }; a2.hi();
		InterA2 a3 = () -> System.out.println("Hi Hi~~"); // 처리할 일이 1줄이면 {} 생략 가능
		a3.hi();

		// interface InterB2{ void hi(String name); }
		System.out.println("\n[STEP2] 매개변수X 리턴값X");
		// 2-1. 익명 객체
		InterB2 b1 = new InterB2() {
			public void hi(String name) {
				System.out.println("Hi, " + name);
			}
		};
		b1.hi("sujeong");

		// 2-2 람다식 () -> {}
		InterB2 b2 = (String name) -> { System.out.println("Hi, " + name); };
		b2.hi("alpha");
		
		InterB2 b3 = name -> System.out.println("Hi, " + name); // () {} 1줄일때 생략가능
		b3.hi("beta");
		
		//interface InterC2 { String hi(); }
		System.out.println("\\n[STEP3] 매개변수X 리턴값O");
		// 3-1. 익명 객체
		InterC2 c1 = new InterC2() {
			@Override
			public String hi() {
				return "Good :Day";
			}
		}; System.out.println( c1.hi()); 
		
		// 3-2 람다식 () -> {}
		InterC2 c2 = () -> { return "Good :Day"; };
		InterC2 c3 = () -> "G:ood Day";
		System.out.println( c2.hi() );
		System.out.println( c3.hi() );

		//interface InterD2 { String hi(int num, String name); }
		System.out.println("\n[STEP4] 매개변수O 리턴값O");
		// 4-1. 익명 객체
		InterD2 d1 = new InterD2() {
			@Override
			public String hi(int num, String name) {
				String star="";
				for(int i=0;i<num;i++) { star+= "★"; };
				return "hi, " + name + star;
			} 
		}; System.out.println( d1.hi(1, "alpha ") );
		
		// 4-2 람다식 () -> {}
		InterD2 d2 = (num, name) -> { 
			String star="";
			for(int i=0;i<num;i++) { star+= "★"; };
			return "hi, " + name + star;
		}; System.out.println( d2.hi(2, "beta ") );
		
		InterD2 d3 = (num, name) -> { return "hi, " + name + "★".repeat(num); };
		System.out.println( d3.hi(3, "daisy") );
		System.out.println( d3.hi(5, "rouis") );
		System.out.println( d3.hi(7, "emma") );
	}//
}//

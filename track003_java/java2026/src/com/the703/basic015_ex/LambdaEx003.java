package com.the703.basic015_ex;

interface MovieTitle { String convert(String title); }
interface FoodLength { int getLength(String food); }
interface ScoreCompare { int compare(int a, int b); }

public class LambdaEx003 {
    public static void main(String[] args) {
        
        // 문제 1: 영화 제목 대문자 변환 
    	MovieTitle m1 = new MovieTitle() {
			@Override
			public String convert(String title) { return title.toUpperCase(); }
    	};
        System.out.println("익명객체 결과: " + m1.convert("avengers"));
        
        MovieTitle m2 = title -> title.toUpperCase();
        System.out.println("람다식 결과: " + m2.convert("inception"));
        
        MovieTitle m3 = String::toUpperCase;
        System.out.println("메서드참조 결과: " + m3.convert("matrix"));


        // 문제 2: 음식 이름 길이 반환 
        FoodLength f1 = new FoodLength() {
			@Override public int getLength(String food) { return food.length(); }
        };
        System.out.println("익명객체 결과: " + f1.getLength("pizza"));
        
        FoodLength f2 = food -> food.length();
        System.out.println("람다식 결과: " + f2.getLength("hamburger"));
        
        FoodLength f3 = String::length;
        System.out.println("메서드참조 결과: " + f3.getLength("ramen"));


        // 문제 3: 점수 비교 
        
        ScoreCompare s1 = new ScoreCompare() {
			@Override
			public int compare(int a, int b) { return Math.max(a, b); }
        };
        System.out.println("익명객체 결과: " + s1.compare(85, 92));
        
        ScoreCompare s2 = (a, b) -> Math.max(a, b);
        System.out.println("람다식 결과: " + s2.compare(70, 65));
        
        ScoreCompare s3 = Math::max;
        System.out.println("메서드참조 결과: " + s3.compare(100, 99));
        
    } //
} //
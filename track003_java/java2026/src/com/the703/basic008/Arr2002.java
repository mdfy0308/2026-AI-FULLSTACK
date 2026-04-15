package com.the703.basic008;

public class Arr2002 {

	public static void main(String[] args) {

		// 1. 값을 알고 있는 경우
		int[][] arr2 = { { 1, 2, 3 }, // 00 01 02
				{ 4, 5, 6 }, // 10 11 12
		};

		// 2. 값을 모르는 경우
		int[][] arr21 = new int[2][3];
		// new 메모리 빌려오기 int(자료형) 2층 3칸

		System.out.println(arr21);

		// ver-2 data를 받아오는 경우가 많기 때문에 data 값을 분리해서 생각해볼것
		// arr21[0][0] = 10; arr21[0][2] = 20; arr21[0][3] = 30;
		// arr21[1][0] = 40; arr21[1][2] = 50; arr21[1][3] = 60;
		
		// ver-3
		// int data = 10;
		// for (int kan = 0; kan < arr21[ch].length; kan++) { arr21[ch][kan] = data; data += 10; }
		// for (int kan = 1; kan < arr21[ch].length; kan++) { arr21[ch][kan] = data; data += 10; }

		// ver-4
		int data = 10;
		for (int ch = 0; ch < arr21.length; ch++) { // 배열명.length > 층
			for (int kan = 0; kan < arr21[ch].length; kan++) { // 배열명[n].length > 호
				arr21[ch][kan] = data; data += 10;
			}
		}

		for (int ch1 = 0; ch1 < arr21.length; ch1++) { // 2-1 배열의 층수
			for (int kan = 0; kan < arr21[ch1].length; kan++) { // 2-2 층의 칸수
				System.out.print(arr21[ch1][kan] + "\t");
			}
			// 2-3 한 층이 끝나면 해야할 일
			System.out.println();
		}

	} //

} //

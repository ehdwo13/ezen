package day03;

import java.util.Scanner;

public class For03 {

	public static void main(String[] args) {
		/*
		 * 약수 : 나누어서 떨어지는 수 집합 6의 약수 : 1 2 3 6
		 */
		int num = 6; // num를 1~num 까지 나눈 나머지가 0인 수를 출력
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();

		// num1를 입력받아서 약수를 출력
		Scanner sc = new Scanner(System.in);

		System.out.println("약수를 구할 수를 입력하세요. ");
		int num1 = sc.nextInt();
		for (int i = 1; i <= num1; i++) {
			if (num1 % i == 0) {
				System.out.print(i + " ");
			}
		}
		sc.close();
	}
}
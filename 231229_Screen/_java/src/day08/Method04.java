package day08;

import java.util.Scanner;

public class Method04 {

	public static void main(String[] args) {
		/*	최대공약수, 최소공배수 리턴
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 두개를 입력하세요. ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println("최대공약수는 " +max(num1, num2));
		System.out.println("최소공배수는 " +min(num1, num2));
		System.out.println("최소공배수규칙으로 구한 값은" +lcm(num1, num2));
		sc.close();
	}
	public static int max(int num1, int num2) {
		int max = 0;
		for(int i=1; i<=num1; i++) {
			if(num1 % i== 0 && num2 % i ==0){	
				max = i;
			}	
		}
		return max;
	}
	public static int min(int num1, int num2) {
		for(int i=num1; ;i+=num1) {
		if(i%num1 ==0 && i%num2 ==0) {
			return i;
			}	
		}
	}
	
	//최소공배수 규칙 : 두 수를 곱한 후에 최대공약수로 나누면 최소공배수
	public static int lcm(int num1, int num2) {
		return num1 * num2 / max(num1, num2);
	}
}
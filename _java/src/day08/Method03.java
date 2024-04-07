package day08;

import java.util.Scanner;

public class Method03 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int num = sc.nextInt();
		mul(num);
		sc.close();
	}
	//	정수 (2~9 중 하나)에 해당하는 구구단 출력 메서드
	// 매개변수 : 2
	// 리턴타입 : void 출력 => 리턴이 없음.
	public static void mul(int num) {
		 for(int i=1; i<=9; i++) {
		 	System.out.println(num+"*"+i+"="+num*i);
		 }
	}
}
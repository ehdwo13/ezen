package Pratice;

import java.util.Scanner;

public class 스위치계산기 {

	public static void main(String[] args) {
		/*	계산기 만들기
		 * 	--menu--
		 * 	1.덧셈 | 2.뺄셈 | 3.곱셈 | 4.나눗셈 | 5.나머지 | 6.종료
		 * 	>>메뉴선택 1
		 * 	>>숫자 1 5
		 * 	>>숫자 2 10
		 *  결과 : 5+10=15
		 *  (더하기 메서드를 호출하여 연산결과를 출력)
		 * */
		Scanner sc = new Scanner(System.in);		
		int menu = 0;
		do {
			System.out.println("---menu---");
			System.out.println("1. 더하기 \n2. 빼기 \n3. 곱하기 \n4. 나누기 \n5. 나머지 \n6. 종료 ");
			System.out.println("선택");
			menu = sc.nextInt();
			int num1=0, num2=0;
			if(menu<=5) {
				System.out.println("숫자 2개 입력");
				num1 = sc.nextInt();
				num2 = sc.nextInt();
			}
			switch(menu){
			case 1 :
				sum(num1, num2);
				break;
			case 2 :
				sub(num1, num2);
				break;
			case 3 :
				mul(num1, num2);
				break;
			case 4 :
				div(num1, num2);
				break;
			case 5 :
				mod(num1, num2);
				break;
			case 6 :
				System.out.println("종료합니다. ");
				break;
			default :
				System.out.println("잘못 선택하셨습니다. ");
			}
			
		}while(menu !=6);
		sc.close();
		}
	public static void sum(int num1, int num2) {
		System.out.println(num1+"+"+num2+"="+(num1+num2));
	}
	public static void sub(int num1, int num2) {
		System.out.println(num1+"-"+num2+"="+(num1-num2));
	}
	public static void mul(int num1, int num2) {
		System.out.println(num1+"*"+num2+"="+(num1*num2));
	}
	public static void div(int num1, int num2) {
		System.out.println(num1+"/"+num2+"="+(num1/num2));
	}
	public static void mod(int num1, int num2) {
		System.out.println(num1+"%"+num2+"="+(num1%num2));
	}
}
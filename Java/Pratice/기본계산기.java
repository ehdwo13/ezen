package Pratice;

import java.util.Scanner;
	
public class 기본계산기{
		
	public static void main(String args[]) {
			/* 정수 2개와 연산자 1개를 입력받아 두 정수의 연산을 출력
			 * ex) 2 3 + => 2+3=5
			 * ex) 5 1 - => 5-1=4
			 * 연산자는 + - / * % 가능
			 * 다른 종류의 연산자가 들어오면 잘못된 연산자로 출력
			 * */
			
			Scanner sc = new Scanner(System.in);
				
			System.out.print("첫번째 정수를 입력해주세요 : ");
			int A = sc.nextInt();
			System.out.print("두번째 정수를 입력해주세요 : ");
			int B = sc.nextInt();
			System.out.print("연산자를 입력하세요 : ");
			char sign = sc.next().charAt(0);		//문자열 입력 next() 그중 첫번째 문자 하나만 charAt(0)

//			switch 문
// 			연산자가 / % 일때 num2가 0이되면 안내문구 띄우기
			if((sign == '/' || sign == '%') && B==0) {	// ||연산자 = or 	&&연산자 = and
				System.out.println("다시입력해주세요.");
			}else {										//위의 if조건이 아닐시 switch 문 실행
				
			switch (sign) {
			case '+' :
				System.out.println(""+A+sign+B+"="+(A+B));	//연결연산자 공백위해 제일 처음칸 ""
				break;
			case '-' :
				System.out.println(""+A+sign+B+"="+(A-B));	
				break;
			case '*' :
				System.out.println(""+A+sign+B+"="+(A*B));	
				break;
			case '/' :
				System.out.println(""+A+sign+B+"="+(A/B));		
				break;
			case '%' :
				System.out.println(""+A+sign+B+"="+(A%B));	
				break;
				}
			}
			sc.close();
	}				
}
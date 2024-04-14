package day02;
import java.util.Scanner;
	public class 과제 {
		public static void main(String args[]) {
			/* 정수 2개와 연산자 1개를 입력받아 두 정수의 연산을 출력
			 * ex) 2 3 + => 2+3=5
			 * ex) 5 1 - => 5-1=4
			 * 연산자는 + - / * % 가능
			 * 다른 종류의 연산자가 들어오면 잘못된 연산자로 출력
			 * */
			
			//	 연산자 = char(기본자료형) == 비교가능 / String(객체) == 비교불가능
			
				Scanner sc = new Scanner(System.in);
				
				System.out.print("첫번째 정수를 입력해주세요 : ");
				int A = sc.nextInt();
				System.out.print("두번째 정수를 입력해주세요 : ");
				int B = sc.nextInt();
				System.out.print("연산자를 입력하세요 : ");
				char sign = sc.next().charAt(0);

//			switch 문
// 			연산자가 / % 일경우 num2가 0이되면 안내문구 띄우기
			if((sign == '/' || sign == '%') && B==0) {
				System.out.println("다시입력해주세요.");
			}else {
				
			switch (sign) {
			case '+' :
				System.out.println(""+A+sign+B+"="+(A+B));	//연결연산자 공백
				break;
			case '-' :
				System.out.println(""+A+sign+B+"="+(A-B));	
				break;
			case '*' :
				System.out.println(""+A+sign+B+"="+(A*B));	
				break;
			case '/' :
//				if (B==0) {
//					System.out.println("잘못된 입력값입니다.");	//위에서 먼저 거르고 내려와서 주석처리
//				}else {
				System.out.println(""+A+sign+B+"="+(A/B));	
//				}
				break;
			case '%' :
//				if (B==0) {
//					System.out.println("잘못된 입력값입니다.");
//				}else {
				System.out.println(""+A+sign+B+"="+(A%B));	
//				}
				break;
						
			}
			}
			sc.close();
//			if 문
//			if(sign=='+') {
//				System.out.println(A+B);
//			}else if(sign=='-') {
//				System.out.println(A-B);
//			}else if(sign=='*') { 
//				System.out.println(A*B);
//			}else if(sign=='/') {
//				System.out.println(A/B);
//			}else if(sign=='%') {
//				System.out.println(A%B);
//			}else{
//				 System.out.println("잘못된 연산자입니다.");
	}
				
}

	



package day04;

import java.util.Scanner;

public class DoWhile03 {

	public static void main(String[] args) {
		/*	숫자 2개를 입력받고,
		 * 	num 1 = 5 / num2 = 3
		 * 	menu
		 * 	1. + | 2. - | 3. * | 4. / | 5. % | 6. 종료
		 * 	menu에 따라서 두수의 연산결과를 출력
		 * 	1=> 5+3=8
		 * 	2=> 5-3=2
		 * 	6=> 종료
		 * 	다른 번호는 잘못된 메뉴로 출력
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 2개를 입력해주세요.");
		int A=0, B=0;
		A =sc.nextInt();
		B =sc.nextInt();
		int menu = 0;
			do {
			System.out.println("연산자번호를 선택해주세요. ");
			System.out.println("1. + | 2. - | 3. * | 4. / | 5. % | 6. 종료");
			menu=sc.nextInt();
			switch(menu) {
			case 1 : 
				System.out.println(A+"+"+B+"="+(A+B));
				break;
			case 2 :
				System.out.println(A+"-"+B+"="+(A-B));
				break;
			case 3 :
				System.out.println(A+"*"+B+"="+(A*B));
				break;
			case 4 :
				if(B==0) {
					System.out.println("연산을 할 수 없습니다.");
					System.out.println("다시 입력해주세요.");
					B=sc.nextInt();				
					System.out.println(A+"/"+B+"="+(A/B));
				}
				break;
			case 5 :
				if(B==0) {
					System.out.println("연산을 할 수 없습니다. ");
					System.out.println("다시 입력해주세요. ");
					B=sc.nextInt();			
					System.out.println(A+"%"+B+"="+(A%B));
				}
				break;
			case 6 :
				System.out.println("종료합니다. ");
				break;
			default:
				System.out.println("잘못된 메뉴입니다. ");
				break;
			}
			}while(menu != 6);
			sc.close();			
	}
}								
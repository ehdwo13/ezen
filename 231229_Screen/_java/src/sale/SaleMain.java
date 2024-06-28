package sale;

import java.util.Scanner;

public class SaleMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SaleManager sm = new SaleManager();
		int menu = -1;
		do {
			System.out.println("1.메뉴츄가 | 2.메뉴수정 | 3.메뉴삭제 | 4.메뉴보기 | 5.주문 | 6.주문내역출력 | 7.종료");
			System.out.println("메뉴 선택");
			menu =sc.nextInt();
			switch(menu) {
			case 1:sm.add(sc); 		 break;
			case 2:sm.modify(sc);	 break;
			case 3:sm.delete(sc);	 break;
			case 4:sm.menuPrint();	 break;
			case 5:sm.orderPick(sc); break;
			case 6:sm.orderPrint(sc);break;
			case 7:break;
			default : System.out.println("잘못누르셨습니다. ");
			}
		}while(menu!=7);
		System.out.println("종료합니다. ");
		sc.close();
	}
}
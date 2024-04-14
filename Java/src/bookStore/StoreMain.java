package bookStore;

import java.util.Scanner;

public class StoreMain {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		String menu = "-1";
		Customer c = new Customer();
		BookShelf b = new BookShelf();
		do {
			System.out.println("서점에 오신걸 환영합니다. \n메뉴를 선택해주세요. ");
			System.out.println("1. 회원가입 | 2. 도서검색 | 3. 도서구매 | 4. 도서리뷰 | 0. 종료하기 | *.관리자메뉴");
			menu = sc.next();
			switch(menu){
			case "1" : System.out.println("사용하실 ID, 비밀번호를 입력하고 실명을 입력해주세요. ");
						c.NewCustomer(sc.next(), sc.next(), sc.next()); break;
			case "2" : System.out.println("1. 이름으로 검색 | 2. 저자로 검색 | 3. 장르별 검색 "); 
				switch(menu) {
				case "1" : b.searchName(sc.next()); break;
				case "2" : break;
				case "3" : break;
				default : System.out.println("잘못누르셨습니다. ");
			}
				break;
			case "3" :
				break;
			case "4" :
				break;
			case "*" :
				break;
				default : System.out.println("잘못누르셨습니다. ");
			}

		}while(!(menu.equals("0")));
		System.out.println("종료합니다. ");
		
		sc.close();
	}

}

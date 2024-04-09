package jdbc;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	/*	Controller <-> Service <-> DAO <-> DB
	 * 	Controller 모든 메뉴에 분기처리
	 * */
	
	private Scanner sc;
	private Service svc; //아직 안만듦 interface
	private boolean flag; //종료 변수
	
	public ProductController() {
		sc = new Scanner(System.in);
		svc = new ProductServiceImpl(); //service 구현체
		flag = true;
		printMenu();
	}
	private void printMenu() {
		while(flag) {
			System.out.println("상품관리프로그램");
			System.out.println("1. 상품등록 | 2. 상품목록 | 3. 상품검색");
			System.out.println("4. 상품수정 | 5. 상품삭제 | 6. 종료");
			System.out.println("메뉴선택");
			
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 : register(); break;
			case 2 : list(); break;
			case 3 : detail(); break;
			case 4 : modify(); break;
			case 5 : remove(); break;
			default : 
				flag = false;
				break;
			}
		}
	}
	private void remove() {
		System.out.println("삭제할 상품번호를 입력해주세요. ");
		int pno = sc.nextInt();
		ProductVO p = svc.getRemove(pno);
		
	}
	private void modify() {
		System.out.println("수정할 상품번호를 입력해주세요. ");
		int pno = sc.nextInt();
		System.out.println("1. 이름수정 | 2. 가격수정 | 3. 상세정보수정");
		int menu = sc.nextInt();
		if(menu == 1) {
			System.out.println("수정할 이름을 입력해주세요. ");
			sc.nextLine();
			String modName = sc.nextLine();
			ProductVO p = svc.getModifyName(pno, modName);
		}else if(menu == 2) {
			System.out.println("수정할 가격을 입력해주세요. ");
			int modPrice = sc.nextInt();
			ProductVO p = svc.getModifyPrice(pno, modPrice);
		}else if(menu ==3) {
			System.out.println("수정할 상세정보를 입력해주세요. ");
			sc.nextLine();
			String modMadeby = sc.nextLine();
			ProductVO p = svc.getModifyMadeby(pno, modMadeby);
		}
	}
	private void detail() {
		//select * from product where pno = ?;
		System.out.println("검색할 상품번호를 입력해주세요. ");
		int pno = sc.nextInt();
		ProductVO p = svc.getDetail(pno);
		System.out.println(p);
	}
	private void list() {
		//상품 리스트 출력 select * from product;
		List<ProductVO> list = svc.getList();
		for(ProductVO p : list) {
			System.out.println(p);
		}
	}
	private void register() {
		System.out.println("상품이름을 입력해주세요. ");
		sc.nextLine();
		String pname = sc.nextLine();
		System.out.println("상품가격을 입력해주세요. ");
		int prcie = sc.nextInt();
		System.out.println("상품상세설정을 입력해주세요. ");
		sc.nextLine();
		String madeby = sc.nextLine();
		ProductVO p = new ProductVO(pname, prcie, madeby);
		// service에게 등록을 요청하는 메서드 작성
		int isOk = svc.register(p);
		System.out.println("상품등록"+ ((isOk > 0)? "성공" : "실패"));
	}
}
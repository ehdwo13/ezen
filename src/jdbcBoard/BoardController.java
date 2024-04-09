package jdbcBoard;

import java.util.List;
import java.util.Scanner;


public class BoardController {
	
	private Scanner sc;
	private Service svc;
	private boolean flag;
	public BoardController() {
		sc = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}
	private void printMenu() {
		while(flag) {
			System.out.println("--게시판--");
			System.out.println(" 1. 게시글추가 | 2. 게시글검색 | 3. 게시글수정");
			System.out.println(" 4. 게시글삭제 | 5. 게시글출력 | 6. 종료 ");
			int menu = sc.nextInt();
			switch(menu) {
			case 1 : register(); break;
			case 2 : search(); break;
			case 3 : modify(); break;
			case 4 : remove(); break;
			case 5 : print(); break;
			default : flag = false; break;
			}
		}
	}
	private void register() {
		System.out.println("제목입력");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("작성자입력");
		String writer = sc.next();
		System.out.println("내용입력");
		sc.nextLine();
		String content = sc.nextLine();
		BoardVO b = new BoardVO(title,writer,content);
		int result = svc.register(b);
		System.out.println(result);
	}
	private void search() {
		System.out.println("찾을 게시물 번호를 입력하세요. ");
		int bno = sc.nextInt();
		BoardVO b = svc.search(bno);
		System.out.println(b);
	}
	private void modify() {
		System.out.println("수정할 게시물 번호를 입력하세요. ");
		int bno = sc.nextInt();
		System.out.println("수정할 제목을 입력하세요. ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("수정할 작성자을 입력하세요. ");
		String writer = sc.next();
		System.out.println("수정할 내용을 입력하세요. ");
		sc.nextLine();
		String content = sc.nextLine();
		String moddate = "";
		BoardVO b = new BoardVO(bno, title, writer, content, moddate);
		int result = svc.modify(b);
		System.out.println(result);
	}
	private void remove() {
		System.out.println("삭제할 게시물 번호를 입력하세요. ");
		int bno = sc.nextInt();
		int result = svc.remove(bno);
		System.out.println(result);
	}
	private void print() {
		List<BoardVO> list = svc.getList();
		for(BoardVO b : list) {
			System.out.println(b.getBno()+"번게시물 /"+
								" 제목 : "+b.getTitle()+
								" / 작성자 : "+b.getWriter()+
								" / 내용 : "+b.getContent()+
								((b.getModdate().equals(b.getRegdate()))? " / 작성시간 : "+b.getModdate() : " / 수정시간 : "+b.getModdate()));
		}
	}
}
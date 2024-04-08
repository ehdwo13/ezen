package BoardT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Board.Board;
import Board.BoardInterface;

public class BoardManagerT implements BoardInterface{
	
	List<BoardT> list = new ArrayList<BoardT>();
	
	@Override
	public void addBoard(Scanner sc) {
		System.out.println("게시글 등록");
		System.out.println("title");
		sc.nextLine();	//메뉴에서 입력된 Enter 처리
		String title = sc.nextLine();	//공백포함
		System.out.println("writer");
		String writer = sc.next();
		System.out.println("content");
		sc.nextLine();
		String content = sc.nextLine();
		
		BoardT b = new BoardT(title, content, writer);
		list.add(b);
	}
	@Override
	public void searchBoard(Scanner sc) {
		System.out.println("조회할 번호 입력");
		int num = sc.nextInt();
		int index = list.indexOf(new BoardT(num));
		//indexOf : 해당 객체의 번지를 리턴 없으면 -1 리턴
		if(index != -1) {
			//해당 게시글이 있다면..
			BoardT tmp = list.get(index);
			tmp.print();
			return;
		}else {
			System.out.println("일치하는 게시글이 없습니다. ");
		}
	}

	@Override
	public void modifyBoard(Scanner sc) {
		System.out.println("수정할 번호 입력");
		int num = sc.nextInt();
		int index = list.indexOf(new BoardT(num));
		if(index != -1) {
			//수정작업
			System.out.println("제목 : ");
			sc.nextLine();
			String title = sc.nextLine();
			System.out.println("내용 : ");
			String content = sc.next();
			
			BoardT tmp = list.get(index);
			tmp.setTitle(title);
			tmp.setContent(content);
			tmp.print();
			System.out.println("수정완료");
			return;
		}else {
			System.out.println("일치하는 게시글이 없습니다. ");
		}
	}

	@Override
	public void removeBoard(Scanner sc) {
		System.out.println("삭제할 번호 입력");
		int num = sc.nextInt();
		int index = list.indexOf(new BoardT(num));
		if(index != -1) {
			list.remove(index);
			System.out.println("게시글 삭제 완료");
		}else {
			System.out.println("일치하는 게시글이 없습니다. ");
		}
	}

	@Override
	public void printBoard() {
		for(BoardT b : list) {
			System.out.println(b);
		}
	}

	@Override
	public void printMenu(Scanner sc) {
		System.out.println("--게시판--");
		System.out.println("1. 등록 | 2. 조회 | 3. 수정");
		System.out.println("4. 삭제 | 5. 목록 | 6. 종료");
		System.out.println("메뉴입력");
	}
}
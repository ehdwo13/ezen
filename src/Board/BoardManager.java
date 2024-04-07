package Board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoardManager implements BoardInterface{
	
	private ArrayList<Board> boardList = new ArrayList<>();
	public void addBoard(Scanner sc) {
		System.out.println("제목을 입력해주세요. ");
		String title = sc.next();
		System.out.println("내용을 입력해주세요. ");
		String content = sc.next();
		System.out.println("작성자를 입력해주세요. ");
		String writer = sc.next();
		boardList.add(new Board(boardList.size()+1, title, content, writer, date()));
		System.out.println("작성완료");
	}
	public void searchBoard(Scanner sc) {
		System.out.println("찾을 게시글 번호를 입력해주세요. ");
		int searchVal = sc.nextInt();
		for(Board tmp : boardList) {
			if(tmp.getIndex() == searchVal) {
				System.out.println(tmp);
			}
		}
	}
	public void modifyBoard(Scanner sc) {
		System.out.println("수정할 게시글 번호를 입력해주세요. ");
		int modVal = sc.nextInt();
		int modValIdx = modVal-1;
		for(Board tmp : boardList) {
			if(tmp.getIndex() == modVal) {
				System.out.println("수정할 내용을 골라주세요. ");
				System.out.println("1. 제목 | 2. 내용 | 3. 작성자");
				int menu = sc.nextInt();
				if(menu == 1) {
					System.out.println("수정할 제목을 입력해주세요. ");
					String modTitle = sc.next();
					String content = boardList.get(modValIdx).getContent();
					String writer = boardList.get(modValIdx).getWriter();
					boardList.remove(modValIdx);
					boardList.add(new Board(modVal, modTitle, content, writer, date()));
					sort();
					return;
				}else if(menu == 2) {
					System.out.println("수정할 내용을 입력해주세요. ");
					String title = boardList.get(modValIdx).getContent();
					String modContent = sc.next();
					String writer = boardList.get(modValIdx).getWriter();
					boardList.remove(modValIdx);
					boardList.add(new Board(modVal, title, modContent, writer, date()));
					sort();
					return;
				}else if(menu ==3) {
					System.out.println("수정할 작성자를 입력해주세요. ");
					String title = boardList.get(modValIdx).getContent();
					String content = boardList.get(modValIdx).getContent();
					String modWriter = sc.next();
					boardList.remove(modValIdx);
					boardList.add(new Board(modVal, title, content, modWriter, date()));
					sort();
					return;
				}else {
					System.out.println("잘못입력하셨습니다. ");
				}
			}
		}
	}
	public void removeBoard(Scanner sc) {
		System.out.println("삭제할 게시물 번호를 입력하세요. ");
		int rmIdx = sc.nextInt();
		int rmListIdx = rmIdx-1;
		boardList.remove(rmListIdx);
		for(Board tmp : boardList) {
			if(tmp.getIndex()>rmIdx) {
				tmp.setIndex(tmp.getIndex()-1);
			}
		}
	}
	public void printBoard() {
		for(Board tmp : boardList) {
			System.out.println(tmp);
		}
	}
	public void printMenu(Scanner sc) {
		int menu = -1;
		do {
			System.out.println("메뉴를 선택해주세요. ");
			System.out.println("1. 게시글추가 | 2. 게시글검색 | 3. 게시글수정 | 4. 게시글삭제 | 5. 게시글출력 | 6. 종료");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				addBoard(sc);
				break;
			case 2:
				searchBoard(sc);
				break;
			case 3:
				modifyBoard(sc);
				break;
			case 4:
				removeBoard(sc);
				break;
			case 5:
				printBoard();
				break;
			case 6:
				System.out.println("종료");
				break;

			default: System.out.println("잘못누르셨습니다. ");
				break;
			}
		}while(menu!=6);
	}
	public void sort() {
		Collections.sort(boardList, (o1,o2) -> o1.getIndex() - o2.getIndex() );
	}
	public String date() {
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		String date = formatedNow;
		return date;
	}
}
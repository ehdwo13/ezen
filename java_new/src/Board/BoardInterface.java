package Board;

import java.util.Scanner;

public interface BoardInterface {
	/* 1. 게시글추가 2. 게시글검색 3. 게시글수정 4. 게시글삭제 5. 게시글출력 6. 종료 */
	void addBoard(Scanner sc);
	void searchBoard(Scanner sc);
	void modifyBoard(Scanner sc);
	void removeBoard(Scanner sc);
	void printBoard();
	void printMenu(Scanner sc);
}
package Board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardManager bm = new BoardManager();
		bm.printMenu(sc);
		sc.close();
	}
}

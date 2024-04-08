package BoardT;

import java.util.Scanner;

public class BoardMainT {

	public static void main(String[] args) {
		
		BoardManagerT bm = new BoardManagerT();
		Scanner sc = new Scanner(System.in);
		
		int menu = -1;
		do {
			bm.printMenu(sc);
			menu = sc.nextInt();
			switch(menu) {
			case 1 : bm.addBoard(sc); break;
			case 2 : bm.searchBoard(sc); break;
			case 3 : bm.modifyBoard(sc); break;
			case 4 : bm.removeBoard(sc); break;
			case 5 : bm.printBoard(); break;
			case 6 : 
				System.out.println("종료");
				break;
			default : System.out.println("잘못된 메뉴입니다. ");
			}
		}while(menu !=6);
		sc.close();
	}

}

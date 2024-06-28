package word;

import java.util.Scanner;

public class WordMain2 {

	public static void main(String[] args){
		/*
		 * 단어장 프로그램 작성 Word 클래스 생성 단어, 의미
		 * 
		 * 메뉴 1. 단어등록, 2.단어검색, 3.단어수정, 4.단어출력, 5.파일로 내보내기 6. 종료
		 */
		Scanner sc = new Scanner(System.in);
		WordManager wm = new WordManager();
		int menu = 0;
		do {
			System.out.println("메뉴를 입력해주세요. ");
			System.out.println(" 1. 단어등록 | 2.단어검색 | 3.단어수정 | 4.단어출력 | 5.파일로 내보내기 | 6. 종료");
			menu = sc.nextInt();
			try {
				switch (menu) {
				case 1:	wm.insertWord(sc);
					break;
				case 2:	wm.searchWord(sc);
					break;
				case 3:	wm.modifyWord(sc);
					break;
				case 4:	wm.printWord();
					break;
				case 5: wm.filePrint();
					break;
				case 6 : System.out.println("종료. ");
					break;
				default:
					System.out.println("잘못 누르셨습니다. ");
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		} while (menu != 6);
		sc.close();
	}
}
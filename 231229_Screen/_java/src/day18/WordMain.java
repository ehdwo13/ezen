package day18;

import java.io.IOException;
import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) throws IOException  {
		/*	단어장 프로그램 작성
		 * 	1. 단어등록 | 2. 단어검색 | 3. 단어수정 | 4. 단어출력 | 5. 단어삭제 | 6. 종료
		 * 	WordManager 클래스를 생성하여 메서드 구현
		 * 	map을 이용하여 등록
		 * 	기본단어 등록 (5가지 등록)
		 * 	main에서는 메뉴가 반복 실행되도록 설정
		 * 	
		 * */
		Scanner sc = new Scanner(System.in);
		WordManager wm = new WordManager();
		int menu = -1;
		do {
			System.out.println("1. 단어등록 | 2. 단어검색 | 3. 단어수정 | 4. 단어출력 | 5. 단어삭제 | 6. 단어파일출력 | 7. 종료");
			menu = sc.nextInt();
			switch(menu) {
			case 1 : wm.wordAdd(sc.next(),sc.next()); break;
			case 2 : wm.wordSearch(sc.next()); break;
			case 3 : wm.wordFix(sc.next(),sc.next()); break;
			case 4 : wm.wordPrint(); break;
			case 5 : wm.wordDelete(sc.next()); break;
			case 6 : wm.wordTxt(); break;
			case 7 : break;
			default : System.out.println("잘못된 메뉴입니다. "); 
			}
		}while(menu!=7);
		System.out.println("종료합니다. ");
		sc.close();
	}
}
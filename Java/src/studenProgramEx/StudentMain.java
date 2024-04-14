package studenProgramEx;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManager sm = new StudentManager();
		int menu = 0;
		do {
			System.out.println("---menu---");
			System.out.println(" 1.학생등록 | 2.학생리스트출력 | 3.학생검색 | 4.수강신청 | 5.수강철회 | 6. 종료");
			menu=sc.nextInt();
					
			switch(menu){
			case 1 : sm.insertStudent(sc);	break;
			case 2 : sm.printStudent();	break;
			case 3 : sm.searchStudent(sc);	break;
			case 4 : sm.registerSubject(sc);	break;
			case 5 : sm.deleteSubject(sc);	break;
			case 6 : break;
			default : System.out.println("잘못된 메뉴입니다. ");
			}
		}while(menu!=6);
		System.out.println("종료");
		sc.close();
	}
}
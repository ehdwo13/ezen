package studentProgram;

import java.util.Scanner;

public class StudentMain{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		StudentManager sm = new StudentManager();
		
		do {
			System.out.println("1.학생등록 | 2.학생리스트출력 | 3.학생검색 | 4.수강신청 | 5.수강철회 | 6. 종료");
			System.out.println("번호를 선택해주세요. ");
			menu=sc.nextInt();
			switch(menu) {
			case 1 :
				System.out.println("1. 학생등록");
				sm.insertStudent(sc);
				break;
			case 2 :
				System.out.println("2. 학생리스트출력");
				sm.printStudent();
				break;
			case 3 : 
				System.out.println("3. 학생검색");
				sm.searchStudent(sc);
				break;
			case 4 : 
				System.out.println("4. 수강신청");
				sm.registerSubject(sc);
				break;
			case 5 :
				System.out.println("5. 수강철회");
				sm.deleteSubject(sc);
				break;
			case 6 :
				break;
			default :System.out.println("잘못된 메뉴");
			}
		}while(menu!=6);
		System.out.println("종료합니다. ");
		sc.close();
	}
}
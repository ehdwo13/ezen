package studentProgram;

import java.util.Scanner;

public class StudentManager implements Program{
	Student s = new Student();
	Student st[] = new Student[5];
	String name;
	int count;
	
	@Override
	public void insertStudent(Scanner sc) {
		if(count>4) {
			System.out.println("더 이상 추가할 수 없습니다. ");
		}else if(count<=4) {
			System.out.println("학번, 이름, 나이, 전화번호를 입력해주세요. ");
			Student s1 = new Student(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
			st[count]=s1;
			count++;
		}
	}	
	@Override
	public void printStudent() {
		for(int i=0; i<count; i++) {
			st[i].printStudentInfo();
			st[i].printSubject();
		}
	}
	@Override
	public void searchStudent(Scanner sc) {
		System.out.println("이름을 입력해주세요. ");
		name = sc.next();
		int check = -1;
		for(int i=0; i<count; i++) {
			if(name.equals(st[i].getStudentName())) {
				check = i;
			}
		}
		if(check==-1) {
			System.out.println("없는 학생입니다. ");
		}else {
			st[check].printStudentInfo();
		}
	}
	@Override
	public void registerSubject(Scanner sc) {
		searchStudent(sc);
		for(int i=0; i<count; i++) {
			if(st[i].getStudentName().equals(name)) {
				System.out.println("과목코드, 과목명을 입력하세요. ");
				Subject s1 = new Subject(sc.nextInt(),sc.next());
				st[i].addSubject(s1);
				System.out.println("등록완료.");
			}
		}
	}
	@Override
	public void deleteSubject(Scanner sc) {
		System.out.println("수강철회를 할 학생의 이름을 입력해주세요. ");
		name = sc.next();
		for(int i=0; i<count; i++) {
			if(st[i].getStudentName().equals(name)) {
				System.out.println(name+"이 수강중인 과목");
				st[i].printSubject();
				System.out.println("삭제할 과목");
				String delSub = sc.next();
				st[i].deleteSubject(delSub);
				System.out.println("삭제완료");
			}
		}
	}
}
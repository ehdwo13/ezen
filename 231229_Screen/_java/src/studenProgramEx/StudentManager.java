package studenProgramEx;

import java.util.Scanner;

public class StudentManager implements Program{
	private Student[] studentList = new Student[5];
	int stdCount;
	@Override
	public void printStudent() {
		System.out.println("전체 학생 정보");
		for(int i = 0; i<stdCount; i++) {
			studentList[i].stdPrint();
		}
	}
	@Override
	public void insertStudent(Scanner sc) {
		System.out.println("학번");
		String stdNum = sc.next();
		System.out.println("이름");
		String name = sc.next();
		System.out.println("전화번호");
		String phoneNum = sc.next();
		
		Student s = new Student(stdNum, name, phoneNum);
		if(stdCount == studentList.length) {
			Student[] tmp = new Student[studentList.length+5];
			System.arraycopy(studentList, 0, tmp, 0, stdCount);
			studentList = tmp;
		}
		studentList[stdCount]=s;
		stdCount++;
	}
	@Override
	public void searchStudent(Scanner sc) {
		System.out.println("검색할 학생이름");
		String searchName = sc.next();
		for(int i=0; i<stdCount; i++) {
			if(searchName.equals(studentList[i].getStdName())) {
				studentList[i].stdPrint();
				studentList[i].subPrint();
				return;
				}
		}
		System.out.println("검색한 이름이 없습니다.");
	}
	@Override
	public void registerSubject(Scanner sc) {
		System.out.println("수강신청 학생이름");
		String name = sc.next();
		int index = -1;
		for(int i=0; i<stdCount; i++) {
			if(name.equals(studentList[i].getStdName())) {
				index = i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("학생정보가 없습니다. ");
			return;
		}
		System.out.println("수강신청 과목");
		String sName = sc.next();
		Subject s = new Subject(sName);
		studentList[index].insertSubject(s);
	}

	@Override
	public void deleteSubject(Scanner sc) {
		System.out.println("수강삭제 학생이름");
		String name = sc.next();
		int index = -1;
		for(int i=0; i<stdCount; i++) {
			if(name.equals(studentList[i].getStdName())) {
				index = i;
				break;
			}
		}
		if(index==-1) {
			System.out.println("학생정보가 없습니다. ");
			return;
		}
		System.out.println("수강삭제 과목");
		String sName = sc.next();
		studentList[index].deleteSubject(sName);
	}
}
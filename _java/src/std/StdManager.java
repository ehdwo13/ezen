package std;

import java.util.ArrayList;
import java.util.Scanner;

public class StdManager implements StdProgram{
	//학생 리스트 생성 후 Program 메서드구현
	private ArrayList <Student> studentList = new ArrayList<>();
	
	public StdManager() {}
	
	@Override
	public void printStd() {
		
		for(int i=0; i<studentList.size(); i++) {	
			studentList.get(i).printStudentInfo();
			studentList.get(i).cal();
			System.out.println("총합은 : "+studentList.get(i).getSum());
			System.out.println("평균은 : "+studentList.get(i).getAvg());
		}
	}
	@Override
	public void addStd(Scanner sc) {
		Student tmp = new Student();
		System.out.println("이름을 입력해주세요. ");
		tmp.setName(sc.next());
		System.out.println("나이를 입력해주세요. ");
		tmp.setAge(sc.nextInt());
		System.out.println("전화번호를 입력해주세요. ");
		tmp.setPhoneNumber(sc.next());
		System.out.println("등록완료. ");
		studentList.add(tmp);
	}

	@Override
	public void modStd(Scanner sc) {
		System.out.println("수정할 학생이름을 검색해주세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				System.out.println("수정할 내용을 선택해주세요. ");
				System.out.println("1. 이름| 2. 나이| 3. 전화번호");
				int menu =sc.nextInt();
				switch(menu) {
				case 1: System.out.println("수정할 이름을 입력해주세요. "); 
						studentList.get(i).setName(sc.next());
						break;
				case 2: System.out.println("수정할 나이를 입력해주세요. "); 
						studentList.get(i).setAge(sc.nextInt());
						break;
				case 3: System.out.println("수정할 전화번호를 입력해주세요. "); 
						studentList.get(i).setPhoneNumber(sc.next());
						break;
				default : System.out.println("잘못누르셨습니다. ");
				}
				System.out.println("수정완료. ");
				return;
			}
		}
		System.out.println("존재하지 않습니다. ");
	}
	@Override
	public void delStd(Scanner sc) {
		System.out.println("삭제할 학생이름을 입력해주세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				studentList.remove(i);
				return;
			}
		}
		System.out.println("학생이 없습니다. ");
//		boolean result = studentList.remove(new Student(name));)
	}
	@Override
	public void searchStd(Scanner sc) {
		System.out.println("검색할 학생이름을 입력해주세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				studentList.get(i).printStudentInfo();
				return;
			}
		}
		System.out.println("검색된 학생이 없습니다. ");
	}
	@Override
	public void addSub(Scanner sc) {
		System.out.println("점수추가를 할 학생 이름을 입력하세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				System.out.println("과목명과 성적을 입력하세요. ");
				studentList.get(i).addMapData(sc.next(), sc.nextInt());
				return;
			}
		}
		System.out.println("학생이 없습니다. ");
	}
	@Override
	public void modSub(Scanner sc) {
		System.out.println("점수수정을 할 학생 이름을 입력하세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				System.out.println("수정 할 과목명과 수정할 점수를 입력하세요. ");
				studentList.get(i).modMapData(sc.next(), sc.nextInt());
				return;
			}
		}
		System.out.println("학생이 없습니다. ");
	}
	@Override
	public void delSub(Scanner sc) {
		System.out.println("점수삭제를 할 학생 이름을 입력하세요. ");
		String searchName = sc.next();
		for(int i=0; i<studentList.size(); i++) {
			if(searchName.equals(studentList.get(i).getName())) {
				System.out.println("삭제할 과목명을 입력하세요. ");
				studentList.get(i).delMapData(sc.next());
				return;
			}
		}
		System.out.println("학생이 없습니다. ");
	}
	public ArrayList<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
}
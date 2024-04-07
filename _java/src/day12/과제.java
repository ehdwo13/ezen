package day12;

public class 과제 {

	public static void main(String[] args) {
	Student n1 = new Student();
	n1.setName("홍길동");
	n1.setBirth("000223");
	n1.setPhoneNumber("010-1651-9841");
	n1.setAge(21);
	n1.add("빅데이터", "3개월");
	n1.setLocation("인천");
	
	Student n2 = new Student();
	n2.setName("가나다");
	n2.setBirth("030513");
	n2.setPhoneNumber("010-1111-1111");
	n2.setAge(25);
	n2.add("빅데이터", "3개월");
	n2.setLocation("인천");
	
	Student n3 = new Student();
	n3.setName("순이");
	n3.setBirth("010213");
	n3.setPhoneNumber("010-1361-1111");
	n3.setAge(22);
	n3.add("자바","6개월");
	n3.setLocation("서울");
	
	Student n4 = new Student();
	n4.setName("철이");
	n4.setBirth("990508");
	n4.setPhoneNumber("010-1951-1791");
	n4.setAge(27);
	n4.add("파이썬", "3개월");
	n4.setLocation("인천");
	
	Student n5 = new Student();
	n5.setName("명철");
	n5.setBirth("000728");
	n5.setPhoneNumber("010-4294-1187");
	n5.setAge(31);
	n5.add("자바","6개월");
	n5.setLocation("인천");
	
	Student n6 = new Student();
	n6.setName("규진");
	n6.setBirth("071213");
	n6.setPhoneNumber("010-8154-1761");
	n6.setAge(29);
	n6.add("파이썬", "3개월");
	n6.setLocation("서울");
	
	Student n7 = new Student();
	n7.setName("진영");
	n7.setBirth("970313");
	n7.setPhoneNumber("010-7481-6618");
	n7.setAge(32);
	n7.add("자바","6개월");
	n7.setLocation("서울");
	
	Student n8 = new Student();
	n8.setName("혜원");
	n8.setBirth("010219");
	n8.setPhoneNumber("010-4911-6734");
	n8.setAge(23);
	n8.add("빅데이터", "3개월");
	n8.setLocation("인천");
	
	
	Student[] std = new Student[] {n1,n2,n3,n4,n5,n6,n7,n8};
	//검색 학생의 학생정보, 학원정보, 수강정보를 출력
	String searchName = "혜원";
	System.out.println(searchName+"의 정보");
	for(int i = 0; i<std.length; i++) {
		if(searchName.equals(std[i].getName())) {
			std[i].basicInfo();
			std[i].academyInfo();
			std[i].eduInfo();
		}
	}
	System.out.println();
	//인천지점의 학생들을 모두 검색하여 학생정보만 출력
	String searchLocation = "인천";
	System.out.println(searchLocation+"의 학생정보");
	for(int i = 0; i<std.length; i++) {
		if(std[i].getLocation() != null) {
			if(searchLocation.equals(std[i].getLocation())){
				std[i].basicInfo();
				System.out.println();
			}
		}
		
	}
	System.out.println();
	//자바과목을 수강하는 학생들만 검색하여 학생정보/학원정보 출력
	String searchSubject = "자바";
	System.out.println(searchSubject+"를 듣는 학생정보");
	int count = 0;
	while(count < std.length) {
		for(int i=0; i<std[count].getCourse().length; i++) {
			if(std[count].getCourse()[i] != null) {
				if(searchSubject.equals(std[count].getCourse()[i])){
					std[count].basicInfo();
					std[count].academyInfo();
					std[count].eduInfo();
				}
			}
		}
		count++;
	}
	
	}
}
/*	- 학생 정보를 관리하기 위한 클래스
 * 	- 학생 기본정보 : 이름, 생년원일, 전화번호, 나이
 * 	- 학원 정보 : 학원명="EZEN"(final static), 지점
 * 	- 수강 정보 : 수강과목, 기간
 * 	  => 여러과목을 들을 수 있음(여러과목 수강하기 위해서는 배열로 처리 5과목까지 가능)
 * 	
 * 	ex) 홍길동 000101 010-2222-2222 25
 * 		EZEN(인천)
 * 		자바 6개월, 파이썬 1개월, 빅데이터 3개월
 * 
 *  기능 (메서드)
 *  - 학생기본정보를 출력하는 기능
 *  - 학원정보를 출력하는 기능
 *  - 수강정보를 출력하는 기능
 *  - 학생의 수강정보를 추가하는 기능
 * */
class Student{
	private String name;
	private String birth;
	private String phoneNumber;
	private int age;
	private final static String ACADEMY = "EZEN";
	private String location;
	private String subject;
	private String duration;
	private String course[] = new String[5];
	private String period[] = new String[5];
	int count ;	
	
	public void basicInfo() {
		System.out.println("이름 : "+name+"\n생년월일 : "+birth+"\n전화번호 : "+phoneNumber+"\n나이 : "+age);
	}
	public void academyInfo() {
		System.out.println(ACADEMY+"("+location+")");
	}
	public void add(String subject, String duration) {
		if(count==4) {	
			System.out.println("더이상 추가 할 수 없습니다. ");
			return;
		}
		course[count]=subject;
		period[count]=duration;	
		count++;	
	}
		
	public void eduInfo() {
	
		if(course.length == 0 || count ==0) {
			System.out.println("수강과목이 없습니다. ");
			return;
		}
		System.out.println(name+"님이 수강하고 있는 과목은 ");
		for(int i=0; i<count; i++) {
			System.out.println(course[i]+" "+period[i]);
		}
	}
	public Student() {}
	
	public Student(String name, String birth, String phoneNumber, int age, String location, String subject, String duration) {
		this.name = name;
		this.birth = birth;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.location = location;
		this.subject= subject;
		this.duration=duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String[] getCourse() {
		return course;
	}
	public void setCourse(String[] course) {
		this.course = course;
	}
	public String[] getPeriod() {
		return period;
	}
	public void setPeriod(String[] period) {
		this.period = period;
	}
	
}
package day12;

public class Class05 {
	
	/*	생성자 : 객체를 생성 시 값을 초기화 하는 방법
	 * 	- 기본값, 명시적 초기화, 초기화 블럭, 생성자
	 * 	1. 기본값 : 기본적으로 지정되는 값 int => 0 String => null
	 * 	2. 명시적 초기값 : 멤버변수를 선언함과 동시에 값을 지정하는 방법
	 * 		private String name = "홍길동";
	 * 	3. 초기화 블럭 : { } 멤버변수를 초기화
	 * 	4. 생성자 : 객체를 생성할 때 초기화 해서 생성
	 * 
	 * 	초기값의 우선순위
	 * 	기본값 -> 명시적초기값 -> 초기화블럭 -> 생성자(가장 우선순위가 높음)
	 * */
	public static void main(String[] args) {
		EzenStudent E = new EzenStudent("인천","길동", "빅데이터", "010-9876-5432", 27, "인천시");
		//toString() 메서드가 없으면 객체의 주소가 출력
		//toString() 메서드가 있으면 toString()가 출력
//		System.out.println(E.toString());	//위아래 같은의미
//		System.out.println(E);
		EzenStudent E1 = new EzenStudent("강남","영이", "빅데이터", "010-1234-5432", 23, "서울시");
		EzenStudent E2 = new EzenStudent("인천","훈이","자바","010-4851-4626", 28, "인천시");
		EzenStudent E3 = new EzenStudent("인천","규리","자바","010-7454-2123", 35, "경기도");
		EzenStudent E4 = new EzenStudent("강남","수지", "빅데이터", "010-1341-8932", 30, "서울시");
//		System.out.println(E);
//		System.out.println(E1);
//		System.out.println(E2);
//		System.out.println(E3);
//		System.out.println(E4);
		
		EzenStudent studentArr[] = new EzenStudent[] {E,E1,E2,E3,E4};
		for(EzenStudent tmp : studentArr) {
			System.out.println(tmp);
		}
		//영이 학생이 듣고 있는 과목을 출력
		String searchName = "영이";
		System.out.println(searchName+"학생이 듣고 있는 과목 => ");
		
		for(int i=0; i<studentArr.length; i++) {
			if(searchName.equals(studentArr[i].getName())){
				System.out.println(studentArr[i].getCourse());
			}
		}
		//영이가 자바를 들으려고 했는데 빅데이터로 변경 후 영이정보출력
		String modify = "훈이";
		for(int i=0; i<studentArr.length; i++) {
			if(modify.equals(studentArr[i].getName())){
				studentArr[i].setCourse("빅데이터");
				System.out.println(studentArr[i]);
				}
			}
		//자바를 듣고있는 학생명단을 출력	//없으면 명단에없습니다
		String subject = "자바";
		int count = 0;
		System.out.println(subject+"를 듣고 있는 학생 명단");
		for(int i=0; i<studentArr.length; i++) {
			if(subject.equals(studentArr[i].getCourse())){
				System.out.println(studentArr[i]);
				count++;
			}
		}
		if(count==0) {
			System.out.println("명단에 없습니다. ");
		}
	}
		

}
		

class EzenStudent{
	//학생 정보를 생성하는 클래스
	
	private String gigum="incheon";	//명시적 초기값
	private String name;		//기본값 null
	private String course;
	private String number;
	private int age;
	private String address;
	
	public EzenStudent() {}
	public EzenStudent(String gigum, String name, String course, String number, int age, String address){
		//super();// 내 부모 클래스의 생성자 호출
		this.gigum=gigum;
		this.name=name;
		this.course=course;
		this.number=number;
		this.age=age;
		this.address=address;
	}
	{
		//초기화 블럭 영역
		gigum = "인천";
		name = "미상";
		number = "000";
		course = "미정";
	}
	//toString 	: print 메서드와 비슷한 일을 함.
	@Override
	public String toString() {
		return gigum+"지점|"+ name + ", course : " + course + ", number : " + number + ", age : " + age + ", address : "
				+ address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
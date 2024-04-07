package studentProgram;

public class Student {
	private int studentId;				//학번
	private String studentName;			//이름
	private int age;					//나이
	private String phoneNumber;			//전화번호
	Subject[] subArr = new Subject[5];
	int count = 0;
	Subject s = new Subject();
	
	public Student() {}
	
	public Student(int studentId, String studentName, int age, String phoneNumber) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	public void addSubject(Subject s) {
		if(count>5) {
			System.out.println("더 이상 추가할 수 없습니다. ");
		}else {
				subArr[count]=s;
				count++;
		 	}
		}
	public void	printStudentInfo() {
		System.out.println("학번 : "+studentId+"번"+"  이름 : "+studentName+"(나이 : "+age+")"+"\n전화번호 : "+phoneNumber);
	}
	public void printSubject() {
		if(count == 0) {
			System.out.println("수강중인 과목이 없습니다.");
		}
		for(int i=0; i<count; i++) {
			System.out.println(subArr[i]);
		}
	}
	public void deleteSubject(String subjectName) {
		for(int i=0; i<count; i++) {
			if(subArr[i].getSubjectName().equals(subjectName)) {
				for(int j=i; j<count-1; j++) {
					subArr[j]=subArr[j+1];
				}
				subArr[count-1]=null;
				count--;		
			}
		}
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Subject[] getSubArr() {
		return subArr;
	}
	public void setSubArr(Subject[] subArr) {
		this.subArr = subArr;
	}
}
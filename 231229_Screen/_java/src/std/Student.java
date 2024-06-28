package std;

import java.util.HashMap;
import java.util.Objects;

public class Student {
	//멤버변수 : 이름, 나이, 전화번호, map(과목,점수), 합계, 평균
	//생성자,메서드, getter/setter, 출력메서드
	//메서드 - 출력메서드 (학생정보, 과목점수(성적표) 합계, 평균)
	//메서드 - map (과목,점수) 데이터를 추가
	//메서드 - map (과목,점수) 데이터를 삭제
	//멤버변수는 private 설정/ 메서드 public
	//클래스명은 대문자로 시작, 변수명,메서드명은 소문자로 시작
	//변수명,메서드명에 단어가 많아지면 다음 시작단어 대문자(카멜케이스)
	//indent : 들여쓰기 잘 맞추기
	private String name;
	private int age;
	private String phoneNumber;
	private HashMap<String, Integer> data = new HashMap<>();
	private int sum;
	private double avg;
	
	public Student() {}
	
	public Student(String name, int age, String phoneNumber) {
		this.name=name;
		this.age=age;
		this.phoneNumber=phoneNumber;
	}
	public void printStudentInfo() {
		System.out.println("이름 : "+name+"("+age+")"+"전화번호 : "+phoneNumber);
		for(String key : data.keySet()) {
			System.out.println("과목 : "+key+" "+data.get(key)+"점");
		}
	}
	public void cal() {
		sum = 0;
		avg = 0;
		if(data.size()==0) {
			return;
		}
	for(String key : data.keySet()) {
			sum+=data.get(key);
		}
		avg=(double)sum/data.size();
	}
	public void addMapData(String a, int b) {
		data.put(a, b);
		System.out.println("점수추가완료");
		
	}
	public void delMapData(String a) {
		if(data.get(a)==null) {
			System.out.println("찾는 값이 없습니다. ");
			return;
		}else if(data.get(a)!=null) {
			data.remove(a);
		}
		System.out.println("점수삭제완료");
	}
	public void modMapData(String a, int b) {
		if(data.get(a)!=null) {
			this.data.remove(a);
			this.data.put(a, b);
		}
		System.out.println("점수수정완료");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public HashMap<String, Integer> getData() {
		return data;
	}

	public void setData(HashMap<String, Integer> data) {
		this.data = data;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, avg, data, name, phoneNumber, sum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)		//주소가 내 객체의 주소와 같다면
			return true;
		if (obj == null)		
			return false;
		if (getClass() != obj.getClass())	//클래스 정보가 다르다면 false
			return false;
		Student other = (Student) obj;
		return	Objects.equals(name, other.name);	//이름만 같으면 true
	}
	
}
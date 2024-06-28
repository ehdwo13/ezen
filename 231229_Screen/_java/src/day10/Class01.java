package day10;

public class Class01 {
	
	//클래스의 구성요소 : 멤버변수, 메서드
	//멤버변수가 먼저, 메서드가 뒤에 선언
	
	/*	클래스 = 설계도
	 * 	객체 = 제품
	 * 	메서드 = 기능
	 * 	
	 * 	클래스의 구성요소 : 멤버변수, 메서드
	 * 	- 멤버변수 (속성, 정보)
	 * 	- 메서드 (기능)
	 * 
	 * 	프린터 클래스
	 * 	- 속성(멤버변수) :	크기, 색, 제조사, 제품명, 종류
	 *  - 기능(메서드) : 인쇄, 복사, 스캔, 팩스
	 *  
	 *  멤버변수는 클래스 안 가장위쪽에 작성	/ 메서드는 멤버변수 뒤에 선언
	 * 	멤버변수는 클래스 안에서 사용가능.	(모든 메서드에서 공통적으로 사용가능)
	 * 	
	 * 	-객체 선언
	 * 	클래스명 객체명; //선언만 하면 값은 null
	 * 	객체명 = new 클래스명();	//선언한 객체의 초기값 설정
	 * 
	 *  -객체 선언(초기화 생성)
	 *  클래스명 객체명 = new 클래스명();
	 *  
	 *  - 메서드 사용법(클래스가 다른 메서드를 호출할 경우)
	 *  객체 선언 후 객체명.메서드명();
	 *  
	 *  - 같은 클래스안에서 메서드를 호출할 경우 => 메서드명();
	 *  - 다른 클래스안에서 메서드를 호출할 경우 => 객체명.메서드명();
	 *  
	 *  접근 제한자(제어자)
	 *  public : 모두 사용가능
	 *  protected : 나 + 패키지 + 자식클래스
	 *  (default) : 나 + 패키지
	 *  private : 나만 사용가능
	 *  
	 *  private < default < protected < public
	 *  
	 *  - 클래스에서 public을 붙일 수 있는 건 파일명 = 클래스명 같을 경우에만 가능
	 *  - 하나의 java 파일안에 하나의 클래스만 있을 수 있는건 아님.
	 *  - 멤버변수와 멤버 메서드 public 문제없이 사용가능.
	 *  - 일반적으로 멤버변수는 private, 메서드는 public으로 선언한다.
	 *  - private : 다른클래스에서 사용(접근) 할 수 없다.
	 *  - private 로 선언된 멤버변수는 getter / setter 메서드를 만들어서 해당 변수에 접근할 수 있도록 한다.
	 * */
	
	public static void main(String[] args) {
		Point p = new Point();
		p.print();
		//멤버변수가 private 되어서 직접 접근이 불가능.
//		p.x = 1;
//		p.y = 2;
		p.setX(1);
		p.setY(2);
		p.print();
		p.save(10, 20);
		p.print();
		System.out.println(p.getX());
		System.out.println(p.getY());
		//x+y 값을 x값으로
		p.setX(p.getX()+p.getY());
		System.out.println(p.getX());
		
		p.setY(50);
		p.print();
		
		
		
		
		
	}
}
//	다른 클래스 생성시 클래스 밖에서 생성
//	(1,0)(x,y)의 좌표값을 출력하는 클래스
class Point {
	//멤버변수 위치
	//멤버변수는 초기값을 설정하지 않아도 자동으로 설정
	//int = 0 / String = null
	private int x;
	private int y;
	
	public void print()	{
		System.out.println("("+x+","+y+")");
	}
	
	//포인트 값을 저장하는 메서드
	public void save(int x, int y) {
		//this : 멤버변수를 지칭하는 키워드
		this.x = x;
		this.y = y;
	}
	
	//getter (데이터를 가져오는 메서드)
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	//setter (데이터를 변경하는 메서드)
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}

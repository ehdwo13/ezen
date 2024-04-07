package day17;

interface Power{
	void turnOn();
	void turnOff();
}
//class Tv implements Power{
//
//	@Override
//	public void turnOn() {
//		System.out.println("TV 전원을 켭니다. ");
//	}
//	@Override
//	public void turnOff() {
//		System.out.println("TV 전원을 끕니다. ");
//	}
//	
//}

public class 익명클래스 {

	public static void main(String[] args) {
		/*	익명클래스 : 이름이 없는 클래스
		 * 	인터페이스를 이용하여 객체를 만들 때 클래스 구현 없이 바로(매개변수로) 구현
		 * 	익명클래스를 사용하는 이유
		 * 	- 인터페이스의 기능이 적고, 해당 객체가 하나만 필요한 경우
		 * 	매서드의 매개변수로 주로 사용
		 * 	
		 * */
		
		//매개변수로 인터페이스를 구현한 객체가 필요한 경우
		//1. 인터페이스를 구현한 구현 클래스 생성
		//2. 구현 객체 생성
		//3. 매개변수
		익명클래스 ex = new 익명클래스();
//		Tv t = new Tv();
//		ex.product(t);
		
		//익명클래스로 작업하는 경우
		ex.product(new Power(){
			@Override
			public void turnOn() {
				System.out.println("전원을 켭니다. ");
			}
			@Override
			public void turnOff() {
				System.out.println("전원을 끕니다. ");
			}
		});
	}
	public void product(Power p) {
		p.turnOn();
		System.out.println("정상 작동중");
		p.turnOff();
	}
}
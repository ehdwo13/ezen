package new02;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글턴 객체 생성
//		Singleton s = new Singleton(); //생성 X
		Singleton s = Singleton.getInstance(); //static이기 떄문에 클래스에서 직접접근
		Singleton s1 = Singleton.getInstance();
		
		if(s == s1) {	//주소가 같은지 확인
			System.out.println("s==s1 같은 객체");
		}else {
			System.out.println("s!=s1 다른 객체");
		}
	}

}

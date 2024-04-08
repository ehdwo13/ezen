package new02;

class Counter{
	//싱클톤으로 객체 만들기
	private int count;
	private static Counter instance;
	private Counter() {}
	
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}
	// countMethod() 생성 // 호출시 count 1씩 증가 리턴
	public int countMethod() {
		return count++;
	}
}

public class SingletonCount {

	public static void main(String[] args) {
		// count 객체 2개 생성 각각 countMethod()를 호출하여 출력
		Counter c = Counter.getInstance();
		Counter c1 = Counter.getInstance();
		
		System.out.println(c.countMethod());
		System.out.println(c.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c1.countMethod());
		System.out.println(c.countMethod());
		System.out.println(c1.countMethod());
		
	}

}

package day11;

public class Method10 {

	public static void main(String[] args) {
		/*	재귀메서드 : 메서드 안에서 본인의 메서드를 호출하는 메서드
		 * 	! : 팩토리얼 
		 * 	1부터 자신의 수까지 곱해서 값을 리턴
		 * 	0! => 1
		 *  1! => 1
		 *  2! => 1*2
		 *  3! => 1*2*3
		 * */
		Method10 m10 = new Method10();
		System.out.println(m10.fact(5));
		System.out.println(m10.factorial(5));
		
	}
	public int fact(int num) {
		if(num<0) {
			return 0;
		}
		if(num==0 || num==1) {
			return 1;
		}
		int res = 1;
		for(int i=2; i<=num; i++) {
			res *= i;
		}
		return res;
	}
	
	//재귀 메서드 사용
	public int factorial(int num) {
		if(num<0) {
			return 0;
		}
		if(num==0 || num==1) {
			return 1;
		}
		return num * factorial(num-1);
	}
}

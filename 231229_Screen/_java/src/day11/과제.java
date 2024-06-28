package day11;

public class 과제 {

	public static void main(String[] args) {
		/*	메서드를 이용하여 작업.
		 * 	두 정수의 값이 주어졌을 때 두 정수사이의 모든 정수의 합을 리턴하는 메서드
		 * 	ex)a=3, b=5 => 3+4+5  12
		 * 	ex)a=5, b=1 => 1+2+3+4+5 15
		 * 	ex)a=3, b=3 => 3
		 * 
		 * */
		과제 s = new 과제();
		System.out.println(s.sum1(5,5));
		System.out.println(s.sum1(3,7));
		System.out.println(s.sum1(10,7));
		System.out.println(s.sum1(1,10));
		System.out.println(s.sum1(-3, 7));
	}
	//	1.들어가는 값(매개변수), 나오는 값(리턴타입)
	// 	매개변수 : int a,b 	/ 리턴타입 : int 합
	public int sum1(int num1, int num2) {
		
		return (Math.max(num1, num2)-Math.min(num1, num2)+1)*(num1+num2)/2;
	}
}
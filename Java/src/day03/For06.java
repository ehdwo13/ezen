package day03;

public class For06 {

	public static void main(String[] args) {
		/*	배수 : 값을 일정하게 곱해서 나오는 값.
		 * 	10, 15의 공배수 : 공통된 배수
		 * 	10 10 20 30 ....
		 * 	15 15 30 45 ....
		 * 	공배수 30 60 90 ....
		 * 	최소 공배수 : 30
		 * */
		//1부터 100까지의 공배수 출력
		int num1 =10, num2 =15;
		for(int i=num1; ; i+=num1) 
		if(i%num1 ==0 && i%num2 ==0) {
			System.out.print(i+" ");
			break;
		}
		System.out.println();
		int num3 =10, num4 =15;
		for(int i=num3; i<=100;i+=num3) {
			for(int j=num4; j<=100; j+=num4) {
				if(i==j) {
					System.out.println(i);
				}
			}
		}
	}
}
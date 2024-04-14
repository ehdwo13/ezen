package day03;

public class While02 {

	public static void main(String[] args) {
		/*	1~50까지의 짝수
		 * 	십의자리수 가 바뀌면 줄바꿈
		 * 	2 4 6 8 10
		 * 	12 14 16 18 20
		 * 	...
		 * 	42 44 46 48 50
		 * */
		int i = 0;
		while(i<50) {
			i++;
			if (i%2==0) {
				System.out.printf("%3d",i);
			}
			if (i%10==0) {
				System.out.println();
			}
		}
		System.out.println("출력구문");
		/*	system.out.println 줄바꿈이 있는 출력
		 *	system.out.print 줄바꿈이 없는 출력, 출력 값이 없으면 error
		 * 	system.out.printf 지시자를 이용한 출력
		 * 
		 *	지시자
		 *	%d(정수형), %f(실수형), %c(문자), %s(문자열) %n(줄바꿈)
		 *	소수점 설정 가능 공백 추가기능
		 * */
		System.out.printf("%.1f%n", 1.782344);
		
		int num1 = 5;
		int num2 = 3;
		// 5+3 = 8
		System.out.println(num1+"+"+num2+"="+(num1+num2));
		System.out.printf("%d+%d=%d%n" , num1,num2,(num1+num2));
		
		double num3 = 1.2;
		double num4 = 5;
		// 1.2 / 5 = 값
		System.out.printf("%.1f/%.1f=%.1f%n" , num3,num4,(num3/num4));
		
	}	
}
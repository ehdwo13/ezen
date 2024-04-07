package day03;

public class For02 {

	public static void main(String[] args) {
		/*
		 * 1~10까지 출력
		 */
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		/*
		 * 1~10까지 짝수만 출력
		 */
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		for (int i = 1; i <= 5; i++) {
			System.out.print(2 * i + " ");
		}
		System.out.println();
		/*
		 * 1~10까지 합계
		 * 
		 */
		int sum = 0; // 지역변수는 반드시 초기화 해야함. 초기화 기본값 숫자는 0 / 문자는 null
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println(sum);
		/*
		 * 1~10까지의 짝수합과, 홀수합을 출력
		 */
		System.out.println();
		int sum1 = 0, sum2 = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum1 += i;
			} else {
				sum2 += i;
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println();

	}

}

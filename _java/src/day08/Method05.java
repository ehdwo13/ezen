package day08;

import java.util.Scanner;

public class Method05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		System.out.println("소수 판별");
//		int num = sc.nextInt();
//		System.out.println(detect(num));
		
		// 2부터 100까지의 소수를 출력, 소수의 합계를 출력
		int sum = 0;
		for(int i=2; i<=100; i++) {
			if(detect(i)) {
				System.out.println(i);
				sum+=i;
				}
			}
		System.out.println("소수의 합계는 "+sum);
		
		
		sc.close();
		}
	/*	정수 하나가 주어지면, 이 정수가 소수인지 아닌지 판별(true/false)
	 * 	리턴 타입 : boolean
	 * 	매개 변수 : int num
	 *  매서드 명 : detect
	 * */
	public static Boolean detect(int num) {
		int count = 0;
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				count++;
				}
			}
		if(count==2) {
			return true;
		}else{
			return false;
		}
	}
}
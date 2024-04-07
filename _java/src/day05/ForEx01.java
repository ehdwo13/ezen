package day05;

import java.util.Scanner;

public class ForEx01 {

	public static void main(String[] args) {
		/*	소수 : 약수가 1과 자기자신만의 수를 가지는 수를 소수라고 한다.
		 * 	소수 : 3,5,7,9,11,13,17,19...
		 * 	소수의 약수는 (1, 나자신)=> 약수의 개수가 2개다.
		 * 	숫자 하나를 입력받아서 해당 수가 소수인지 아닌지 판별
		 * 	num = 13
		 * 	소수입니다.
		 * 	num = 12
		 *  소수가 아닙니다.
		 * */
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		System.out.println("숫자를 입력하세요. ");
		int num = sc.nextInt();		
		for(int i=1; i<=num; i++) {
			if(num%i==0) {
				count++;
				}
			}
		if(count==2) {
		System.out.println(num+"은 소수입니다.");
		}else {
		System.out.println(num+"은 소수가 아닙니다.");
		}		
		sc.close();		
		//	2부터 100까지의 소수를 모두 출력
		int num1 = 0;
		for(num1=2; num1<=100; num1++) {
			int count1 = 0;
			for(int i=1; i<=num1; i++) {
				if(num1%i==0) {
					count1++;
					}
			}
			if(count1==2) {
				System.out.print(num1+" ");
			}
			
		}
	}
}
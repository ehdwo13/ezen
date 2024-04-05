package day06;

import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		/*	숫자를 입력받아서 받은 숫자를 거꾸로 출력.	각자리의 합계 출력
		 * 	ex) 11456 => 출력 65411 => 6+5+4+1+1 => 결과값 출력
		 * 	ex) 19874 => 출력 47891 => 4+7+8+9+1 => 결과값 출력
		 * */
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int [5];			
		int sum = 0;
		System.out.println("숫자를 입력해주세요. ");
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			}
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]+" ");
			}
		System.out.println("합계는"+sum);
		sc.close();
		
//		System.out.println("숫자 입력");		//그대로 뒤집어서 출력
//		int num = sc.nextInt();		
//		int reverse = 0;
//		int sum = 0;
//		while (num != 0) { 
//			int left = num % 10;	
//			reverse = reverse * 10 + left; 
//			num/=10;				
//			sum+=left;
//		}
//		System.out.println("역수는 " +reverse);
//		System.out.println("합계는 " +sum);
		
		
//		System.out.println("숫자 입력");		//선생님 풀이
//		int num = sc.nextInt();
//		int sum = 0;
//		while(num>0) {
//			int b = num % 10;	//마지막 자리추출
//			System.out.println(b+" ");
//			sum += b;
//			num = num /10;		//정수 나누기 정수는 정수형
//		}
//		System.out.println("합계는 "+sum);
		sc.close();
		
//		System.out.println("숫자 입력");		//한글자씩 따로 출력
//		int num = sc.nextInt();
//		do{
//			System.out.println(num % 10);	
//			num /= 10; 
//			}while (num > 0);
	}
}
package Pratice;

import java.util.Scanner;

public class 거꾸로 {

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
		}
}
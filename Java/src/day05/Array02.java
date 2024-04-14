package day05;

import java.util.Scanner;

public class Array02 {

	public static void main(String[] args) {
		/*	5명의 점수를 입력할 수 있는 배열을 생성
		 * 	5명의 점수를 입력받아서 배열에 저장
		 * 	점수를 출력 => 점수의 합계
		 * */
		Scanner sc = new Scanner(System.in);
		
		int arr[] = new int[10];
		int sum = 0;
		double avg = 0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("점수를 입력해주세요. ");
			arr[i]=sc.nextInt();
			sum += arr[i];
			}
		avg = sum/(double)arr.length;
		System.out.println("합계는 " +sum+ " 입니다. ");
		System.out.println("평균은 " +avg+ " 입니다. ");
		sc.close();
	}
}
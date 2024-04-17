package Pratice;

import java.util.Scanner;

public class 점수계산기{

	public static void main(String[] args) {
		/*	각각의 점수를 입력받아
		 *	국어, 영어, 수학의 점수 합계와 평균을 출력 
		 * 	평균은 소수점을 살려서 출력
		 * 	합계가 얼마 평균이 얼마
		 * 	조건선택연산자를 이용하여 평균이 80이상이면 합격, 아니면 불합격으로
		 * */
		Scanner sc = new Scanner(System.in);			//스캐너임포트 
		System.out.println("국어 점수를 입력해주세요. ");
		int kor = sc.nextInt();							//정수값 입력 nextInt()
		System.out.println("영어 점수를 입력해주세요. ");
		int eng = sc.nextInt();
		System.out.println("수학 점수를 입력해주세요. ");
		int math = sc.nextInt();
		
	   	int sum = kor+eng+math;					
		double avg = sum/3.0;							//소수점을 표현하기 위해 값 중 하나를 실수표현
		System.out.println("합계 = "+sum);
		System.out.println("평균 = "+avg);
		System.out.println((avg>=80)? "합격입니다." : "불합격입니다.");	//3항 연산자 조건식이 true 면 A : B는 false
		sc.close();
		}
}
package day02;

import java.util.Scanner;

public class IF02 {

	public static void main(String[] args) {
		/*	국어, 영어, 수학 점수를 입력받아
		 *  합계, 평균, 평가를 출력
		 * 	평가는
		 * 	평균이 90이상이면 A
		 * 	평균이 80이상이면 B
		 *  평균이 70이상이면 C
		 *  나머지는 D
		 *  입력값이 0보다 작거나 100보다 크면 잘못된 값
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("정수입력(0~100) : 국어, 영어, 수학 순으로 입력 > ");
		int kor = scan.nextInt();
		int eng = scan.nextInt();
		int math = scan.nextInt();
		
		if(kor < 0 || kor > 100) {				// 	||연산자 둘중 하나만 true여도 true 리턴
			System.out.println("국어점수의 범위가 벗어났습니다.");
		}
		if(eng < 0 || eng > 100) {
			System.out.println("영어점수의 범위가 벗어났습니다.");
		}
		if(math < 0 || math > 100) {
			System.out.println("수학점수의 범위가 벗어났습니다.");
		}
		
		int sum = kor + eng + math;
		double avg = sum/3.0;
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
		
		char result = 'D';	//char = '' char는 문자하나라 작은따옴표
		if(avg > 100 || avg < 0) {
			System.out.println("잘못된 성적입니다.");
		}else if(avg >=90) {
			result = 'A';
		}else if(avg >=80) {
			result = 'B';
		}else if(avg >=70) {
			result = 'C';
		}else {
			result = 'D';
		}
		System.out.println("결과 : "+result);
		scan.close();
		}
}
package day01;

public class 과제 {

	public static void main(String[] args) {
		/*	국어, 영어, 수학의 점수 합계와 평균을 출력 
		 * 	평균은 소수점을 살려서 출력
		 * 	합계가 얼마 평균이 얼마
		 * 	조건선택연산자를 이용하여 평균이 80이상이면 합격, 아니면 불합격으로
		 * */
		int kor = 80, eng = 75, math = 90;
	    double sum = kor+eng+math;
		double avg = sum/3;
		System.out.println("합계 = "+sum);
		System.out.println("평균 = "+avg);
		System.out.println((avg>=80)? "합격입니다." : "불합격입니다.");
		}
}
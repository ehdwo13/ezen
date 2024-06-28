package day17;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {

	public static void main(String[] args) {
		/*	과목과 점수를 입력 받아 (Scanner) map 에저장 후 출력
		 * 	합계, 평균 출력
		 * 	종료 키워드가 나올 때까지 반복 (1=계속 /0= 종료)
		 * 	과목과 점수를 입력해주세요 >
		 * 	국어 89
		 * 	수학 78
		 * 	0 종료
		 * 	map으로 저장 후 출력
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> score = new HashMap<>();
		int close = -1;
		int sum = 0;
		double avg = 0;
		do{
			System.out.println("과목과 점수를 입력해 주세요. ");
			score.put(sc.next(), sc.nextInt());
			System.out.println("계속 입력 하시려면 1 종료 하시려면 0을 입력해주세요. ");
			close = sc.nextInt();
		}while(close!=0);
		for(String key : score.keySet()) {
			sum+=score.get(key);
		}
		avg = (double)sum/score.size();
		System.out.println("합계는 : "+sum+" 평균은 : "+avg+"입니다. ");
		
		sc.close();
	}
}
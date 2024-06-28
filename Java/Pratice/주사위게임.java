package Pratice;

import java.util.Scanner;

public class 주사위게임 {

	public static void main(String[] args) {
		/*	주사위 게임
		 * 	주사위를 던져서 총 30칸을 이동
		 * 	주사위는 랜덤으로 생성(1~6까지 생성)
		 * 	주사위 : 3
		 * 	3칸 전진 =>27칸 남았습니다.
		 * 	주사위 : 1
		 * 	1칸 전진 =>26칸 남았습니다.
		 * 	주사위 : 6
		 * 	6칸 전진 =>20칸 남았습니다.
		 * 	도착 총 이동횟수: 10회 => 주사위를 던진 횟수
		 * */
		Scanner sc = new Scanner(System.in);
		
		int random=0;
		int count = 0;						
		int sum = 0;
		int left = 0;
		do {
			System.out.println("주사위를 굴려주세요.");
			sc.nextLine();									//엔터 입력시 굴림
			random = ((int)(Math.random()*6)+1);
			sum+= random;
			count++;
			left = 30-sum;
			if (left<0) {
			}else {
				System.out.println(left+"칸 남았습니다. ");
			}
		}while(sum<30);
		System.out.println("총"+count+"회 던지셨습니다. ");	
		sc.close();
	}
}
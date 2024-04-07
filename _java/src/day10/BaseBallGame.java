package day10;

import java.util.Scanner;

import day08.Method07;

public class BaseBallGame {

	public static void main(String[] args) {
		/*	야구게임을 메서드화
		 * 	사용자번호는 직접입력
		 * 	번호는 랜덤 생성(1~9, 중복 x)
		 * 	중복안되게 하는메서드 isContain 호출해서 사용
		 * 
		 * */
		Scanner sc = new Scanner(System.in);
		
		int comNum[] = new int[3];
		int myNum[] = new int[3];
		int strike=0, ball=0;
		random(comNum);	
		Method07.printArray(comNum);
		while(strike !=3) {								
			System.out.println("1~9 숫자 중 3개를 골라주세요. ");
			int cnt = 0;
			while(cnt<3) {
				myNum[cnt] = sc.nextInt();
				cnt++;
			}
			strike = strikeCount(comNum, myNum);
			ball = ballCount(comNum, myNum);
			
			if(strike!=0) {
				System.out.println(strike+"strike");
			}
			if(ball!=0) {
				System.out.println(ball+"ball");
			}
			if(strike ==0 && ball ==0) {
				System.out.println("out");
			}
		}
		System.out.println("정답");
		sc.close();
	}
	//랜덤으로 배열을 중복되지 않게 생성
	//Method07의 isContain 가져와서 사용
	public static void random(int arr[]) {
		int count = 0;	
		while(count < arr.length) {
			int random = (int)(Math.random()*9)+1;
			if(!Method07.isContain(arr, random)) {
				arr[count]=random;
				count++;
			}
		}
	}
	//	랜덤 범위에 상관없이 랜덤수를 중복없이 채우는 메서드
	//	범위를 매개변수로 받아오면 됨.
	// 	start, count 매개변수로 받아 범위를 생성
	public static void createRandomArray(int arr[],int start, int count) {
		int cnt = 0;	
		while(count < arr.length) {
			int random = (int)(Math.random()*count)+start;
			if(!Method07.isContain(arr, random)) {
				arr[cnt]=random;
				cnt++;
			}
		}
	}
	//스트라이크 개수를 카운트하는 메서드
	// comNum, myNum를 주고 번호와 위치가 일치하면 count 하는 메서드
	// 리턴 타입 : int count를 리턴
	public static int strikeCount(int comNum[], int myNum[]) {
		int count = 0;
		for(int i = 0; i<comNum.length; i++) {
			for(int j=0; j<comNum.length; j++) {
				if(comNum[i]==myNum[i] && i==j) {			
					count++;						
				}
			}
		}
		return count;
	}
	//볼 개수를 카운트하는 메서드
	// comNum, myNum를 주고 번호만 일치하면 count 하는 메서드
	// 리턴 타입 : int count를 리턴
	public static int ballCount(int comNum[], int myNum[]) {
		int count = 0;
		for(int i = 0; i<comNum.length; i++) {
			if(Method07.isContain(myNum, comNum[i])){
					count++;	//ball + strike 같이 체크
				}
			}
		return count - strikeCount(comNum, myNum);
		}
}
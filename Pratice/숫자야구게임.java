package Pratice;

import java.util.Scanner;

public class 숫자야구게임 {

	public static void main(String[] args) {
		/*	야구게임
		 * 	컴퓨터가 3자리의 숫자를 생성 (각 자리수는 1~9까지의 수) => 배열로 랜덤 저장(중복 X)
		 * 	유저는 3자리의 숫자를 맞추는 게임 => 직접 입력(중복되지 않게)
		 * 	자리와 숫자가 일치하면 strike
		 * 	숫자만 맞으면 ball
		 * 	숫자가 하나도 안맞으면 out
		 *	ex)컴퓨터 생성 번호 1 2 3
		 *	   사용자 번호 1 7 8 => 1strike
		 *	   사용자 번호 1 3 2 => 1strike 2ball
		 *	   사용자 번호 7 8 9 => out
		 *     사용자 번호 1 2 3 => 3strike 정답.
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("야구 게임");
		int com[]= new int[3];
		for(int i =0; i<com.length; i++) {				//랜덤수 3개를 com 배열에 저장
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0; j<i; j++) {
				if(com[j] ==com[i]) {					//중복되면 com의 배열칸 한칸지우고 다시
					i--;
					break;
				}
			}
		}
		for(int temp : com) {							//테스트용 컴퓨터값 확인
				System.out.print(temp+" ");
			}
		System.out.println();
		int strike = 0;
		int ball = 0;
		int my[] = new int[3];
		while(true) {
			System.out.println("1에서 9 사이의 숫자 중 3개를 골라주세요. ");
			for(int i=0; i<my.length; i++) {			//맞출때 까지 while문 반복
				my[i]=sc.nextInt();
			}
			for(int i = 0; i<my.length; i++) {
				for(int j=0; j<my.length; j++) {
					if(com[i]==my[i] && i==j) {			//com과 my 의 숫자도 같고 
						strike++;						//com의 i번째칸과 my입력의 i번째 칸도 같으면	 strike++
					}else if(com[i]==my[j] && i!=j) {	//숫자는 같은데 같은칸이 아닐경우 ball++
						ball++;
					}
				}
			}
			if(strike==3) {
				System.out.println("3strike 정답");
				break;
			}else if(strike==0 && ball==0){				//strike도 ball도 없으면 out
				System.out.println("out");
			}else {
				System.out.println("strike "+strike+ " 회");
				System.out.println("ball "+ball+" 회");
			}
			strike = 0;			//초기화 안시켜주면 값이 while 돌면서 누적됨
			ball = 0;
		}
		sc.close();
	}
}
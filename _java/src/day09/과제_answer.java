package day09;

import java.util.Scanner;

public class 과제_answer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int comNum[]=new int[3];
		int myNum[]=new int[3];
		
//		//메서드는 다른 클래스에서도 불러올 수 있음.
//		//static으로 생성했기 때문에 클래스명.메서드명으로 호출가능.
//		Method07.randomArray(comNum); 	//comNum의 랜덤수 중복없이 생성
//		Method07.printArray(comNum);
//		
//		//static이 아닐경우 객체를 생성하여, 객체명으로 메서드명 호출
//		Method07 me = new Method07();
//		me.randomArray(myNum);
//		me.printArray(myNum);
		
		for(int i=0; i<comNum.length; i++) {
			comNum[i] = (int)(Math.random()*9+1);
			for(int j=0; j<i; j++) {
				if(comNum[i]==comNum[j]) {
					i--;
					break;
				}
			}
		}
//		for(int tmp : comNum) {
//			System.out.print(tmp+" ");
//		}
		while(true) {
			int stk = 0;
			int ball = 0;
			
			//사용자 숫자입력
			System.out.println("숫자입력");
			String mystr = sc.next();					//숫자를 문자로 받음
			String[] myNumStr = mystr.split("");		//한글자씩 나누어 배열에 저장
			for(int i=0; i<myNumStr.length; i++) {
				//문자를 숫자로 변환하여 myNum 저장
				myNum[i] = Integer.parseInt(myNumStr[i]);
			}
			
		//숫자비교
		for(int i=0; i<comNum.length; i++)	{
			for(int j=0; j<myNum.length; j++) {
				if(comNum[i] == myNum[j] && i==j) {
					stk++;
				}else if(comNum[i]==myNum[j] && i!=j) {
					ball++;
				}
			}
		}
		
		if(stk==0 && ball==0) {
			System.out.println("out");
		}else {
			System.out.println("> "+stk+"s "+ball+"b");
		}
		if(stk==3) {
			System.out.println("3stk 승리");
			break;
		}
		}
		sc.close();
	}
}
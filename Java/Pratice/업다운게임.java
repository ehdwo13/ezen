package Pratice;
import java.util.Scanner;
public class 업다운게임 {

	public static void main(String[] args) {
		/*	up/down 게임
		 * 
		 * 	1~50사이의 랜덤 수를 생성하여 맞추는게임
		 * 	컴퓨터가 랜덤수 생성 : 23
		 * 	입력> 10
		 * 	up입니다
		 * 	입력> 20
		 * 	up입니다
		 * 	입력> 30
		 * 	down입니다
		 * 	입력> 23
		 * 	정답입니다 종료
		 * */
		
		int random = ((int)(Math.random()*50)+1);		//1~50까지의 랜덤수 생성	
		Scanner sc = new Scanner(System.in);
		System.out.println("1~50 사이의 숫자를 입력해주세요.");
		int num = sc.nextInt();
		int count = 0;
			
		while(true) {								
			count++;
			if (count>5) {
				System.out.println("실패");
				break;
			}if(num==random) {
				System.out.println("정답입니다.");
				System.out.println(count+"회 만에 맞추셨습니다.");
				break;
			}else if(num<random) {
				System.out.println("up");
				System.out.println("다시 입력하세요. "+count+"회");
				num = sc.nextInt();
			}else if(num>random) {
				System.out.println("down");
				System.out.println("다시 입력하세요. "+count+"회");
				num = sc.nextInt();
			}
		}
		sc.close();		
	}
}				
package day03;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		/*	단을 입력받아서 입력받은 단을 출력 (구구단)
		 * 	2 => 2*1=2 2*2=4 2*3=6 ... 2*9=18
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("몇 단을 출력하시겠습니까? ");
		int i = sc.nextInt();
		for(int j=1; j<=9; j++) {
			int multi=i*j;
			System.out.println(i+"*"+j+"="+multi);
		}
		sc.close();
	}
}
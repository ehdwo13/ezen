package day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 과제 {

	public static void main(String[] args) {
		/*	숫자를 입력받아 입력받은 숫자를 list로 구성하고, 출력
		 * 	합계를 출력
		 * 	입력 : 45,78,89,97,68,57,48 => String
		 *  list에 넣고, 출력 => 합계(인원수) 출력
		 * 	70점 이상 점수 개수 출력
		 * */
//		String num = "45,78,89,97,68,57,48";
		Scanner sc = new Scanner(System.in);
		List<String> arr = new ArrayList<>();
		int sum = 0;
		int count = 0;
		String close = null;
		while(true) {
			System.out.println("값을 입력해주세요. ");
			arr.add(sc.next());
			System.out.println("계속 입력하시겠습니까? y | n");
			close = sc.next();
			if(close.equals("n")) {
				break;
			}
		}
		for(int i=0; i<arr.size(); i++) {
			sum += Integer.parseInt(arr.get(i));
			if(Integer.parseInt(arr.get(i))>=70) {
				count++;
			}
		}
		System.out.println(arr);
		System.out.println("인원수는 "+arr.size()+"명 입니다. ");
		System.out.println("합계는 " +sum);
		System.out.println("70점 이상인 사람은 "+count+"명 입니다. ");
		sc.close();
		}
}
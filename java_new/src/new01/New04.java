package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/*	단어장
		 * 	단어 : 의미
		 * 	map으로 생성
		 * 	단어의 갯수를 입력받아서 개수만큼 map에 추가
		 * 	콘솔에 찍기
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("몇개를 입력받으시겠습니까 ?");
		int count = sc.nextInt();
		HashMap<String, String> wordList = new HashMap<String, String>();
		for(int i=1; i<=count; i++) {
			System.out.println("단어를 입력해주세요. ");
			String word = sc.next();
			System.out.println("뜻을 입력해주세요. ");
			String mean = sc.next();
			wordList.put(word, mean);
		}
		for(String key : wordList.keySet()) {
			System.out.println(key+" : "+wordList.get(key));
		}
		sc.close();
	}

}

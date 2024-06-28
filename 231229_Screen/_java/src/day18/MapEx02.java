package day18;

import java.util.HashMap;
import java.util.Scanner;

public class MapEx02 {

	public static void main(String[] args) {
		/*	단어장
		 * 	단어 5개를 입력받아 콘솔에 출력하는 기능
		 * 	--단어장--
		 * 	hello : 안녕
		 * 	apple : 사과
		 * 	orange : 오렌지
		 * 	map에 저장 후 출력
		 * */
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> wordList = new HashMap<>();
		int count = 0;
		while(count<5) {
			System.out.println("단어를 입력해주세요. ");
			wordList.put(sc.next(),sc.next());
			count++;
			}
		for(String key : wordList.keySet()) {
			System.out.println(key+" : "+wordList.get(key));
		}
		sc.close();
	}
}

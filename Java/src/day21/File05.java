package day21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class File05 {

	public static void main(String[] args) throws IOException {
		// test.txt파일을 읽어들여 map에 저장하여
		// 명단, 합계, 평균을 출력
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		HashMap<String, Integer> scoreList = new HashMap<>();
		int sum =0;
		while(true) {
			String tmp = br.readLine();
			if(tmp == null) {
				break;
			}
			String name = tmp.substring(0, tmp.indexOf(" "));
			int score = Integer.parseInt(tmp.substring(tmp.indexOf(" ")+1));
			scoreList.put(name, score);
			sum += score;	
		}
		for(String key : scoreList.keySet()) {
			System.out.println(key+" : "+scoreList.get(key));
		}
		System.out.println("합계는 "+sum);
		System.out.println("평균은 "+(double)sum/scoreList.size());
		
		//br 끊기
		if(br!=null) {	//객체가 생성되었다면 끊기
			br.close();			
		}
	}
}
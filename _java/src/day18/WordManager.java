package day18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordManager {
	
	HashMap<String, String> wordList = new HashMap<>();
	public WordManager() {
		wordList.put("apple", "사과");
		wordList.put("banana", "바나나");
		wordList.put("carrot", "당근");
		wordList.put("dad", "아빠");
		wordList.put("eye", "눈");
	}
	public WordManager(HashMap<String, String> wordList) {
		super();
		this.wordList = wordList;
	}
	public void wordAdd(String a,String b) {
		wordList.put(a,b);
		System.out.println("단어 등록 완료");
	}
	public void wordSearch(String a) {
		
		for(String key : wordList.keySet()) {
			if(key.equals(a)||wordList.get(key).equals(a)) {
				System.out.println(key+" : "+wordList.get(key));
				return;
			}else {
				System.out.println("없는 단어입니다. ");
				break;
			}
		}
	}
	public void wordFix(String a,String b) {
		if(wordList.get(a)!=null) {
			wordList.remove(a);
			wordList.put(a, b);
		}
	}
	public void wordPrint() {
		int count = 1;
		for(String key : wordList.keySet()) {
			System.out.println(count+"번 "+key+" : "+wordList.get(key));
			count++;
		}
	}
	public void wordDelete(String a) {
		if(wordList.get(a)==null) {
			System.out.println("찾는 값이 없습니다. ");
			return;
		}else if(wordList.get(a)!=null) {
			wordList.remove(a);
		}
	}
	public void wordTxt() throws IOException {
//		FileWriter fw = new FileWriter("word.txt");
//		WordManager wm = new WordManager();
//		for(String key : wordList.keySet()) {
//			fw.write(key+" "+wordList.get(key)+"\r\n");
//		}
//		fw.close();
		FileWriter fs = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fs);
		
		StringBuffer sb = new StringBuffer();
		//sb.append : 기존 String에 데이터 추가
		String data = null;
		sb.append("---단어장---");
		sb.append("\r\n");
		
		for(String key : wordList.keySet()) {
			sb.append(key+":"+wordList.get(key));
			sb.append("\r\n");
		}
		data = sb.toString(); //StringBuffer 객체여서 String 객체로 변환
		bw.write(data);
		if(bw !=null) {
			bw.close();
		}
		if(fs !=null) {
			fs.close();
		}
	}
	public HashMap<String, String> getWordList() {
		return wordList;
	}
	public void setWordList(HashMap<String, String> wordList) {
		this.wordList = wordList;
	}
}
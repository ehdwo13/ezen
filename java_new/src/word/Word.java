package word;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Word {
	//Map 버전
	HashMap<String, String> wordList = new HashMap<String, String>();
	public Word() {}
	public Word(HashMap<String, String> wordList) {
		super();
		this.wordList = wordList;
	}
	public void addWord(Scanner sc) {
		System.out.println("단어를 입력해주세요. ");
		String word = sc.next();
		System.out.println("뜻을 입력해주세요. ");
		String mean = sc.next();
		wordList.put(word, mean);
		System.out.println("등록 완료");
	}
	public void searchWord(Scanner sc) {
		System.out.println("검색할 단어를 입력해주세요. ");
		String wordSearch = sc.next();
		Boolean check = false;
		for(String temp : wordList.keySet()) {
			if(temp.equals(wordSearch) || wordList.get(temp).equals(wordSearch)) {
				System.out.println(temp+" : "+wordList.get(temp));
				check = true;
			}	
		}
		if(check == false) {
			System.out.println("단어장에 없는 단어입니다. ");
		}
	}
	public void modifyWord(Scanner sc) {
		System.out.println("수정할 단어를 검색해주세요. ");
		printWord();
		Boolean check = false;
		String modifyWord = sc.next();
		for (String temp : wordList.keySet()) {
			if (temp.equals(modifyWord)) {
				System.out.println("1. 단어수정 | 2. 뜻수정");
				int pickMenu = sc.nextInt();
				if (pickMenu == 1) {
					System.out.println("수정할 단어를 입력해주세요. ");
					String modifyNewWord = sc.next();
					wordList.put(modifyNewWord, wordList.get(temp));
					check = true;
					System.out.println("수정완료. ");
					break;
				} else {
					System.out.println("수정할 뜻을 입력해주세요. ");
					String modifyNewMean = sc.next();
					wordList.put(temp, modifyNewMean);
					check = true;
					System.out.println("수정완료. ");
					break;
				}
			}
		}
		if(check == false) {
			System.out.println("없는 단어입니다. ");
		}
	}
	public void printWord() {
		for (String temp : wordList.keySet()) {
			System.out.println(temp + " : " + wordList.get(temp));
		}
	}
	public void makeFile() throws IOException {
		FileWriter fw = new FileWriter("wordList.txt");
		for (String key : wordList.keySet()) {
			String data = key + " : " + wordList.get(key) + "\r\n";
			fw.write(data);
		}
		System.out.println("저장 완료. ");
		fw.close();
	}
}
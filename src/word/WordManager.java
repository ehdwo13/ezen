package word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordManager {
	
	private ArrayList<Word2> list = new ArrayList<>();
	
	public void insertWord(Scanner sc) {
		System.out.println("단어를 입력해주세요. ");
		String word = sc.next();
		System.out.println("뜻을 입력해주세요. ");
		String mean = sc.next();
		list.add(new Word2(word,mean));
		System.out.println("등록 완료");
	}
	public void printWord() {
		for(Word2 tmp : list) {
			System.out.println(tmp);
		}
	}
	public void searchWord(Scanner sc) {
		System.out.println("검색할 단어를 입력해주세요. ");
		String s = sc.next();
		for(Word2 tmp : list) {
			if(tmp.getWord().equals(s)) {
				System.out.println("--검색결과--");
				System.out.println(tmp);
				return;
			}
		}
		System.out.println("검색결과가 없습니다. ");
	}
	public void modifyWord(Scanner sc) {
		System.out.println("수정할 단어를 입력해주세요. ");
		String s = sc.next();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getWord().equals(s)) {
				System.out.println("수정할 의미를 입력해주세요. ");
				String m = sc.next();
				Word2 w = new Word2(s,m);
				list.set(i, w);
				return;
			}
		}
		System.out.println("검색결과가 없습니다. ");
	}
	public void filePrint() throws IOException {
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();
		
		String data = "";
		int count = 0;
		while(count < list.size()) {
			sb.append(list.get(count).toString());
			sb.append("\r\n");
			count++;
		}
		data = sb.toString();
		fw.write(data);
		fw.close();
		bw.close();
	}
}

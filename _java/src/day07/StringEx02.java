package day07;

import java.util.Scanner;

public class StringEx02 {

	public static void main(String[] args) {
		/*	5개의 파일명이 주어졌을 때,
		 * 	검색어를 입력하면 해당 단어를 포함하는 파일을 출력
		 *	ex : java 검색 => 이것이자바다.java java의정석.java 출력
		 *	ex : String 검색 => String.jpg String 메서드.txt 출력
		 *	ex : txt 검색 => String 메서드.txt array.txt 출력
		 *	스트링 => 검색결과가 없습니다.
		 * */
		String[] fileName = {"이것이자바다.java","java의정석.java","String.jpg","String 메서드.txt","array.txt"};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 단어를 입력해주세요. ");
		String search = sc.next();
		int count = 0;
//		for(int i = 0; i<fileName.length; i++) {	//반복문 굳이 사용할 필요없음. 이미 배열 index에 저장됨.
//			if(fileName[i].contains(search))	{
//				System.out.println(fileName[i]);
//				count ++;
//				}
//			}
		for(String tmp : fileName) {		//향상된 for 문 출력만 하기때문에 사용
			if(tmp.contains(search)) {
				System.out.println(tmp);
				count++;
			}
		}
		System.out.println(count+"건의 검색결과");
		if(count==0) {
			System.out.println("검색결과가 없습니다.");
		}
		sc.close();
		}
}
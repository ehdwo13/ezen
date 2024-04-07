package day07;

public class StringEx01 {

	public static void main(String[] args) {
		/*	file에 저장되어있는 문자를 파일명과 확장자로 분리하여 출력
		 * 	파일명 : 이것이 자바다
		 * 	확장자 : java
		 * */
		String file = "이것이자바다.java";
		
		String arr[] = file.split("\\.");		// split 에서 . 인식못함 \\. 로 변경
		for(String s : arr) {
			System.out.println(s);
			}
		String name = file.substring(0, file.indexOf("."));
		String suffix = file.substring(file.indexOf(".")+1);	//+1번지로 .빼기
		
		System.out.println("파일명 : "+ name);
		System.out.println("확장자 : "+ suffix);
		
		if(file.contains("java")) {
			System.out.println("자바파일입니다. ");
		}else {
			System.out.println("아닙니다. ");
		}
	}
}
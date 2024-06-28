package day06;

public class Array05 {

	public static void main(String[] args) {
		/*	문자열을 받는 배열을 생성
		 * */
		
		String arr[] = new String[5];
		arr[0]="홍길동";
		arr[1]="김영이";
		arr[2]="박순이";
		arr[3]="최영철";
		arr[4]="박순철";
		
		for(int i=0; i<arr.length; i++) {	//일반for문
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//향상된 for문
		//탐색만 가능.
		System.out.println("향상된 for문");
		for(String s : arr) {	//i값은 for문안에서만 반복 밖에선 출력불가능
			System.out.println(s);
		}
	}
}
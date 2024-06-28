package day20;

import java.util.Arrays;

public class Stream02 {

	public static void main(String[] args) {
		/*	배열에서 짝수만 출력(정렬) 중복되는 값 제거
		 * */
	
		int[] arr = {1,8,4,5,7,8,9,6,5,4,1,5,6,2,5,2,8,2};
		Arrays.stream(arr)
		.distinct()
		.filter(n-> n%2==0)
		.sorted()
		.forEach(n->System.out.print(n+" "));;
		System.out.println();
		
		//배열로 리턴
		int[] result = Arrays.stream(arr)
		.filter(n-> n%2!=0)
		.distinct()
		.sorted()
		.toArray();
		for(int tmp : result) {
			System.out.print(tmp+" ");
		}
	}
}
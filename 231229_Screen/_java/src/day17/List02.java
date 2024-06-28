package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class List02 {

	public static void main(String[] args) {
		/*	두 배열을 입력받아서 하나로 합치는 ArrayList 생성
		 * 	정렬하여 출력
		 * */
		String arr1[] = new String[] {"a","c","f","b"};
		String arr2[] = new String[] {"d","g","h","k"};
		
		ArrayList<String> sArr = new ArrayList<String>();
//		for(int i=0; i<4; i++) {
//			sArr.add(arr1[i]);
//		}
//		for(int i=0; i<4; i++) {
//			sArr.add(arr2[i]);
//		}
//		Collections.sort(sArr);
//		System.out.println(sArr);
		
		int count = arr1.length+arr2.length;
		int i=0, j=0;
		
		while(count>sArr.size()) {
			if(i<arr1.length) {
				sArr.add(arr1[i]);
				i++;
			}
			if(j<arr2.length) {
				sArr.add(arr2[j]);
				j++;
			}
		}
		System.out.println(sArr);
		Collections.sort(sArr);
		System.out.println("오름차순 정렬 후");
		System.out.println(sArr);
		
		sArr.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		});
		System.out.println("내림차순 정렬 후");
		System.out.println(sArr);
		
		
	
	}
}

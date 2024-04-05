package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class List01 {

	public static void main(String[] args) {
		/*	하루 일과를 저장하는 list를 생성
		 * 	출력 for / 향상된 for / Iterator 출력
		 * 	import 단축키 ctrl + shift + o
		 * */
		
		List<String> schedule = new ArrayList<String>();
		schedule.add("아침");
		schedule.add("점심");
		schedule.add("저녁");
		schedule.add("새벽");
		
		for(int i=0; i<schedule.size(); i++) {
			System.out.print(schedule.get(i)+" ");
		}
		System.out.println();
		for(String tmp : schedule) {
			System.out.print(tmp+" ");
		}
		System.out.println();
		Iterator<String> it = schedule.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp+" ");
		}
		
		//정렬
		Collections.sort(schedule);
		System.out.println(schedule);
		
		schedule.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// 숫자는(크다/작다) -/+의 값이 출력
				// 문자는compareTo 메서드를 활용하여 정렬
				// return o1.compareTo(o2); 오름차순
				return o2.compareTo(o1);  //내림차순
			}
		});
		System.out.println(schedule);

	}

}

package day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Set01 {

	public static void main(String[] args) {
		/*	Set 순서보장X, 중복X
		 * 	순서가 없어서 index가 없다.
		 * 	HashSet(대표적인 Set 컬렉션 구현 클래스)
		 *  TreeSet(정렬이 되는 Set)
		 * */
		
		HashSet<String> set = new HashSet<String>();
		set.add("apple");
		set.add("banana");
		set.add("apple");
		set.add("peach");
		set.add("orange");
		set.add("apple");
		System.out.println(set);
		
		//index가 없어서 get(), set() 메서드가 없음.
		for(String tmp : set) {
			System.out.println(tmp);
		}
		System.out.println();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String tmp = it.next();
			System.out.print(tmp+" / ");
		}
		
		//set 정렬 : set은 순서가 없어서 정렬이 안됨.
		//set => list로 반환 후 정렬
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		System.out.println(list);
	}

}

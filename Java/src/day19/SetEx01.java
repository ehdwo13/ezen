package day19;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class SetEx01 {

	public static void main(String[] args) {
		/*	set 중복저장X
		 * 	set에 로또번호 6개 생성 후 출력
		 * */
		HashSet<Integer> lotto = new HashSet<Integer>();
		for(;;) {
			int random = (int)(Math.random()*45)+1;
			if(lotto.size()==6) {
				break;
			}
			lotto.add(random);
		}
		System.out.println(lotto);
		System.out.println("--------------------");
		
		//set 중에서 정렬이 되는 set TreeSet
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		while(treeSet.size()<6) {
			int random1 = new Random().nextInt(45)+1;
			treeSet.add(random1);
		}
		System.out.println(treeSet);
		
		//first last 최솟값 최대값
		System.out.println(treeSet.first());
		System.out.println(treeSet.last());
		
		//headSet : 지정한 값보다 작은 값
		//tailSet : 지정한 값보다 큰 값
		System.out.println(treeSet.headSet(15));
		System.out.println(treeSet.tailSet(15));
		
		//subSet : 검색 범위 지정 뒤쪽 값은 미포함
		System.out.println(treeSet.subSet(15, 30));	//15~30  / 15는 포함 30은 미포함
	}
}
package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class New03 {

	public static void main(String[] args) {
		/*	컬렉션 프레임워크
		 * 	- List : 순서를 보장, 중복 저장 가능
		 *  - Set : 순서보장 X, 중복X
		 *  - Map : 순서보장 X, 데이터를 쌍으로 저장
		 *  key(중복불가능), value(중복가능)
		 * */
		//리스트를 생성하고 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		for(Integer tmp : list) {
			System.out.print(tmp+" ");
		}
		//map을 이용하여 이름 : 점수 형태로 3명만 입력
		HashMap<String, Integer> Map = new HashMap<String, Integer>();
		Map.put("kim", 89);
		Map.put("lee", 78);
		Map.put("hong", 49);
		System.out.println(Map);
		for(String key: Map.keySet()) {
			System.out.println(key);
			System.out.println(Map.get(key));
		}
		Iterator<String> it = Map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + Map.get(key));
		}
		
	}

}

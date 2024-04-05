package day18;

import java.util.HashMap;

public class MapEx01 {

	public static void main(String[] args) {
		/*	map을 이용하여 상품과 가격을 추가하여 합계를 구하시오.
		 * 	상품을 map에 추가하는 작업은 메서드를 활용
		 * 	1. map을 main에 생성해놓고, 매개변수로 받아 map의 데이터를 채우는 메서드
		 * 	2. map을 메서드 내부에서 생성하여, main으로 리턴
		 * 
		 * 	가위 2500
		 * 	크레파스 4000
		 * 	물감 5000
		 * 	합계 ?
		 * 	
		 * */
		//첫번째 메서드
		HashMap<String, Integer> a = new HashMap<String, Integer>();
		MapEx01 m = new MapEx01();
		m.addProduct(a);
		m.printMap(a);

		//두번째 메서드
		HashMap<String,Integer> map = m.addProduct1();
		m.printMap(map);
		
	}
	//map을 매개변수로 받는 케이스
	public void addProduct(HashMap<String,Integer> s) {
		s.put("가위",2500);
		s.put("크레파스",4000);
		s.put("물감",5000);
	}
	//map을 내부에서 생성하여 리턴하는 케이스
	public HashMap<String, Integer> addProduct1() {
		HashMap<String, Integer> s = new HashMap<>();
		s.put("가위",3500);
		s.put("크레파스",5000);
		s.put("물감",6000);
		return s;
	}
	//map을 받아서 출력하는 메서드
	public void printMap(HashMap<String,Integer> s){
		System.out.println(s);
		int sum = 0;
		for(String key :s.keySet()) {
			sum+=s.get(key);
		}
		System.out.println("합계는 "+sum);
	}
}
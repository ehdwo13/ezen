package day20;

import java.util.HashMap;

public class Lambda02 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("철수",80);
		map.put("훈이",75);
		map.put("나미",85);
		map.put("영이",80);
		map.put("길동",90);
		
		
		map.forEach((x,y)->{
			System.out.println("이름 : "+x+"("+y+"점)");
		});
		
		Number sum = (a,b)->{ //함수구현
			return a+b;
		};
		int hap = sum.add(5, 3);
		System.out.println(hap);
		System.out.println(sum.add(5, 3));
		
		Number max = (a,b)-> (a>=b)? a:b;
		System.out.println(max.add(50, 90));
	}

}
//함수형 인터페이스 생성
//메서드가 1개여야만 함
@FunctionalInterface
interface Number{
	int add(int a,int b);
	//int max(int a,int b); //메서드가 2개면 에러
}
package day20;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda01 {

	public static void main(String[] args) {
		/* 	Lambda + Stream = 람다와 스트림
		 *	lambda : 람다식 (식을 단순하게 표현하는 방법)
		 * 	외부 자료의 부수적인 영향(side effect)를 주지 않도록 구현하는 방식
		 *  Stream : 자료의 대상과 관계없이 동일한 연산을 수행할 수 있도록 해주는 반복자
		 *  - 메서드 체이닝 기법을 사용
		 *  
		 * 	lambda functions : 람다함수 => 익명클래스를 사용하여 쓰는 함수
		 * 	람다의 장점 : 코드의 간결성, 병렬처리 가능, 불필요한 연산 최소화
		 * 	람다의 단점 : 가독성이 떨어짐, 반복문 사용시 성능 저하
		 * 	- 람다의 표현식
		 *  (매개변수) -> {구현};
		 *  매개변수가 1개면 () 생략가능
		 *  x -> {return X+1;}
		 *  x,y -> x+y; 	 //오류
		 *  
		 *  return이 없으면 {} 생략가능
		 *  x -> x+1;
		 *  x -> return x+1; //오류
		 *  (x,y) -> x+y;
		 *  (x,y) -> {return x+y;}
		 * */
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(33);
		list.add(7);
		list.add(19);
		list.add(28);
		list.add(37);
		list.add(3);
	
		for(Integer tmp : list) {
			System.out.print(tmp+" ");
		}
		System.out.println();
		System.out.println("----Lambda출력----");
		list.forEach(n->{
			System.out.print(n+" ");
		});
		System.out.println();
		System.out.println("----Consumer출력----");
		
		//람다함수(익명함수)
		Consumer<Integer> method = (n)->{
			System.out.print(n+" ");
		};
		list.forEach(method);
	}

}

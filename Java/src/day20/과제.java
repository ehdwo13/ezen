package day20;

import java.util.*;

public class 과제 {

	public static void main(String[] args) {
		/*	스트림으로 출력
		 * 	여행사 상품이 있습니다. 
		 * 	여행 비용은 15세 이상은 100만원, 미만은 50만원
		 * 	고객 3명이 패키지 여행을 떠난다고 했을 경우
		 * 	1. 비용계산 => 출력 2. 고객명단 검색 => 출력
		 * 	고객 클래스를 생성하고, ArrayList로 고객관리
		 * 	
		 * 	예시) 고객정보 -> 고객명단
		 * 	이름 : 이순신, 나이: 40, 비용 : 100
		 * 	이름 : 신사임당, 나이: 35, 비용 : 100
		 * 	이름 : 홍길동, 나이 : 10, 비용 : 50
		 * 	총 여행 경비 : 250
		 * 	
		 * 	20대 이상 고객명단 => 이름순으로 정렬
		 * 	이름 : 신사임당, 나이 : 35, 비용 : 100
		 * 	이름 : 이순신 , 나이 : 40, 비용 : 100
		 * 	
		 * */
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Customer> c = new ArrayList<>();
		for(int i=0; i<3; i++) {
			System.out.println("성함과 나이를 입력해주세요. ");
			Customer tmp = new Customer(sc.next(),sc.nextInt());
			c.add(tmp);
		}
		c.stream()
		.forEach(n->{
			System.out.println("이름 : "+n.getName()+" 나이 : "+n.getAge()+" 비용 : "+n.getMoney());
		});
		int sum = c.stream()
				.mapToInt(n->n.getMoney())
				.sum();
		System.out.println("총비용 : "+sum);
		
		System.out.println("20세 이상 고객명단");
		Collections.sort(c);	//클래스에 정렬 구현되어있으면 가능
		c.stream()
		.filter(n-> n.getAge()>=20)
		.forEach(n->System.out.println(n));
		sc.close();
		
		//익명클래스 사용할 경우 Comparator 대상 (매개변수) 2개
		//클래스 내부에서 구현할 경우 Comparable 대상(매개변수) 1개
	}
}
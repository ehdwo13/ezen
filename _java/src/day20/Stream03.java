package day20;

import java.util.ArrayList;

public class Stream03 {

	public static void main(String[] args) {
		//	Student 클래스로 리스트 구성
		// 	add로 5명 추가
		
		//스트림을 이용하여 콘솔에 출력 ex) 홍길동 : 98
		ArrayList<Student> s = new ArrayList<>();
		s.add(new Student("철수",80));
		s.add(new Student("유리",70));
		s.add(new Student("맹구",50));
		s.add(new Student("훈이",60));
		s.add(new Student("짱구",40));
		s.stream()
		.forEach(n->System.out.println(n));
		System.out.println();
		s.stream().forEach(n->{
			String name =  n.getName();
			int score = n.getScore();
			System.out.println(name+"("+score+")");
		});
		//점수합계 / 전체 인원수 출력
		int sum = s.stream().mapToInt(n->n.getScore()).sum();
		System.out.println(sum);
		System.out.println(s.stream().count()+"명"); 
	}
}
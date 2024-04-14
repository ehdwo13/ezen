package day11;

public class Ex {

	public static void main(String[] args) {
		CardPack cp = new CardPack();//52장의 카드생성
			int count = 0;
			cp.shuffle();
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<13; j++) {
					cp.getPack()[count].print();
					//cp.getPack() : CardPack 클래스안에 있는 pack[] 리턴
					//cp.getPack()[cnt] = pack [0] => Card (멤버변수, 메서드)
					count++;
				}
				System.out.println();
			}

			System.out.println();
			cp.pick().print();
			System.out.println();
			cp.pick().print();
					
	}		
}
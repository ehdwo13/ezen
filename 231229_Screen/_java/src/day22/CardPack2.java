package day22;

public class CardPack2 {
	
	private Card2 pack[] = new Card2[52];
	
	public CardPack2() {
		int count =0;
		char shape = '♥';
		for(int i=1; i<=4; i++) {	
			switch(i) {
			case 1 : shape = '♥';
			break;
			case 2 : shape = '◆';
			break;
			case 3 : shape = '♣';
			break;
			case 4 : shape = '♠';
			break;
			}
			for(int j=1; j<=13; j++) {	
				Card2 c = new Card2();
				if(count>12) {
					System.out.println();
					count = 0;
				}
				c.setShape(shape);
				c.setNum(j);
				c.print();
				count++;
				}
			}
	}
	public Card2[] getPack() {
		return pack;
	}
	public void setPack(Card2[] pack) {
		this.pack = pack;
	}
}
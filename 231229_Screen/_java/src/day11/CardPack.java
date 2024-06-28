package day11;

/*	CardPack 클래스
 * 	- ♥1 ~ ♥K / ◆1 ~ ◆K / ♣1 ~ ♣K / ♠1 ~ ♠K
 *  - 총 카드수 52장
 * 	- 52장의 카드 한묶음 (배열)
 * 
 * 	- 카드 출력기능 - Card class print() 사용
 * 	- 카드 초기화 기능(CardPack 생성자)
 * 	- 카드 한장을 빼내는 기능 => 출력 print() 사용
 *  - 카드를 섞는 기능
 * */
public class CardPack {
	//int arr[] = new int[52]; //int 배열안에 들어가는 자료의 형태
	//카드 52장이 들어갈수 있는 배열을 생성
	private Card pack[] = new Card[52];
	private int count = 0; //카드 배열의 index 위치를 체크하기 위한 변수
	
	public CardPack() {
		//CardPack 클래스를 생성하면 52장의 카드가 생성되어야 함.
		//- 숫자 : 1~10,J(11),Q(12),k(13) 
		//- 모양 : ♥, ◆, ♣, ♠
		char shape = '♥';
		for(int i=1; i<=4; i++) {	//4가지 모양
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
			for(int j=1; j<=13; j++) {	//13까지 숫자
				Card c = new Card();	//새로운 카드 1장을 생성
				c.setShape(shape);
				c.setNum(j);
				pack[count]=c;
				count ++;
				}
			}
	}
	
	//카드를 섞는 기능
	//shuffle()
	//리턴타입은 void, 매개변수 X
	public void shuffle() {
		for(int i=0; i<pack.length; i++) {
			int random = (int)(Math.random()*pack.length);
			Card tmp = pack[i];
			pack[i]=pack[random];
			pack[random]=tmp;
		}
	}
	//카드 한장을 빼내는 기능
	//pick()
	//리턴타입 Card[]
	public Card pick() {
		if(count==0) {
			return null;
		}
		count--;
		return pack[count];
	}
	
	//초기화 하는 기능
	public void init() {
		count = 52;
	}
	
	public Card[] getPack() {
		return pack;
	}
	public void setPack(Card[] pack) {
		this.pack = pack;
	}
}
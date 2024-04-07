package day11;

/*	1장의 카드를 생성하기위한 클래스
 * 	- 숫자 :	1~10,J(11),Q(12),k(13) 
 *  - 모양 : ♥, ◆, ♣, ♠
 *  - 한장의 카드를 출력하는 기능 print() ♥1
 *  ex) ◆12 = ◆Q, ♠13 => ♠K, %2 =>♥2(없는모양입력시), &15 => ♥1(모양,숫자둘다 없을시)
 * */
/*	클래스의 구성
 * 	- 멤버변수 : 모양(shape), 숫자(num) => private => getter/setter생성
 * 	- 메서드 : print()
 * 	- 생성자 : 기본 생성자만 생성 => ♥1
 * 	
 * */
 class Card {
	 
	private char shape;
	private int num;
	
	public Card(){
		this.shape = '♥';
		this.num = 1;
	}
	public void print() {
		System.out.print(shape);
		switch (num) {
		case 11 :
			System.out.print("J ");
			break;
		case 12 :
			System.out.print("Q ");
			break;
		case 13 :
			System.out.print("K ");
			break;
		default :
			System.out.print(num+" ");
			break;
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num < 1 || num > 13) {
			this.num = 1;
		}else {
			this.num=num;
		}
	}
	public char getShape() {
		return shape;
	}
	public void setShape(char shape) {
		switch(shape) {
		case '♥': case '◆': case '♣' : case '♠' :
			this.shape=shape;
			break;
		default :
			this.shape='♥';
			}
	}
}
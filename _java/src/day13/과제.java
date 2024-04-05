package day13;

import java.util.Scanner;

//Product 클래스 생성 : 상품을 등록하는 클래스
//상품명, 가격을 멤버변수로 생성
//상품추가 메서드
//상품출력 메서드 (toString 으로 생성가능)
public class 과제 {

	public static void main(String[] args) {
		//상품을 10개 등록 가능한 배열 생성
		//스캐너를 이용하여 상품을 등록받기
		//등록한 상품 출력
		Scanner sc = new Scanner(System.in);
		Product[] menu = new Product[10];
		
		//상품을 등록하시겠습니까(y/n)? y =>등록 / n =>종료
		//n을 누르면 등록한 상품출력
		int count=0;
		
		while(true) {
			System.out.println("상품을 등록하시려면 y"+"\n종료하시려면 n을 입력하세요. ");
			String A = sc.next();
				if(A.equals("n")) {
					System.out.println("상품 리스트"); 
					for(int i=0; i<count; i++) {
						System.out.println(menu[i]+" ");
						}
					break;
				}else if(A.equals("y")) {
					Product p = new Product();
					System.out.println("상품의 이름과 가격을 입력하세요. ");
					p.insertProduct(sc.next(), sc.nextInt());
					menu[count]=p;
					count++;
				}else {
					System.out.println("잘못 누르셨습니다. ");
				}
		}
		sc.close();
	}
}
class Product{
	private String name;
	private int price;
	
	public Product() {}
	
	public Product(String name,int price) {
		this.name = name;
		this.price = price;
	}
	public void insertProduct(String name, int price){
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "이름 = " + name + ", 가격 = " + price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	
}
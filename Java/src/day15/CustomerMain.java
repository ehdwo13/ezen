package day15;

public class CustomerMain {

	public static void main(String[] args) {
		
		
		Customer c = new Customer(1, "홍길동");
		Customer g = new GoldCustomer(2, "가나다");
		Customer v = new VIPCustomer(3,"철수","훈이");
		//다운 캐스팅 : 부모의 공유되는 멤버변수나 메서드가 아닌
		//자식 고유의 멤버변수나 메서드를 호출하고자 할 때 사용
		//다운 캐스팅 : 반드시 명시적으로 형변환 해야함.
		//instanceof : 객체의 형이 맞는지 체크하는 명령어 true / false
	Customer customerList[] = new Customer[] {c,g,v};
		int price = 100000;
		for(int i = 0; i<customerList.length; i++) {
			int salePrice = customerList[i].calcPrice(price);
			System.out.println(customerList[i].getCustomerName()+"님의 지불금액은 "+salePrice+"\n보너스 포인트는 "+customerList[i].getBonusPoint());
		}
		for(int i = 0; i<customerList.length; i++) {
			customerList[i].customerInfo();
		}
		//agentID = 1111 => 3333 변경
		for(int i=0; i<customerList.length; i++) {
			if(customerList[i] instanceof VIPCustomer) {
				VIPCustomer test = (VIPCustomer)v ;
				if(test.getCounslerName().equals("훈이")) {
					test.setCounslerName("영수");
				}
			}
		}
		for(int i = 0; i<customerList.length; i++) {
			customerList[i].customerInfo();
		}
	}
}
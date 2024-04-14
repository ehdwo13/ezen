package sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleManager {
	private ArrayList<Sale<String, Integer>> menu = new ArrayList<>();
	private ArrayList<Order<String, Integer>> order = new ArrayList<>();
	
	public void add(Scanner sc) {
		System.out.println("제품의 이름을 입력해주세요. ");
		String name = sc.next();
		System.out.println("제품의 가격을 입력해주세요. ");
		Integer price = sc.nextInt();
		menu.add(new Sale<String, Integer>(name, price));
		System.out.println("추가 완료. ");
	}
	public void delete(Scanner sc) {
		System.out.println("삭제할 제품의 이름을 입력해주세요. ");
		String name = sc.next();
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getMenu().equals(name)) {
				menu.remove(i);
				System.out.println("삭제 완료. ");
				return;
			}
		}
		System.out.println("검색한 메뉴가 없습니다. ");
	}
	public void modify(Scanner sc) {
		System.out.println("수정할 제품의 이름을 입력해주세요. ");
		String name = sc.next();
		for(int i=0; i<menu.size(); i++) {
			if(menu.get(i).getMenu().equals(name)) {
				System.out.println("1. 이름수정 | 2. 가격수정");
				int pick = sc.nextInt();
				switch(pick) {
				case 1 : System.out.println("수정할 이름을 입력해주세요. "); 
						 menu.get(i).setMenu(sc.next());
						 System.out.println("이름수정완료. ");
						 break;
				case 2 : System.out.println("수정할 가격을 입력해주세요. ");
				         menu.get(i).setPrice(sc.nextInt());
				         System.out.println("가격수정완료. ");
				         break;
				}
			}
		}
	}
	public void menuPrint() {
		for(Sale<String, Integer> tmp : menu) {
			System.out.println(tmp);
		}
	}
	public void orderPick(Scanner sc) {
		Order<String, Integer> o = new Order<>();
		System.out.println("주문하실 제품의 이름을 입력해주세요. ");
		String name = sc.next();
		System.out.println("주문하실 수량을 입력해주세요. ");
		int count = sc.nextInt();
		for(int i =0; i<menu.size(); i++) {
			o.setCount(count);
			if(menu.get(i).getMenu().equals(name)) {
				int index = orderSearch(name);
					if(index != -1) {
						Integer tmpPrice = order.get(i).getTotalPrice();
						int tmpCount = order.get(i).getCount();
						order.get(i).setCount(tmpCount+count);
						order.get(i).setTotalPrice(tmpPrice+menu.get(i).getPrice()*o.getCount());
						System.out.println("주문완료. ");
						return;
					}else if(index == -1) {
						o.setMenu(name);
						o.setTotalPrice(menu.get(i).getPrice()*o.getCount());
						order.add(o);
						System.out.println("주문완료. ");
						return;
					}
				}
			}
	}
	public int orderSearch(String name) {
		int index = -1;
		for(int i=0; i<order.size();i++) {
			if(order.get(i).getMenu().equals(name)) {
				index = i;
				return index;
			}
		}
		return index;
	}
	public void orderPrint(Scanner sc) {
		int sum = 0;
		for(int i=0; i<order.size(); i++) {
			System.out.println("주문내역 : "+order.get(i).getMenu());
			System.out.println("주문갯수 : "+order.get(i).getCount());
			System.out.println("지불금액 : "+order.get(i).getTotalPrice());
			sum +=order.get(i).getTotalPrice();
		}
		System.out.println("총 결제금액 : "+sum);
	}
}
package day19;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleManager {
	private ArrayList<Sale<String, Integer>> menu = new ArrayList<>();
	private ArrayList<Sale<String, Integer>> order = new ArrayList<>();
	
	//제네릭 클래스 
	public void add(Scanner sc) {
		// 제품 추가
		System.out.println("제품의 이름을 입력해주세요. ");
		String name = sc.next();
		System.out.println("제품의 가격을 입력해주세요. ");
		Integer price = sc.nextInt();
		menu.add(new Sale<String, Integer>(name, price));
	}
	public void menuPrint() {
		for(Sale<String, Integer> tmp : menu) {
			System.out.println(tmp);
		}
	}
	public void orderPick(Scanner sc) {
		//	입력받는 값은 제품명, 수량
		//	제품명 가격*수량 (지불금액) 을 order 추가 	
		//	햄버거 5 => 햄버거 25000
	
		int count = 0;
		int price = 0;
		
		System.out.println("주문하실 제품의 이름을 입력해주세요. ");
		String name = sc.next();
		
		System.out.println("주문하실 수량을 입력해주세요. ");
		count = sc.nextInt();
			for(int i =0; i<menu.size(); i++) {
				if(menu.get(i).getMenu().equals(name)) {
					price =count*menu.get(i).getPrice();
					}
				}
		Sale<String, Integer> tmp = new Sale<>();
		tmp.setMenu(name);
		tmp.setPrice(price);
		order.add(tmp);
	}
	public void orderPick(String name, int count) {
		for(int i=0; i<menu.size(); i++) {
			String ProductMenu = menu.get(i).getMenu();
			int ProductPrice = menu.get(i).getPrice();
			if(ProductMenu.equals(name)) {
				int index = orderSearch(name);
				if(index != -1) {
					int price = order.get(index).getPrice();
					order.get(index).setPrice(price+(ProductPrice*count));
					return;
				}
				Sale<String, Integer> p = new Sale<>(ProductMenu, (ProductPrice*count));
				order.add(p);
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
		// 주문내역 출력
		// 총 지불 금액 출력
		int sum = 0;
		for(Sale<String, Integer> tmp : order) {
			System.out.println(tmp);
			sum += (int)tmp.getPrice();
		}
		System.out.println("총지불금액 : "+sum);
	}
}
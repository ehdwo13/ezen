package sale;

public class Order<K, V> extends Sale<String, Integer> {
	private int count;
	private int totalPrice;
	
	public Order() {}
	
	public Order(String menu, Integer price) {
		super(menu, price);
		this.totalPrice=price*count;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
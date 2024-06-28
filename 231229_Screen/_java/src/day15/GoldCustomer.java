package day15;

public class GoldCustomer extends Customer {
	private double saleRatio;
	public GoldCustomer() {}
	
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade="Gold";
		bonusRatio=0.02;
		saleRatio = 0.10;
	}
	@Override
	public int calcPrice(int price) {
		super.calcPrice(price);
		price = price-(int)(price*saleRatio);
		return price;	
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
}
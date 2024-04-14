package day15;

public class VIPCustomer extends Customer{
	
	private double saleRatio;
	private String counslerName;
	
	public VIPCustomer() {}
	public VIPCustomer(int customerID, String customerName, String counslerName) {
		super(customerID, customerName);
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.10;
		this.counslerName=counslerName;
	}
	@Override
	public int calcPrice(int price) {
		super.calcPrice(price);
		price = price-(int)(price*saleRatio);
		return price;	
	}
	@Override
	public void customerInfo() {
		super.customerInfo();
		System.out.println("VIP고객님"+customerName+"의 상담사 이름은 "+counslerName+"입니다. ");
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public String getCounslerName() {
		return counslerName;
	}
	public void setCounslerName(String counslerName) {
		this.counslerName = counslerName;
	}
}
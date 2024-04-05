package day15;

public class Customer {

	public int customerID;
	public String customerName;
	public String customerGrade;
	public int bonusPoint;
	public double bonusRatio;
	
	//생성자
	public Customer() {}
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "Silver";
		bonusRatio = 0.01;
	}
	//메서드
	public int calcPrice(int price) {
		bonusPoint+=(int)(price * bonusRatio);
		System.out.println(customerName+"님의 보너스 적립"+bonusPoint+"원");
		System.out.println("세일된 물건의 가격은 ↓ ");
		return price;	
	}
	public void customerInfo() {
		System.out.println(customerName+"님의 등급은 "+customerGrade+"이며, 보너스 포인트는 "+bonusPoint+"입니다. ");	
	}
	//getter/setter
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBonusPoint() {
		return bonusPoint;
	}
	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	//toString
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerGrade="
				+ customerGrade + ", bonusPoint=" + bonusPoint + ", bonusRatio=" + bonusRatio + "]";
	}
}
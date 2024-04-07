package bookStore;

public class Customer{
	public String customerID;			//회원아이디
	public String customerPassWord;		//비밀번호
	public String customerName;			//이름
	public String customerGrade;		//등급
	public int bonusPoint;				//보너스포인트
	public double bonusRatio;			//보너스적립비율
	public double saleRatio;			//할인율
	
	public Customer() {}
	
	
	public Customer(String customerID, String customerPassWord, String customerName) {
		super();
		this.customerID = customerID;
		this.customerPassWord = customerPassWord;
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "ID : "+customerID+"이름 : "+customerName +"등급 : " +customerGrade+"현재 포인트 : "+bonusPoint +"보너스적립률 : "
				+bonusRatio+"할인률 : "+saleRatio;
	}
	public void NewCustomer(String a, String b, String c) {
		customerID = a;
		customerPassWord = b;
		customerName = c;
	}
	public void customerInfo() {
		System.out.println(toString());
	}
	public int priceCal(int price) {
		bonusPoint+=(int)(price * bonusRatio);
		price = price-(int)(price*saleRatio);
		return price;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getCustomerPassWord() {
		return customerPassWord;
	}
	public void setCustomerPassWord(String customerPassWord) {
		this.customerPassWord = customerPassWord;
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
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}
	public class Bronze extends Customer{

		public Bronze(String customerID, String customerPassWord, String customerName) {
			super(customerID, customerPassWord, customerName);
			customerGrade = "Bronze";
			bonusPoint = 0;
			bonusRatio = 0.01;
			saleRatio = 0.01;	
		}
		@Override
		public int priceCal(int price) {
			return super.priceCal(price);
		}
	}
	public class Silver extends Customer {
		public Silver(String customerID, String customerPassWord, String customerName) {
			super(customerID, customerPassWord, customerName);
			customerGrade = "Silver";
			bonusPoint = 0;
			bonusRatio = 0.03;
			saleRatio = 0.03;	
		}
		@Override
		public int priceCal(int price) {
			return super.priceCal(price);
		}
	}
	public class Gold extends Customer{
		public Gold(String customerID, String customerPassWord, String customerName) {
			super(customerID, customerPassWord, customerName);
			customerGrade = "Gold";
			bonusPoint = 0;
			bonusRatio = 0.05;
			saleRatio = 0.05;	
		}
		@Override
		public int priceCal(int price) {
			return super.priceCal(price);
		}
	}
	public class Vip extends Customer{
		public Vip(String customerID, String customerPassWord, String customerName) {
			super(customerID, customerPassWord, customerName);
			customerGrade = "Vip";
			bonusPoint = 0;
			bonusRatio = 0.1;
			saleRatio = 0.1;	
		}
		@Override
		public int priceCal(int price) {
			return super.priceCal(price);
		}
	}
}
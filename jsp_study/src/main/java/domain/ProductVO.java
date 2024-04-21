package domain;

public class ProductVO {
	private int pnum;
	private String category;
	private String name;
	private int price;
	private int total_amount;
	private int sale_amount;
	private String regdate;
	
	public ProductVO() {}

	//상품등록 생성자
	public ProductVO(String category, String name, int price, int total_amount) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.total_amount = total_amount;
	}
	//간단출력 생성자
	public ProductVO(String category, String name, int price, int total_amount, String regdate) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.total_amount = total_amount;
		this.regdate = regdate;
	}
	//상품수정 생성자
	public ProductVO(String category, String name, int price, int total_amount, int sale_amount) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.total_amount = total_amount;
		this.sale_amount = sale_amount;
	}
	//리스트 출력 생성자
	public ProductVO(int pnum, String category, String name, int price, int total_amount, int sale_amount, String regdate) {
		this.pnum = pnum;
		this.category = category;
		this.name = name;
		this.price = price;
		this.total_amount = total_amount;
		this.sale_amount = sale_amount;
		this.regdate = regdate;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getSale_amount() {
		return sale_amount;
	}

	public void setSale_amount(int sale_amount) {
		this.sale_amount = sale_amount;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "ProductVO [pnum=" + pnum + ", category=" + category + ", name=" + name + ", price=" + price
				+ ", total_amount=" + total_amount + ", sale_amount=" + sale_amount + ", regdate=" + regdate + "]";
	}
	
	
}

package day20;

public class Customer implements Comparable<Customer>{
	private String name;
	private int age;
	private int money;
	
	public Customer() {}
	
	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		if(getAge()>=15) {
			this.money = 100;
		}else {
			this.money = 50;
		}	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", money=" + money + "]";
	}

	@Override
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
}
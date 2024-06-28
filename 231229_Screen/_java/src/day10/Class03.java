package day10;

public class Class03 {

	public static void main(String[] args) {
		//Car1 클래스를 통해 my객체를 생성 new 키워드를 통해 생성 Car1()생성자에 의해 초기화 된다.
		Car1 my = new Car1();
		my.setName("산타페");
		my.setYear("2022");
		my.setColor("회색");
		my.setDoor(4);
		System.out.println(my.isPower());
		my.print();
		my.speedDown();
		my.speedUp();
		my.power();
		System.out.println(my.isPower());
		my.speedUp();
		my.power();
		my.speedUp();
		my.speedUp();
		my.speedUp();
		my.doorStatus();
		my.speedUp();
		my.doorStatus();
		my.speedDown();
		my.doorStatus();
		
		Car1 my2 = new Car1("스파크","2023");
		my2.print();
		
		Car1 my3 = new Car1("소나타", "2021", "검정", 4);
		my3.print();
			
		
	}
}
//같은 패키지에서 같은 이름의 클래스를 사용하면 error	(접근제한자를 default 로 설정해서)
class Car1{
	
	//멤버변수 : name, year, color, door(문짝개수), power, speed, doorStatus
	private String name;
	private String year;
	private String color;
	private int door;
	private boolean power;
	private int speed;
	private boolean doorStatus;
	
	//생성자 위치
	public Car1(){	//기본 생성자
		
	}
	//생성자는 여러개 만들수 있음(생성자 오버로딩)
	//오버로딩 조건 : 매개변수의 개수가 달라야함, 타입이 달라야함
	public Car1(String name, String year, String color, int door){
		this(name,year);	//생성자 호출
		this.color=color;
		this.door=door;
	}
	public Car1(String name, String year) {
		this.name=name;
		this.year=year;
	}
	
	{
		//원하는 멤버변수의 값을 초기화
		color = "red";
		door = 4;
		
	}
	//내 차량의 정보를 출력하는 메서드 (name, year, color, door)
	public void print() {
		System.out.println("내 차량의 정보 : "+color+name+"("+year+")\n"+"문짝개수 : "+door+"개");
	}
	//power()
	//시동이 켜졌습니다.	/시동이 꺼졌습니다.
	public void power() {
		if(speed>0) {
			System.out.println("주행중에는 시동을 끌 수 없습니다. ");
		}else if(power!=true) {
			power=!power;
			System.out.println("시동이 켜졌습니다. ");
		}else {
			power=!power;
			System.out.println("시동이 꺼졌습니다. ");
		}
	}
	//창문 여는 메서드
	//doorStatus
	public void doorStatus() {
		if(speed>=50) {
			System.out.println("속도가 50이상일 땐 창문을 열 수 없습니다. ");
		}else if(doorStatus!=true) {
			doorStatus=!doorStatus;
			System.out.println("창문을 열었습니다. ");
		}else {
			doorStatus=!doorStatus;
			System.out.println("창문을 닫았습니다. ");
		}
	}
	//speedUp / Down 의 기본조건은 power가 켜져야 가능.
	//시동이 꺼져있는 상태라면 시동이 꺼져있습니다. 시동을 켜주세요. 출력
	//speedUp
	//300이상이면 최고속도입니다.라고 출력
	//속도가 얼마이상일때 door on off 불가
	//속도가 있는상태일때 power 값변경불가능 조건
	//현재속도를 출력
	public void speedUp() {
		if(isPower()==false) {
			System.out.println("시동이 꺼져잇습니다. 시동을 켜주세요. ");
		}else {
				if(speed>=300) {
					speed=300;
					System.out.println("최고 속도입니다. ");
				}else {
					speed +=10;
					System.out.println("현재속도는 "+getSpeed());
				}
			}
		
		}
	//speedDown
	//속도가 0이 되면 더이상 내려가지 않음. (멈췄습니다.)
	//현재속도 얼마인지 출력
	public void speedDown() {
		if(isPower()==false) {
			System.out.println("시동이 꺼져잇습니다. 시동을 켜주세요. ");
		}else {
			if(speed<=0) {
				speed=0;
				System.out.println("멈췄습니다. ");
			}else {
				speed -=10;
				System.out.println("현재속도는 "+speed);
			}
		}
	}
	//getter / setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getDoor() {
		return door;
	}
	public void setDoor(int door) {
		this.door = door;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isDoorStatus() {
		return doorStatus;
	}
	public void setDoorStatus(boolean doorStatus) {
		this.doorStatus = doorStatus;
	}
}
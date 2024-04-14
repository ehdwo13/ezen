package day16;

import java.util.Calendar;
//import java.util.Date;

public class Date01 {

	public static void main(String[] args) {
		/*	날짜/시간 클래스
		 * 	Data 클래스 => Deprecated(비권장) / Calendar 클래스
		 * 	Calendar : 추상클래스	//추상클래스는 객체를 생성할 수 없음.
		 * 	추상클래스를 구현한 객체를 이용하여 사용
		 * 	new 로 객체 생성 불가능
		 * 	getinstance() 메서드를 이용하여 객체를 얻어옴.
		 * 	static 메서드. 클래스명. 메서드명()
		 * 
		 * */
//		Date d = new Date();
		Calendar c = Calendar.getInstance();	//오늘의 날짜 리턴
		int year = c.get(Calendar.YEAR);
		System.out.println(year);
		//월 0~11까지 +1 표현
		int month = c.get(Calendar.MONTH)+1;
		System.out.println(month);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
		int week = c.get(Calendar.DAY_OF_WEEK);//일~토까지
		String dayOfWeek = null;
		switch(week) {
		case 1 : dayOfWeek="일"; break;
		case 2 : dayOfWeek="월"; break;
		case 3 : dayOfWeek="화"; break;
		case 4 : dayOfWeek="수"; break;
		case 5 : dayOfWeek="목"; break;
		case 6 : dayOfWeek="금"; break;
		case 7 : dayOfWeek="토"; break;
		}
		System.out.println(year+"-"+month+"-"+day+"("+dayOfWeek+")");
		System.out.println(((c.get(Calendar.AM_PM)==0)?"오전":"오후")+" "+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
	}
}
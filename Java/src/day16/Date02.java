package day16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date02 {

	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.getYear());
		//날짜 /시간
		String t = today.toString(); //toString() 스트링으로 객체를 변환
		System.out.println(t);
		String day = t.substring(0, t.indexOf("T"));	
		String time = t.substring(t.indexOf("T")+1,t.indexOf("."));
		System.out.println(day);
		System.out.println(time);
		
		DateTimeFormatter dtf = DateTimeFormatter
				.ofPattern("yyyy/MM/dd hh:mm:ss");
		System.out.println(dtf.format(today));
		
		LocalDateTime sDate = LocalDateTime.of(2002, 3, 1, 2, 4);
		System.out.println(sDate.format(dtf));
	}
}

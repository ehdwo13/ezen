package day02;

public class MathClass {

	public static void main(String[] args) {
		/*	Math.method
		 * 	Math.round(반올림) : 소수자리수는 무조건 0
		 * 	Math.ceil(올림) : Math.floor(버림)
		 * */
		
		double num = 3.14111;	//반올림 3 / 올림 4 / 버림 3
		int roundNum = (int)Math.round(num); //return long 형변환
		System.out.println(roundNum);
		int ceilNum = (int)Math.ceil(num);	//return double 형변환
		System.out.println(ceilNum);
		int floorNum = (int)Math.floor(num); //return double 형변환
		System.out.println(floorNum);
		
		//Math.max(최대값), Math.min(최소값)
		System.out.println(Math.max(5, 3));
		System.out.println(Math.min(5, 3));
		
		//Math.random : 0과 1사이의 아무값을 출력
		// 0 <= Math.random() < 1
		System.out.println(Math.random());//0은 포함 1은 미포함
		//	((int)(Math.random()*count)+start //start 부터 count 까지의 랜덤수를 얻는 공식
		System.out.println(Math.random()*10);
		System.out.println((int)(Math.random()*10));
		System.out.println((int)(Math.random()*10)+1);
		System.out.println((int)(Math.random()*6)+1);
	}

}
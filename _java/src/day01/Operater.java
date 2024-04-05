package day01;

public class Operater {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	/*	연산자 정리
	 *  대입연산자 : =, +=, -= ...
	 *  =을 기준으로 오른쪽에 있는 값을 왼쪽의 변수에 저장
	 * 	왼쪽의 값은 반드시 변수여야 함.
	 * 	a=b; a값을 b에 저장
	 * 	1=a; (x) 
	 * 	a += 1 => a=a+1		//기존 값과 1을 더해서 a에 저장
	 * */
		int a=10;
		int b= 5;
		a=b;
		System.out.println(a);
		a+=10;
		System.out.println(a);
		
		//증감연산자 : ++(1증가) / --(1감소)
		a++;
		System.out.println(a);
		System.out.println(a++); //출력 후 1증가
		System.out.println(++a); //1증가 후 출력
		
		//산술연산자 : + - * / %(나머지)
		/* 나누기(/)
		 * 정수 / 정수 = 정수 (10/3 = 3) 소수점을 버림
		 * 정수 / 실수 = 실수
		 * 실수 / 정수 = 실수
		 * 실수 / 실수 = 실수
		 * 
		 * 값 / 0 => 예외발생(exception)
		 * 자료형이 double / 0 => infinity 
		 * */		
		System.out.println("3+2="+(3+2));
		System.out.println("3-2="+(3-2));
		System.out.println("3*2="+(3*2));
		System.out.println("3/2="+(3/2.0));
		System.out.println("3%2="+(3%2));
		
		/*	비교연산자 : 비교연산의 결과는 반드시 true / false
		 * 	>= (이상), <= (이하), >(초과), <(미만), ==(같다), !=(같지않다)
		 * 	3 >= 5 => false
		 *	논리연산자 : && || ! 
		 * 	a && b : (and)둘다 true여야 true를 return
		 * 	a || b : (or) 둘중 하나만 true여도 true를 리턴
		 *	!a : (not) a 상태 반대
		 * 
		 * 
		 * */
		System.out.println("3>2 ? "+ (3>2));
		System.out.println("3<2 ? "+ (3<2));
		System.out.println("3==2 ? "+ (3==2));
		System.out.println("3!=2 ? "+ (3!=2));
		System.out.println("&& 연산자 : "+(3>2 && 4>3));
		System.out.println("|| 연산자 : "+(3>2 || 4<3));
		
		/*	조건선택 연산자 : 3항연산자
		 * 	(조건식)? true : false; 
		 * */
		System.out.println((3<2)? "참입니다." : "거짓입니다.");
		
		/*	문제 : num의 변수를 선언하여 값을 입력하고,
		 * num가 짝수인지 홀수인지 판별
		 * 조건 선택 연산자 사용하여 출력
		 * */
		int num = 4, left = num % 2;
		System.out.println((left==0)? "짝수입니다." : "홀수입니다.");
		String result = (num % 2 ==0)? "짝수" : "홀수";
		System.out.println(num+"는 > "+result);
	}
}
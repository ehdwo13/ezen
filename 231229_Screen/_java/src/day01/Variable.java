package day01;

public class Variable {

	public static void main(String[] args) {
/*	변수 선언
 * 	자료형(타입) 변수명;
 * 
 * 	변수 선언 + 초기화;
 * 	자료형(타입) 변수명 = 값;
 * 
 * /
 */
		int num = 123; //선언 + 초기화
		System.out.println(num);

		//int num = 456; //변수는 중복 선언 불가능.
		
		int num1 = 12, num2 = 34, num3 = 56; //같은 자료형의 한줄선언 가능.
		System.out.println(num1);
		num1 = 78;  //=(대입연산자) 오른쪽의 값을 왼쪽의 변수에 저장(덮어쓰기)
		System.out.println(num1);
		
		// 8개의 기본 자료형은 지역변수(scope)  {  }안에서만 가능
		{
			int num4 = 12;	//선언문만 빼주면 가능
			System.out.println(num4);
		}
		//System.out.println(num4); 괄호밖이라 인식못함
		System.out.println(num3); //위 괄호안이라 인식함
		
		//한글자만 저장가능한 char
		//"문자열", 숫자, char 'a'
		//string  ("문자열") / char('한글자만 가능')
		
		char ch = 'a';
		System.out.println(ch);
		
		double dou = 3.1;
		System.out.println(dou);
		
		byte b = 1;
		System.out.println(b);
		
		boolean boo = true;		//ture, false 로만 저장가능
		System.out.println(boo);
		
		//float / long 자료형은 접미사를 붙여야 사용가능.
		//float(f F) long(l L)
		
		float f = 1.2f;
		long l = 1L;
		System.out.println(f);
		System.out.println(l);
		
		num1 = 010; //8진수로 인식(0~7까지 8은 10을 의미)
		//10진수 (0~9 10은 10) 	/ 	16진수 (0~9 (ABCDEF)
		System.out.println(num1);
		num2 = 0x10; //16진수로 인식
		System.out.println(num2);
		
	// + 더하기 	- 빼기 	* 곱하기 	 / 나누기 	 %(나머지)
		num1 = 10;
		num2 = 20;
		System.out.println(num1 % num2);
		
		//국어점수(kor), 영어점수(eng), 수학점수(math) 변수로 선언하고,
		//값을 입력하여, 세 점수의 합을 콘솔에 출력
		
		int kor = 80, eng = 70, math = 90;
		int sum = kor+eng+math;
		// + : 숫자 + 숫자 = 숫자(더하기연산자)
		// + : 숫자 + 문자 = 문자(연결연산자)
		System.out.println("합계:"+sum);
		System.out.println("평균:"+sum/3.0); //	 정수/정수 는 정수 실수표현해주려면 하나이상은 실수로 표현

		int a = 10;
		a += 10; //a = a +10  같은의미(대입연산자)
		System.out.println(a++); //찍고 더해라
		System.out.println(++a); //더하고 찍어라
		//++ 증강연산자
		
	}

}

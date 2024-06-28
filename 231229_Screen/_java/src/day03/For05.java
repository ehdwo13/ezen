package day03;

public class For05 {

	public static void main(String[] args) {
		/*	약수는 1부터 자기자신까지 나누어서 떨어지는 수
		 * 	6의 약수 : 1 2 3 6
		 * 	12의 약수 : 1 2 3 4 6 12
		 * 
		 * 	두 수의 공약수 : 1 2 3 6
		 * 	그 공약수 중 가장 큰값은 최대공약수 : 6
		 * 	
		 * */
		int num1 = 6, num2 = 12;
		int max = 0;
		for(int i=1; i<=num1; i++) {
			if(num1 % i== 0 && num2 % i ==0){	 //공약수 1236
				max = i;
			}	
		}
		System.out.println(max);
		
		//	break; 
		//	반복문에서 조건이 맞다면 반복문을 빠져나오는 역할
		
		for(int i=num1; ; i--) {
			if(num1 % i== 0 && num2 % i ==0) {
				System.out.println(i);
				break;
			}
		}
		//중첩 for문 일 경우 break 는 나를 감싸고 있는 가장 안쪽 for 문을 벗어남.
		//for 문에 이름을 정해줌 a: for
		int i=0;
		 for(;;) {
			for(;;) {
				for(;;) {
					i++;
					if(i==10) {
						System.out.println(i);
						break ;
					}
				}
			}
		}
		
	}
}
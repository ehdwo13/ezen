package Pratice;

public class 랜덤배열 {

	public static void main(String[] args) {
		/*	arr 배열의 값을 1~50 사이의 숫자로 중복안되게 랜덤으로 입력받아 합계와 평균을 출력
		 *  최대값/ 최소값 출력
		 *  Math.max Math.min
		 *  if문 
		 * */
		int arr[] = new int[10] ;
		for(int i =0; i<arr.length; i++) {				
			arr[i]=(int)(Math.random()*50)+1;
			for(int j=0; j<i; j++) {
				if(arr[j]==arr[i]) {					
					i--;
					break;
				}
			}
		}
		int sum = 0;
		double avg = 0;
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, arr[i]);	
			min = Math.min(min, arr[i]);	
			}
		avg=sum/(double)arr.length;
		System.out.println("합계는 "+sum+" 입니다. ");
		System.out.println("평균은 "+avg+" 입니다. ");
		System.out.println("최대값은 "+max+"입니다. ");
		System.out.println("최소값은 "+min+"입니다. ");
		}
}
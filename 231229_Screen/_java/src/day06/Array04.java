package day06;

public class Array04 {

	public static void main(String[] args) {
		/*	10개의 값을 가지는 배열을 생성한 후
		 * 	1~50사이의 랜덤수를 배열에 저장 한 후
		 * 	합계, 평균, 최대, 최소 출력
		 * */
		int arr[] = new int[10];
		int sum = 0;
		double avg = 0;
		int max = 0;
		int min = 50;		
			
		for(int i=0; i<arr.length; i++) {				//배열의 완성
			int random = ((int)(Math.random()*50)+1);
			arr[i] = random;
			System.out.print(arr[i]+" ");
		}
		for(int i=0; i<arr.length; i++) {				//배열에서 탐색
			sum += arr[i];
			max = Math.max(max, arr[i]);	
			min = Math.min(min, arr[i]);
			}
		avg=sum/(double)arr.length;
	
		System.out.println("합계 : "+sum+" / 평균 : "+avg);
		System.out.println("최대값 : "+max+" / 최소값 : "+min);
	}
}
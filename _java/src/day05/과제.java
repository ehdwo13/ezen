package day05;

public class 과제 {

	public static void main(String[] args) {
		
		int arr[] = new int[] {56,10,78,89,48,62,93,50};
		/*	arr 배열의 합계와 평균을 출력
		 *  최대값/ 최소값 출력
		 *  Math.max Math.min
		 *  if문 
		 * */
		int sum = 0;
		double avg = 0;
		int max = arr[0];
		int min = arr[0];
		
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			max = Math.max(max, arr[i]);	//Math.max 사용
			min = Math.min(min, arr[i]);	//Math.min 사용
//			if(arr[i]>max) {	//if 문
//				max=arr[i];
//				}
//			if(arr[i]<min) {
//				min=arr[i];
//			}
		}
		avg=sum/(double)arr.length;
		System.out.println("합계는 "+sum+" 입니다. ");
		System.out.println("평균은 "+avg+" 입니다. ");
		System.out.println("최대값은 "+max+"입니다. ");
		System.out.println("최소값은 "+min+"입니다. ");
		}
}
package day06;

public class ArrayEx01 {

	public static void main(String[] args) {
		/*	10개의 배열을 담을 수 있는 arr생성
		 * 	1~10까지 값을 입력한 후 출력
		 * 	
		 * */
		int arr[]=new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//	배열을 섞는 코드
		//	랜덤 번지를 선택해서 순차적으로 하나씩 교환 
		//	int random = ((int)Math.random()*10)+0; 	//0부터 10개의 랜덤수 출력
		//	max = 최종번지개수, min = 첫번째번지
		//	교환 코드 
		//	[i][i+1]
		//	int tmp = arr[i];
		//	arr[i]=arr[i+1];
		//	arr[i+1]= tmp;
		
		int min = 0;
		int max = arr.length;
		for(int i=0; i<arr.length; i++) {
			int random = (int)(Math.random()*max)+min;
			int tmp = arr[i];
			arr[i]=arr[random];
			arr[random]=tmp;
		}
		System.out.println("---섞은 후 값 보기---");
		
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
		
		//	섞은 값을 원래대로 정리(정렬)
		//	작은 수 부터 정리 = 오름차순정렬
		// 	큰수부터 정리 = 내림차순 정렬
		System.out.println();
		System.out.println("오름 차순 정렬");
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {			// > 오름차순 	/ < 내림차순
					int tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		for(int tmp : arr) {
			System.out.print(tmp+" ");
		}
	}
}

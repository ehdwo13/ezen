package day08;

public class Method06 {

	public static void main(String[] args) {
		
		int arr[] = new int[] {1,6,7,4,3,9,2,10,15,8,13,34,13,13,61,16,13};
		printArray(arr);
		System.out.println();
		sortArray(arr);
		System.out.println("---정렬 후---");
		printArray(arr);
		System.out.println();
		System.out.println("---배열리턴---");
		printArray(sortArray1(arr));
		System.out.println("---랜덤출력---");
		printArray(sortArray1(randomArray()));
	}
	
	/*	주어진 정수배열을 콘솔에 출력하는 메서드
	 * 	매개변수 : 배열
	 * 	리턴타입 : 출력 => void
	 * 	메서드명 : printArray
	 * 	5개씩 한줄에 나열
	 * */
	public static void printArray(int arr[]) {
		
		for(int i=0; i<arr.length; i++) {
			if(i%5==0 && i !=0) {
				System.out.println();
				}
			System.out.print(arr[i]+" ");
			}
	}
	/*	배열이 주어지면 배열을 오름차순 정렬하는 기능
	 * 	메개변수 : 배열
	 * 	리턴타입 : 없음 => void
	 * 	메서드명 : sortArray
	 * 
	 * */
	public static void sortArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]) {
					int tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
	}
	
	//	정렬 후 배열 리턴
	//	 
	public static int[] sortArray1(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++){
				if(arr[i]>arr[j]) {
					int tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		return arr;
	}
	
	/*	randomArray
	 * 	배열을 생성해서[10] 랜덤값(1~50까지)을 채우고
	 * 	해당 배열을 리턴
	 * 	printArray로 출력
	 * */
	
	public static int[] randomArray() {
		int arr[] = new int[10];
		for (int i=0; i<arr.length; i++) {
			int random = ((int)(Math.random()*50)+1);
			arr[i]=random;
			}
		return arr;
		}
}